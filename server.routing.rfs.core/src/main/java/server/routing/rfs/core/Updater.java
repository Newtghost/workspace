package server.routing.rfs.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import routing.Connection;
import routing.RoutingFactory;

import com.google.transit.realtime.GtfsRealtime.FeedEntity;
import com.google.transit.realtime.GtfsRealtime.FeedMessage;
import com.google.transit.realtime.GtfsRealtime.TripDescriptor;
import com.google.transit.realtime.GtfsRealtime.TripUpdate;
import com.google.transit.realtime.GtfsRealtime.TripUpdate.StopTimeUpdate;

/* This class maintain up-to-date a list of all connections delayed indexed with their trip ID */
public class Updater {

	private static final Logger LOG = LoggerFactory.getLogger(Router.class);
	
	private static final boolean LOCAL = true ;

	public static final int REFRESH_INTERVAL = 10; 
	
	private ScheduledExecutorService executor;
	
	private Map<String, List<Connection>> updatedConnections = null ;
	private List<Connection> connectionsToUpdate = null ;
	private Lock updateLock;
		
	public Map<String, List<Connection>> getUpdatedConnections () {
		if (updatedConnections == null) return null ;
		return new HashMap<>(updatedConnections) ; /* Return a copy, avoid side effects */
	}

	public void setConnectionsToUpdate (List<Connection> connectionsToUpdate, Lock updateLock) {
		this.connectionsToUpdate = connectionsToUpdate ;
		this.updateLock = updateLock ;
	}
	
	public void start() {
		executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(new RefreshTask(), 0, REFRESH_INTERVAL, TimeUnit.SECONDS);
	}

	public void stop() {
		executor.shutdownNow();
	}

	public void updateConnections () throws IOException {
		
		if (connectionsToUpdate == null) return ;

		/* Read the TriMet GTFS-RT feed */
		String url ;
		if (LOCAL) {
			url = "http://localhost:8077/trip-updates";    	        
		} else {
			url = "http://developer.trimet.org/ws/V1/TripUpdate/appID/C725DEA31C7A28B860DC29BBA";    	        
		}

		URL obj = new URL(url);
		HttpURLConnection entity;
		entity = (HttpURLConnection) obj.openConnection();
		entity.setRequestMethod("GET"); // optional default is GET
		
		InputStream is = null ;
		try {
			is = entity.getInputStream();
		} catch (IOException e) {
			LOG.info("Connection refused to the RT feed. Please check if the feed is working.");
			return ;
		} 

		if (is != null) {
			// Decode message
			FeedMessage feedMessage = FeedMessage.parseFrom(is);
			List<FeedEntity> feedEntityList = feedMessage.getEntityList();
			 
			/* At each time we call the updater, we re-create a new list of updated connections */
			updatedConnections = new HashMap<>() ;
			
			for (FeedEntity feedEntity : feedEntityList) {
				if (feedEntity.hasTripUpdate()) {                    	
					TripUpdate update = feedEntity.getTripUpdate() ;
					TripDescriptor trip = update.getTrip() ;   
					for (StopTimeUpdate stu : update.getStopTimeUpdateList()) {
						/* Propagation des retards */
						String tripId = trip.getTripId() ; /* Map indexée sur les trip ID : values = ensemble des connections de ce trip qui doivent être maj */
						int arrivalDelay = stu.getArrival().getDelay() ;
						int departureDelay = stu.getDeparture().getDelay() ;
						/* Aujourd'hui tel que c'est fait, on introduit un delay sur un stop, part d'un Trip.
						 * Il convient donc de mettre à jour, pour ce trip, les deux connexions concernées.  */
						if (arrivalDelay > 0) { /* Avoid useless updates */
							/* We update the connection which arrives at this stop sequence */
							Connection c = RoutingFactory.eINSTANCE.createConnection() ;
							c.setArrStopSequence(stu.getStopSequence());
							c.setArrivalDelay(arrivalDelay) ;
							addUpdatedConnection(tripId, c) ;
							c = RoutingFactory.eINSTANCE.createConnection() ; 
							c.setDepStopSequence(stu.getStopSequence());
							c.setDepartureDelay(arrivalDelay);
							addUpdatedConnection(tripId, c) ;
						}
						if (departureDelay > 0) {
							/* We update the connection which start from this stop sequence */
							Connection c = RoutingFactory.eINSTANCE.createConnection() ;
							c.setDepStopSequence(stu.getStopSequence());
							c.setDepartureDelay(departureDelay) ;
							addUpdatedConnection(tripId, c) ;
						}
					}								
				}
			}			

			updateLock.lock();
			try {
				for (Connection c : connectionsToUpdate) {
					/* Initialization */
					c.setArrivalDelay(0);
					c.setDepartureDelay(0);
					/* Update */
					if (updatedConnections.containsKey(c.getTripId())) {
						for (Connection uc : updatedConnections.get(c.getTripId())) {
							if (uc.getArrivalDelay() > 0) { /* Arrival delay */
								if (uc.getArrStopSequence() == c.getArrStopSequence()) {
									c.setArrivalDelay(uc.getArrivalDelay());
								}
							} else { /* Otherwise */
								if (uc.getDepStopSequence() == c.getDepStopSequence()) {
									c.setDepartureDelay(uc.getDepartureDelay());
								}
							}
						}
					}
				}
			} 
			finally {
				updateLock.unlock();
			}

		}
		
		// LOG.info("Updates proceed.");
	}

	private void addUpdatedConnection(String tripId, Connection c) {
		if (updatedConnections.containsKey(tripId)) {
			updatedConnections.get(tripId).add(c) ;
		}
		else {
			updatedConnections.put(tripId, new ArrayList<>(Arrays.asList(c)));
		}
	}

	private class RefreshTask implements Runnable {
		@Override
		public void run() {
			try {
				updateConnections();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		
}
