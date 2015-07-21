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

import routing.Connection;
import routing.Footpath;
import routing.Itinerary;
import routing.Leg;
import routing.RoutingFactory;
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

    	/* Launch the update */
    	if (Util.UPDATED) {
        	updater = new Updater(this, getAllItineraries()) ;
        	updater.start();
        }

    	Updater.need2refresh = true ;
    }

    public void recomputeItineraries () throws InterruptedException {
    	if (! Util.UPDATED) return ; // Just a nonsense

    	updater.stop();
    	
    	recomputeItineraries_aux () ;

		updater.start();
    	Updater.need2refresh = true ;
    	System.out.println("Recomputing itineraries done successfully.") ;
    }

	private void recomputeItineraries_aux () throws InterruptedException {
    	try {
			routingRequests () ; /* Routing requests */
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 

    	updater.setItineraries(getAllItineraries());
    	updater.setDeprecated();
		
		if (updater.needToRecompute ()) {
			/* Means that the web service return only deprecated itineraries :
			 * probably due to a lack of time and a graph out of date.
			 * In this case we just wait for few seconds before to try to
			 * recompute itineraries again. */
			Thread.sleep(20000);
			recomputeItineraries_aux();
		}
	}

	private ArrayList<Itinerary> getAllItineraries() {
		ArrayList<Itinerary> itineraries = new ArrayList<Itinerary>() ;
		if (Util.COMPUTE_WITH_OTP) itineraries.addAll(OTP_itineraries) ;
		if (Util.COMPUTE_WITH_RFS) itineraries.addAll(RFS_itineraries) ;
		return itineraries;
	}

	public ArrayList<Itinerary> getOTP_itineraries() {
		return OTP_itineraries;
	}

	public ArrayList<Itinerary> getRFS_itineraries() {
		return RFS_itineraries;
	}
	
	private void routingRequests () throws ParseException, MalformedURLException {
				
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
        
        long currentTime = 0;

        /* OTP routing request */
        if (Util.COMPUTE_WITH_OTP) {
        	if (Util.UPDATED) req = "http://localhost:8080/otp/routers/r1/plan?" ;
        	else req = "http://localhost:8080/otp/routers/r0/plan?" ;  
            req += "time=" + time + "&date=" + date + "&mode=TRANSIT,WALK"
            		+ "&toPlace=" + lat_to +"%2C" + lon_to + "&fromPlace=" + lat_from + "%2C" + lon_from + "&maxWalkDistance=" + maxWalkDistance ;        
			System.out.println("Launch OTP routing request.") ;
	        currentTime = System.currentTimeMillis();
            OTP_itineraries = processRequest(req, "OTP_itineraries") ;
	        System.out.println("Temps d'éxécution : " + (System.currentTimeMillis()-currentTime) + "ms.");
        }

        /* RFS routing request */
        if (Util.COMPUTE_WITH_RFS) {
	        req = "http://localhost:8079/myapp/myservice?from=" + stop_from + "&to=" + stop_to + "&time=" + time + "&date=" + date + "&bannedRoutes=" ;        
//	        req = "http://localhost:8079/myapp/myservice?toLat=" + lat_to +"&toLon=" + lon_to + "&fromLat=" + lat_from + 
//	        		"&fromLon=" + lon_from + "&time=" + time + "&date=" + date ;       
	        System.out.println("Launch RFS routing request.") ;
	        currentTime = System.currentTimeMillis();
	        RFS_itineraries = processRequest(req, "RFS_itineraries") ;
	        System.out.println("Temps d'éxécution : " + (System.currentTimeMillis()-currentTime) + "ms.");
        }
    }

	private ArrayList<Itinerary> processRequest(String request, String filename) throws ParseException, MalformedURLException {

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

    		int departure_delay, arrival_delay ;
    		
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
					Itinerary it = RoutingFactory.eINSTANCE.createItinerary() ;
		    		for (int j = 0; j < legs.size(); j++) {
		    			JSONObject leg = (JSONObject) legs.get(j) ;
		    			JSONObject from = (JSONObject) leg.get("from") ;
		    			JSONObject to = (JSONObject) leg.get("to") ;
		    
		    			Leg l ;
		    			if (leg.get("mode").equals("WALK")) {
		    				l = RoutingFactory.eINSTANCE.createFootpath() ;
		    				l.setAgencyTimeZoneOffset((long) leg.get("agencyTimeZoneOffset"));
							l.setDepartureId((String) from.get("stopId")) ; 
							l.setArrivalId((String) to.get("stopId")) ;
							((Footpath) l).setDistance((double) leg.get("distance")) ;
							((Footpath) l).setDuration((int) (((Long)leg.get("endTime"))-((Long)leg.get("startTime")))/1000) ;
		    			} else {
		    				l = RoutingFactory.eINSTANCE.createConnection() ;
							((Connection) l).setAgencyName((String) leg.get("agencyName"));
		    				l.setAgencyTimeZoneOffset((long) leg.get("agencyTimeZoneOffset"));
							l.setDepartureId((String) from.get("stopId")) ; 
							l.setArrivalId((String) to.get("stopId")) ;
							departure_delay = ((Long)leg.get("departureDelay")).intValue();
							arrival_delay = ((Long) leg.get("arrivalDelay")).intValue();
							((Connection) l).setDepartureTime(((Long)leg.get("startTime"))/1000 - departure_delay) ; // Time stamp en ms
							((Connection) l).setArrivalTime(((Long)leg.get("endTime"))/1000 - arrival_delay) ; // Time stamp en ms
							((Connection) l).setDepartureDelay(departure_delay) ;
							((Connection) l).setArrivalDelay(arrival_delay) ;
							((Connection) l).setRouteId((String) leg.get("routeId")) ;
							((Connection) l).setTripId((String) leg.get("tripId")) ;
							((Connection) l).setArrStopSequence(((Long) to.get("stopSequence")).intValue()) ;
							((Connection) l).setDepStopSequence(((Long) from.get("stopSequence")).intValue()) ;
		    			}
		    				
		    			it.getPath().add(l);
		    		}
		    		result.add(it) ;
				}
    		} 
    		
    		System.out.println("Number of itineraries found : " + result.size()) ;
    		return result ;
    		
        } catch (IOException e) {
			e.printStackTrace();
		}
        
        return null ;
	}
	 	
}
