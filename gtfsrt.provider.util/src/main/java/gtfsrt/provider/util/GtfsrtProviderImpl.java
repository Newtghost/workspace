/**
 * Copyright (C) 2012 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gtfsrt.provider.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.onebusway.gtfs_realtime.exporter.GtfsRealtimeExporterModule;
import org.onebusway.gtfs_realtime.exporter.GtfsRealtimeLibrary;
import org.onebusway.gtfs_realtime.exporter.GtfsRealtimeMutableProvider;
import org.onebusway.gtfs_realtime.exporter.GtfsRealtimeProvider;

import com.google.transit.realtime.GtfsRealtime.FeedEntity;
import com.google.transit.realtime.GtfsRealtime.FeedMessage;
import com.google.transit.realtime.GtfsRealtime.TripDescriptor;
import com.google.transit.realtime.GtfsRealtime.TripUpdate;
import com.google.transit.realtime.GtfsRealtime.TripUpdate.Builder;
import com.google.transit.realtime.GtfsRealtime.TripUpdate.StopTimeEvent;
import com.google.transit.realtime.GtfsRealtime.TripUpdate.StopTimeUpdate;

/**
 * This class produces GTFS-realtime trip updates by
 * periodically polling the TriMet website, the goal is to
 * be able to modify the original GTFS-RT.
 * 
 * Since this class implements {@link GtfsRealtimeProvider}, it will
 * automatically be queried by the {@link GtfsRealtimeExporterModule} to export
 * the GTFS-realtime feeds to file or to host them using a simple web-server, as
 * configured by the client.
 * 
 * @author bdferris
 * 
 */
@Singleton
public class GtfsrtProviderImpl {

	private static final int TIMEOUT_CONNECTION = 5000;
	private static final int TIMEOUT_SOCKET = 5000;
	
	private ScheduledExecutorService _executor;

	private GtfsRealtimeMutableProvider _gtfsRealtimeProvider;
	
	private Map<String, Trip> trips ;

	/* How often vehicle data will be downloaded, in seconds */
	private int _refreshInterval = 30;

	public void setTrips(Map<String, Trip> trips) {
		this.trips = trips;
	}

	@Inject
	public void setGtfsRealtimeProvider(GtfsRealtimeMutableProvider gtfsRealtimeProvider) {
		_gtfsRealtimeProvider = gtfsRealtimeProvider;
	}

	public void setRefreshInterval(int refreshInterval) {
		_refreshInterval = refreshInterval;
	}

	/**
	 * The start method automatically starts up a recurring task.
	 */
	@PostConstruct
	public void start() {
		_executor = Executors.newSingleThreadScheduledExecutor();
		_executor.scheduleAtFixedRate(new RefreshTask(), 0,
				_refreshInterval, TimeUnit.SECONDS);
	}

	@PreDestroy
	public void stop() {
		_executor.shutdownNow();
	}

	/**
	 * This method read the GTFS-RT feed available on the TriMet website,
	 * and create another GTFS-RT feed with some modified trip updates.
	 */
	private void refreshGTFSRealtime() throws IOException {
		
		/* The FeedMessage.Builder is what we will use to build up our GTFS-RT feed */
		FeedMessage.Builder tripUpdates = GtfsRealtimeLibrary.createFeedMessageBuilder();

		try {    	

			/* Read the TriMet GTFS-RT feed */
			HttpGet httpget = new HttpGet("http://developer.trimet.org/ws/V1/TripUpdate/appID/C725DEA31C7A28B860DC29BBA");    	        
			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT_CONNECTION);
			HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_SOCKET);
			DefaultHttpClient httpclient = new DefaultHttpClient();
			httpclient.setParams(httpParams);
			HttpResponse response = httpclient.execute(httpget);
			if(response.getStatusLine().getStatusCode() != 200) return;
			HttpEntity entity = response.getEntity();
			if (entity == null) return;

			InputStream is = entity.getContent();
			if (is != null) {
				// Decode message
				FeedMessage feedMessage = FeedMessage.parseFrom(is);
				List<FeedEntity> feedEntityList = feedMessage.getEntityList();

				// Header
				tripUpdates.setHeader(feedMessage.getHeader());      

				for (FeedEntity feedEntity : feedEntityList) {
					if (feedEntity.hasTripUpdate()) {                    	
						TripUpdate update = feedEntity.getTripUpdate() ;

						TripDescriptor trip = update.getTrip() ;   

						/* Deleting trip updates already contained in the original feed */
						if (trips.containsKey(trip.getTripId())) continue ;
						
						/**
						 * Create a new feed entity to wrap the trip update and add it to the
						 * GTFS-realtime trip updates feed.
						 */
						FeedEntity.Builder tripUpdateEntity = FeedEntity.newBuilder();
						tripUpdateEntity.setId(feedEntity.getId());
						tripUpdateEntity.setTripUpdate(update);

						tripUpdates.addEntity(tripUpdateEntity);
					}
				}
				
				Trip t ;
				TripDescriptor.Builder tripDescriptor ;
				TripUpdate.Builder tripUpdate ;
				FeedEntity.Builder tripUpdateEntity ;
				for (String s : trips.keySet()) {
					t = trips.get(s) ;
					tripDescriptor = TripDescriptor.newBuilder();
					tripDescriptor.setTripId(s);
					tripUpdate = addDelayForTrip (tripDescriptor, t.getDelay(), t.getNb_sequences()) ; // update.getStopTimeUpdateCount()) ;
					tripUpdateEntity = FeedEntity.newBuilder();
					tripUpdateEntity.setId(tripDescriptor.getTripId());
					tripUpdateEntity.setTripUpdate(tripUpdate);
					tripUpdates.addEntity(tripUpdateEntity);
				}
				
			}
		} catch (Exception e) {
			System.err.println("Error while loading GTFS RT feed") ;
		}

		/* Build out the final GTFS-realtime feed messages and save them */
		_gtfsRealtimeProvider.setTripUpdates(tripUpdates.build());

	}

	private Builder addDelayForTrip(TripDescriptor.Builder trip, int delay, int nbSequences) {
		TripUpdate.Builder tripUpdate = null ;
		tripUpdate = TripUpdate.newBuilder();
		tripUpdate.setTrip(trip);
		// Create / modify all stop sequences to be consistent
		for (int i = 1 ; i <= nbSequences ; i++) {
			StopTimeEvent.Builder arrivalBuilder = StopTimeEvent.newBuilder();
			arrivalBuilder.setDelay(delay);

			StopTimeUpdate.Builder stopTimeUpdate = StopTimeUpdate.newBuilder();
			stopTimeUpdate.setArrival(arrivalBuilder);
			stopTimeUpdate.setStopSequence(i);

			tripUpdate.addStopTimeUpdate(stopTimeUpdate);
		}
		System.out.println("Delay updated for the trip ID : " + trip.getTripId()) ;
		return tripUpdate;
	}

	private class RefreshTask implements Runnable {
		@Override
		public void run() {
			try {
				refreshGTFSRealtime();
			} catch (Exception ex) {
				System.err.println("Error in RefreshTask.") ;
			}
		}
	}

}
