package client.tracking.core;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import tracking.TrackingFactory;
import tracking.Itinerary;
import tracking.Leg;

import common.Request;

public class Tracker {

	private ArrayList<Itinerary> OTP_itineraries ;
    private ArrayList<Itinerary> RFS_itineraries ;
    
    private Updater updater ;
    private Request request ;
    
    public void computeItineraries (Request request) throws IOException {
    	this.request = request ;
    	try {
			routingRequests () ; /* Routing requests */
		} catch (ParseException e) {
			e.printStackTrace();
		} 

    	if (Util.UPDATED) {
        	update() ;  /* Updating all computed itineraries with a GTFS RT feed */
        }
        else {
        	Updater.need2refresh = true ;
        }
    }
    
	public ArrayList<Itinerary> getOTP_itineraries() {
		return OTP_itineraries;
	}

	public ArrayList<Itinerary> getRFS_itineraries() {
		return RFS_itineraries;
	}
	
	private void update () throws IOException {
		ArrayList<Itinerary> itinerariesToUpdate = new ArrayList<Itinerary>() ;
		if (Util.COMPUTE_WITH_OTP) itinerariesToUpdate.addAll(OTP_itineraries) ;
		if (Util.COMPUTE_WITH_RFS) itinerariesToUpdate.addAll(RFS_itineraries) ;
    	updater = new Updater(itinerariesToUpdate) ;
    	updater.start();
    	Updater.need2refresh = true ;
	}

	public boolean needToRecompute () {
		boolean aux = true ;
		if (Util.COMPUTE_WITH_OTP) {
	    	for (Itinerary it : OTP_itineraries) { 
	    		aux = aux && it.isDeprecated() ;
	    	}
		}
		if (Util.COMPUTE_WITH_RFS) {
	    	for (Itinerary it : RFS_itineraries)
	    		aux = aux && it.isDeprecated() ;
		}
    	return aux ;
	}

	private void routingRequests () throws IOException, ParseException {
				
        /* Exemple de parametres pour requete OTP :
		 * showIntermediateStops -> false
		 * time -> 10:20am
		 * arriveBy -> false
		 * wheelchair -> false
		 * maxWalkDistance -> 750
		 * fromPlace -> stop SE Milwaukie & Mall (3932)::45.491215,-122.651461
		 * toPlace -> stop NE Halsey & 157th (2391)::45.533555,-122.5011
		 * date -> 05-29-2015
		 * mode -> TRANSIT,WALK
		 */
		
		String time = request.getTime();
		String date = request.getDate() ;
        double lat_to = request.getToLat() ; 
        double lon_to = request.getToLon() ;
        String stop_to = request.getToStopId() ; 
        double lat_from = request.getFromLat() ; 
        double lon_from = request.getFromLon() ;
        String stop_from = request.getFromStopId() ; 
        int maxWalkDistance = request.getMaxWalkDistance() ;
        
        String req ;

        /* OTP routing request */
        if (Util.COMPUTE_WITH_OTP) {
            req = "http://localhost:8080/otp/routers/r0/plan?time=" + time + "&date=" + date + "&mode=TRANSIT,WALK"
            		+ "&toPlace=" + lat_to +"%2C" + lon_to + "&fromPlace=" + lat_from + "%2C" + lon_from + "&maxWalkDistance=" + maxWalkDistance ;        
			System.out.println("Launch OTP routing request.") ;
            OTP_itineraries = processRequest(req, "OTP_itineraries") ;
        }

        /* RFS routing request */
        if (Util.COMPUTE_WITH_RFS) {
	        req = "http://localhost:8079/myapp/myservice?from=" + stop_from + "&to=" + stop_to + "&time=" + time + "&date=" + date ;        
			System.out.println("Launch RFS routing request.") ;
	        RFS_itineraries = processRequest(req, "RFS_itineraries") ;
        }
    }

	private ArrayList<Itinerary> processRequest(String request, String filename) throws MalformedURLException, ParseException {

		URL url = new URL(request);

        /* Recuperation du Json */
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
        	String json = reader.readLine() ;
        	
        	/* Sauvegarde du Json */
        	FileWriter writer = new FileWriter(filename + ".json");
    		writer.write(json);
    		writer.close();

    		/* Create an object to save all useful informations about computed itineraries */
    		ArrayList<Itinerary> result = new ArrayList<Itinerary>() ;

    		/* Create all itineraries */
    		JSONParser parser = new JSONParser();  
    		JSONObject obj = (JSONObject) parser.parse(json);
    		if (obj.containsKey("plan")) {
				JSONObject plan = (JSONObject) obj.get("plan");
				JSONArray itineraries = (JSONArray) plan.get("itineraries");
				JSONObject itinerary ;
				JSONArray legs ;
				for (int i = 0; i < itineraries.size(); i++) {
					itinerary = (JSONObject) itineraries.get(i) ;
					legs = (JSONArray) itinerary.get("legs");
					Itinerary it = TrackingFactory.eINSTANCE.createItinerary() ;
		    		for (int j = 0; j < legs.size(); j++) {
		    			JSONObject leg = (JSONObject) legs.get(j) ;
		    			JSONObject from = (JSONObject) leg.get("from") ;
		    			JSONObject to = (JSONObject) leg.get("to") ;
		    			Leg l = TrackingFactory.eINSTANCE.createLeg() ;
		    	 		l.setFrom((String) from.get("stopId")); // get("name")) ; 
		    			l.setTo((String) to.get("stopId")); //get("name")) ;
		    			l.setStartTime(((Long)leg.get("startTime"))/1000) ; // Time stamp en ms
		    			l.setEndTime(((Long)leg.get("endTime"))/1000) ; // Time stamp en ms
		    			l.setDepartureDelay(((Long)leg.get("departureDelay")).intValue()) ;
		    			l.setArrivalDelay(((Long) leg.get("arrivalDelay")).intValue()) ;
		    			l.setDistance((double) leg.get("distance")) ;
		    			l.setMode((String) leg.get("mode")) ; 
		    			if (leg.containsKey("tripId")) { // Means we're in a transit segment
			    			l.setRouteId((String) leg.get("routeId")) ;
			    			l.setAgencyId((String) leg.get("agencyId")) ;
			    			l.setTripId((String) leg.get("tripId")) ;
			    			l.setToStopSequence(((Long) to.get("stopSequence")).intValue()) ;
			    			l.setFromStopSequence(((Long) from.get("stopSequence")).intValue()) ;
		    			}
		    			it.getLegs().add(l);
		    		}
		    		result.add(it) ;
				}
    		} 
    		
    		return result ;
    		
        } catch (IOException e) {
			e.printStackTrace();
		}
        
        return null ;
	}
	 	
}
