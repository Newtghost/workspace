package client.tracking.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import tracking.Itinerary;
import tracking.Leg;

import com.google.transit.realtime.GtfsRealtime.FeedEntity;
import com.google.transit.realtime.GtfsRealtime.FeedMessage;
import com.google.transit.realtime.GtfsRealtime.TripDescriptor;
import com.google.transit.realtime.GtfsRealtime.TripUpdate;
import com.google.transit.realtime.GtfsRealtime.TripUpdate.StopTimeUpdate;

public class Updater {

	private static final boolean LOCAL = true ;

	private static final int DELAY_THRESHOLD = 200; /* delay threshold in seconds for an itinerary */
	public static final int REFRESH_INTERVAL = 1; 
	
	private ScheduledExecutorService executor;
	public static boolean need2refresh = false ;
	
	/* Itineraries we want to update */ 
	ArrayList<Itinerary> itineraries ;

	public Updater (ArrayList<Itinerary> itineraries) {
		this.itineraries = itineraries ;
	}
	
	public void start() {
		executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(new RefreshTask(), 0,
				REFRESH_INTERVAL, TimeUnit.SECONDS);
	}

	public ArrayList<Itinerary> getItineraries() {
		return itineraries;
	}

	public void stop() {
		executor.shutdownNow();
	}

	public void updateItineraries() throws IOException {
		
		/* Read the TriMet GTFS-RT feed */
		String url ;
		if (LOCAL) {
			url = "http://localhost:8077/trip-updates";    	        
		} else {
			url = "http://developer.trimet.org/ws/V1/TripUpdate/appID/C725DEA31C7A28B860DC29BBA";    	        
		}

		URL obj = new URL(url);
		HttpURLConnection entity = (HttpURLConnection) obj.openConnection(); 
		entity.setRequestMethod("GET"); // optional default is GET
		 
		InputStream is = entity.getInputStream();
		if (is != null) {
			// Decode message
			FeedMessage feedMessage = FeedMessage.parseFrom(is);
			List<FeedEntity> feedEntityList = feedMessage.getEntityList();
			
			boolean updated = false ;
			for (FeedEntity feedEntity : feedEntityList) {
				if (feedEntity.hasTripUpdate()) {                    	
				
					TripUpdate update = feedEntity.getTripUpdate() ;
					
					TripDescriptor trip = update.getTrip() ;   
					
					for (Itinerary it : itineraries) {
						for (Leg l : it.getLegs()) { 
							if (trip.getTripId().equals(l.getTripId())) {
								for (StopTimeUpdate stu : update.getStopTimeUpdateList()) {
									/* Propagation des retards */
									if (stu.getStopSequence() > l.getToStopSequence() ) continue ; /* Le retard ne nous concerne pas */
									if (stu.getStopSequence() < l.getFromStopSequence() ) {
										/* Le bus est en retard et n'est pas encore la - retard hypothetique */
										if (l.getDepartureDelay() != stu.getArrival().getDelay()) {
											l.setDepartureDelay(stu.getArrival().getDelay()) ;
											updated = true ;
										}
									}
									/* Le bus est en retard et alors que l'on est dedans - retard constatÃ© */
									if (l.getArrivalDelay() != stu.getArrival().getDelay()) {
										l.setArrivalDelay(stu.getArrival().getDelay()) ;
										updated = true ;
									}
								}								
							}
						}
					}
				}
			}			

			if (updated) {
				System.out.println("Updates done.") ;
				Updater.need2refresh = true ;
			}
		}
		
		setDeprecated();
		
	}
	
	public void setDeprecated () {
		for (Itinerary it : itineraries) {		
			it.setDeprecated(false) ; /* Init */
		
			/* Check des correspondances */
			List<Leg> legs = it.getLegs() ;
			int delay = 0 ;
			for (int i=0 ; i < legs.size()-1 ; i++) {
				delay = 0 ;
				if (legs.get(i).getEndTime() + legs.get(i).getArrivalDelay() > legs.get(i+1).getStartTime() + legs.get(i+1).getDepartureDelay()) {
					if (legs.get(i+1).getMode().equals("WALK")) { /* On décale la correspondance d'après si c'est une WALK */
						delay = (int) (legs.get(i).getEndTime() + legs.get(i).getArrivalDelay() - legs.get(i+1).getStartTime()) ;
					}
					else {
						it.setDeprecated(true) ; /* Risque de rater une correspondance */
					}
				}
				if (legs.get(i+1).getMode().equals("WALK")) {
					legs.get(i+1).setArrivalDelay(delay);
					legs.get(i+1).setDepartureDelay(delay);
				}
			}

			/* Retard global trop important : autre chemin probablement meilleur */
			if (legs.get(legs.size()-1).getArrivalDelay() > DELAY_THRESHOLD) {
				it.setDeprecated(true) ; 
			}			
		}
	}


	private class RefreshTask implements Runnable {
		@Override
		public void run() {
			try {
				updateItineraries();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
