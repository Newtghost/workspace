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

import routing.Connection;
import routing.Footpath;
import routing.Itinerary;
import routing.Leg;

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
	
	Tracker tracker ;
	
	/* Itineraries we want to update */ 
	ArrayList<Itinerary> itineraries ;
		
	public Updater (Tracker tracker, ArrayList<Itinerary> itineraries) {
		this.tracker = tracker ;
		this.itineraries = itineraries ;
	}
	
	public void start() {
		executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(new RefreshTask(), 0,
				REFRESH_INTERVAL, TimeUnit.SECONDS);
	}

	public void setItineraries(ArrayList<Itinerary> itineraries) {
		this.itineraries = itineraries;
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
						for (Leg l : it.getPath()) { 
							if (trip.getTripId().equals(l.getTripId())) {
								for (StopTimeUpdate stu : update.getStopTimeUpdateList()) {
									/* Propagation des retards */
									if (l instanceof Footpath) continue ;
									Connection c = (Connection) l ;
									if (stu.getStopSequence() > c.getArrStopSequence()) continue ; /* Le retard ne nous concerne pas */
									if (stu.getStopSequence() < c.getDepStopSequence()) {
										/* Le bus est en retard et n'est pas encore la - retard hypothetique */
										if (c.getDepartureDelay() != stu.getArrival().getDelay()) {
											c.setDepartureDelay(stu.getArrival().getDelay()) ;
											updated = true ;
										}
									}
									/* Le bus est en retard et alors que l'on est dedans - retard constatÃ© */
									if (c.getArrivalDelay() != stu.getArrival().getDelay()) {
										c.setArrivalDelay(stu.getArrival().getDelay()) ;
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
		
		if (needToRecompute ()) {
			
			System.out.println("Need to recompute all itineraries.") ;

			try {
				tracker.recomputeItineraries();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void setDeprecated () {
		for (Itinerary it : itineraries) {		
			it.setDeprecated(false) ; /* Init */
		
			/* Check des correspondances */
			List<Leg> legs = it.getPath() ;
			long earliestDepartureTime = 0 ;
			for (int i=0 ; i < legs.size() ; i++) {
				if (legs.get(i) instanceof Footpath) {
					Footpath f = (Footpath) legs.get(i) ;
					earliestDepartureTime += f.getDuration() ; 
				}
				if (legs.get(i) instanceof Connection) { 
					Connection c = (Connection) legs.get(i) ;
					if (earliestDepartureTime > c.getDepartureTime() + c.getDepartureDelay()) {
						it.setDeprecated(true) ; /* Risque de rater une correspondance */
					}
					earliestDepartureTime = c.getArrivalTime() + c.getArrivalDelay() ;
				}
			}

			/* Retard global trop important : autre chemin probablement meilleur */
			if (legs.get(legs.size()-1) instanceof Connection) { 
				Connection c = (Connection) legs.get(legs.size()-1) ;
				if (c.getArrivalDelay() > DELAY_THRESHOLD) {
					it.setDeprecated(true) ; 
				}	
			}
		}
	}
	
	/* Return true if all itineraries are deprecated */
	public boolean needToRecompute () {
		/* Attention, aujourd'hui on ne recalcule les itinéraires (nouvelle requête) que s'ils sont tous deprecated. 
		 * Il faudrait différencier les itinéraires par calculateur (exemple ceux d'OTP et de RFS). */
		boolean aux = true ;
    	for (Itinerary it : itineraries) { 
    		aux = aux && it.isDeprecated() ;
    	}
    	return aux ;
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
