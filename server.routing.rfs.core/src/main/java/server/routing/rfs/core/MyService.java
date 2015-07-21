package server.routing.rfs.core;

import java.io.FileWriter;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import common.Request;

import org.json.JSONException;

import server.routing.rfs.util.MyRoutingFactory;

@Path("myservice")
public class MyService {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getIt(@Context Builder builder, @Context UriInfo ui) {

		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		
    	for (String param : queryParams.keySet()) {
    		for (String value : queryParams.get(param)) {
    			System.out.println(param + " -> " + value) ;
    		}
    	}

    	System.out.println( "Request received." );
    	
    	Request request ;
    	String time = "", date = "", bannedRoutes = "" ;    	
    	
    	if (queryParams.containsKey("time")) {
    		time = queryParams.get("time").get(0) ;
    	} else {
    		return Response.status(404).build();
    	}

    	if (queryParams.containsKey("date")) {
    		date = queryParams.get("date").get(0) ;
    	} else {
    		return Response.status(404).build();
    	}

    	if (queryParams.containsKey("bannedRoutes")) {
    		bannedRoutes = queryParams.get("bannedRoutes").get(0) ;
    	}
    	
    	/* Get the position of the departure and the arrival */
    	if (queryParams.containsKey("from") && queryParams.containsKey("to")) {
			request = MyRoutingFactory.createRequest(queryParams.get("from").get(0), queryParams.get("to").get(0), 
					time, date, bannedRoutes) ;
    	} else if (queryParams.containsKey("fromLat") && queryParams.containsKey("fromLon") && queryParams.containsKey("toLat") && queryParams.containsKey("toLon")) {
			request = MyRoutingFactory.createRequest(queryParams.get("fromLat").get(0), queryParams.get("fromLon").get(0), 
					queryParams.get("toLat").get(0), queryParams.get("toLon").get(0),time, date, bannedRoutes) ;
    	} else {
    		return Response.serverError().build() ;
    	} 
    	
    	System.out.println( "Request created -- start routing." );
		
    	String result = "";    	
		try {
			builder.getRouter().processNewRequest(request);			
			builder.getRouter().run_CSA();
			result = builder.getRouter().journey2Json() ;
			if (App.DEBUG) {
	        	FileWriter writer = new FileWriter("DEBUG.json");
	    		writer.write(result);
	    		writer.close();
			}
			
			return Response.ok(result).build();
			
		} catch (IOException | JSONException | DateException e) {
			e.printStackTrace();
		}

		return Response.status(404).build();    		
	}
}
