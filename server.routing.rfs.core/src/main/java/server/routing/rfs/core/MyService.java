package server.routing.rfs.core;

import java.io.FileWriter;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import common.Request;

import org.json.JSONException;

import server.routing.rfs.util.MyRoutingFactory;

@Path("myservice")
public class MyService {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent
	 * to the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt(@Context Builder builder, @Context UriInfo ui) {

		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		
    	for (String param : queryParams.keySet()) {
    		for (String value : queryParams.get(param)) {
    			System.out.println(param + " -> " + value) ;
    		}
    	}

    	System.out.println( "Request received." );
    	
    	Request request ;
    	String time = "", date = "" ;    	
    	
    	if (queryParams.containsKey("time")) {
    		time = queryParams.get("time").get(0) ;
    	} else {
    		return "Request error : missing a time parameter" ;
    	}

    	if (queryParams.containsKey("date")) {
    		date = queryParams.get("date").get(0) ;
    	} else {
    		return "Request error : missing a date parameter" ;
    	}
    	
    	/* Get the position of the departure and the arrival */
    	if (queryParams.containsKey("from") && queryParams.containsKey("to")) {
			request = MyRoutingFactory.createRequest(queryParams.get("from").get(0), queryParams.get("to").get(0), 
					time, date) ;
    	} else if (queryParams.containsKey("fromLat") && queryParams.containsKey("fromLon") && queryParams.containsKey("toLat") && queryParams.containsKey("toLon")) {
			request = MyRoutingFactory.createRequest(queryParams.get("fromLat").get(0), queryParams.get("fromLon").get(0), 
					queryParams.get("toLat").get(0), queryParams.get("toLon").get(0),time, date) ;
    	} else {
    		return "Request error : missing localisation parameters" ;
    	} 
    	
    	System.out.println( "Request created -- start routing." );
		
		/* TODO : Il faudrait lancer un thread de reinit (tous les delay) ou alors direct dans l'updater -- blocage / effet de bord */
    	
    	String result = "RFS error... while routing";    	
		try {
			builder.getRouter().processNewRequest(request);			
			builder.getRouter().run_CSA();
			result = builder.getRouter().journey2Json() ;
			if (App.DEBUG) {
	        	FileWriter writer = new FileWriter("DEBUG.json");
	    		writer.write(result);
	    		writer.close();
			}
			return result;
		} catch (IOException | JSONException | DateException e) {
			e.printStackTrace();
		}

		return result;    		
	}
}
