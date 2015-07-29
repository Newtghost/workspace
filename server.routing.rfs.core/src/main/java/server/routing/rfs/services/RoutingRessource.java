
/**
 * Web-service corresponding to routing request
 * @author David Leydier
 */

package server.routing.rfs.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import common.Request;
import server.routing.rfs.core.DateException;
import server.routing.rfs.core.Router;
import server.routing.rfs.util.MyRoutingFactory;

@Path("routing")
@Component
public class RoutingRessource {

    private static final Logger LOG = LoggerFactory.getLogger(Router.class);
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getItineries(@Context UriInfo ui) {

		LOG.info("Request received.");

		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();

		if (App.DEBUG) {
			printRequestParameters (queryParams) ;
		}
		
    	Request request;
    	
		try {
			request = createRequest (queryParams);
		} catch (ParseParameterException err) {
			err.printStackTrace();
			return Response.status(404).build();
		}
    	
		LOG.info("Request created. Start routing... ");
		
		try {
			String result = App.builder.getRouter().processNewRequest(request);			
			LOG.info("Itineraries computed, ready to send.");
			return Response.ok(result).build();
			
		} catch (JSONException | DateException err) {
			err.printStackTrace();
			return Response.status(404).build();    		
		}

	}

	/* This function gets all parameters of the http request and create a routing request.
	 * It throws an error if one mandatory parameter is missing. */
	private Request createRequest(MultivaluedMap<String, String> queryParams) throws ParseParameterException {
		Request request = null ;
    	
		String time = getParam("time", queryParams, true) ;
		String date = getParam("date", queryParams, true) ;
		String bannedRoutes = getParam("bannedRoutes", queryParams, false) ;    	
		String maximumWait = getParam("maximumWait", queryParams, false) ;
		String maximumWalk = getParam("maximumWalk", queryParams, false) ;
		String gapDeparture = getParam("gapDeparture", queryParams, false) ;
		String gapDuration = getParam("gapDuration", queryParams, false) ;
		String gapWalk = getParam("gapWalk", queryParams, false) ; ;
		
    	/* Get the position of the departure and the arrival */
    	if (queryParams.containsKey("from")) {
			request = MyRoutingFactory.createRequest(
					getParam("from", queryParams, true),
					getParam("to", queryParams, true), 
					time, date, bannedRoutes, maximumWait, 
					maximumWalk, gapDeparture, gapDuration, 
					gapWalk) ;
    	} else {
			request = MyRoutingFactory.createRequest(
					getParam("fromLat", queryParams, true), 
					getParam("fromLon", queryParams, true), 
					getParam("toLat", queryParams, true), 
					getParam("toLon", queryParams, true),
					time, date, bannedRoutes, maximumWait, 
					maximumWalk, gapDeparture, gapDuration, 
					gapWalk) ;
    	} 
    	
    	return request;
	}
	
	/* This function gets a parameter of the get request and throws an exception if the
	 * is missing and if it was mandatory. */
	private String getParam(String nom, MultivaluedMap<String, String> queryParams, boolean isMandatory) throws ParseParameterException {
		if (queryParams.containsKey(nom)) {
    		return queryParams.get(nom).get(0) ;
    	} else {
    		if (isMandatory) {
        		throw new ParseParameterException(nom) ;
    		} else {
    			return "" ;
    		}
    	}
	}
	
	/* This function prints all paramters of the http request */
	private void printRequestParameters (MultivaluedMap<String, String> queryParams) {
    	for (String param : queryParams.keySet()) {
    		for (String value : queryParams.get(param)) {
    			System.out.println(param + " -> " + value) ;
    		}
    	}
	}
	
}
