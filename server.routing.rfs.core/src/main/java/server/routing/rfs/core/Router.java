package server.routing.rfs.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import routing.Connection;
import routing.Footpath;
import routing.Itinerary;
import routing.Leg;
import routing.RoutingFactory;
import routing.Space;
import routing.StopPoint;

import common.Request;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import server.routing.rfs.util.RoutingAccessors;
import server.routing.rfs.util.MyRoutingFactory;

public class Router {
	
    private static final Logger LOG = LoggerFactory.getLogger(Router.class);

	private Request request ;
	
	Space space ;
	private ArrayList<Connection> sorted_connections ; 
	
	private Itinerary solution ;
	
	public Router (Builder builder, Request request) {
		this.request = request ;	
		sorted_connections = builder.getSortedConnections() ;
		solution = RoutingFactory.eINSTANCE.createItinerary() ;
		space = builder.space ;
	}
	
	public void run_CSA () {

		LOG.info("Start computing solutions.");

		StopPoint sourceStop, targetStop ;
		sourceStop = RoutingAccessors.getStop(space, request.getFromStopId()) ;
		targetStop = RoutingAccessors.getStop(space, request.getToStopId()) ;
		long startTime = RoutingAccessors.getStartTime(request) ;
		
		/* Initialization */
		MyRoutingFactory.initialize(space) ;  
		sourceStop.setBestArrivalTime(startTime - sourceStop.getMinimalConnectionTime()); 
		for (Footpath f : RoutingAccessors.getFootpaths(space, sourceStop.getStopId())) {
			updateStopPoint (RoutingAccessors.getStop(space, f.getArrivalId()), f, startTime + f.getDuration()) ;
		}

		StopPoint cDepStop, cArrStop ;
		List<Footpath> footpaths ;
		
		/* Core of the algorithm */
		for (Connection c : sorted_connections) {
			
			/* TODO : refaire la simu de tracking OTP vs RFS pourquoi RFS ne choisit pas le même trip (trip - 5425354) 
			 * Il faut debugger avec des traces complète, pour ça il faut savoir exactement à quel stop sequence on commence
			 * Ce stop doit etre accessible quand on y arrive dessus, etc...
			 * Pour ca passer en mode debug sur le tracking et ecrire les .json en profiter pour faire du propre dans
			 * toutes les traces et tout ce qui est généré.
			 * Au final... retard d'une heure de RFS. */
			
			if (c.getDepartureTime() < startTime) continue ; /* Before the departure */
			/* Break if we can't improve the best arrival time to the target*/
			if (targetStop.getBestArrivalTime() <= c.getDepartureTime()) break ;
			
			cDepStop = RoutingAccessors.getStop(space, c.getDepartureId()) ;
			cArrStop = RoutingAccessors.getStop(space, c.getArrivalId()) ;
			
			if (cDepStop.getBestArrivalTime() + cDepStop.getMinimalConnectionTime() <= c.getDepartureTime() ||
					(c.getPrevC() != null && c.getPrevC().isRelaxed())) {
								
				updateStopPoint (cArrStop, c, c.getArrivalTime()) ;

				footpaths = RoutingAccessors.getFootpaths(space, cArrStop.getStopId()) ;
				if (footpaths != null) { 
					for (Footpath f : footpaths) {
						updateStopPoint (RoutingAccessors.getStop(space, f.getArrivalId()), f, c.getArrivalTime() + cArrStop.getMinimalConnectionTime() + f.getDuration()) ;
					}
				}
				
				c.setRelaxed(true);
			}

		}

		sourceStop.setBestArrivalTime(sourceStop.getBestArrivalTime() + sourceStop.getMinimalConnectionTime()); 
		
		LOG.info("Computing succeed.");

		/* Re-build the journey */
		buildJourney() ;
		printJourney() ;		
	}

	public void updateStopPoint (StopPoint s, Leg l, long time) {
		if (time < s.getBestArrivalTime()) { /* Meilleure connection */
			s.setBestArrivalTime(time);
			s.setBestArrivalLeg(l);
		}
	}
	

	private void buildJourney() {
		StopPoint stop = RoutingAccessors.getStop(space, request.getToStopId());
		Leg aux = stop.getBestArrivalLeg();
		List<Leg> res = new ArrayList<Leg>() ;
		while (true) {
			res.add(aux); /* On rajoute le segment dans la solution */
			stop = RoutingAccessors.getStop(space, aux.getDepartureId()) ;
			aux = stop.getBestArrivalLeg() ;
			if (stop.getBestArrivalLeg() == null || stop.getStopId().equals(request.getFromStopId())) break ; /* On est revenu au départ */
		}		
		Collections.reverse(res) ;
		RoutingAccessors.getPath(solution).addAll(res) ;
		LOG.info("Journey build successfully.");
	}
	

	@SuppressWarnings("unchecked")
	public String journey2Json() throws IOException, JSONException {
		JSONObject obj = new JSONObject();
		JSONObject plan = new JSONObject();
		JSONArray itineraries = new JSONArray();
		JSONObject itinerary = new JSONObject();
		JSONArray legs = new JSONArray();
		JSONObject leg = null;

		Connection prevC = null ;
		long prevEndTime = RoutingAccessors.getStartTime(request) ; /* Utile pour calculer les start time et end time des footpaths */

		long tz = 9 * 3600 ; // TODO : local TIMEZONE à changer  

		for (Leg s : RoutingAccessors.getPath(solution)) {

			if (s instanceof Footpath) {

				if (leg != null) { /* Signifie qu'on a changé de Leg et qu'on doit donc ajouter le segment précédent qui est terminé */	
					JSONObject to = new JSONObject() ;
					to.put("name", RoutingAccessors.getStop(space, prevC.getArrivalId()).getName()) ;
					to.put("stopId", prevC.getArrivalId()) ;
					to.put("stopSequence", prevC.getArrStopSequence()) ;
					leg.put("to", to) ;
					prevEndTime = prevC.getArrivalTime() ;
					leg.put("endTime", (prevEndTime+tz) * 1000) ;
					leg.put("arrivalDelay", 0) ;
					legs.add(leg) ;
					leg = null ;
				}

				/* New leg corresponding to a footpath */
				leg = new JSONObject() ;
				JSONObject from = new JSONObject() ;
				JSONObject to = new JSONObject() ;
				from.put("name", RoutingAccessors.getStop(space, s.getDepartureId()).getName()) ;
				from.put("stopId", s.getDepartureId()) ;
				to.put("name", RoutingAccessors.getStop(space, s.getArrivalId()).getName()) ;
				to.put("stopId", s.getArrivalId()) ;
				leg.put("from", from) ;
				leg.put("to", to) ;
				leg.put("startTime", (prevEndTime+tz) * 1000) ;
				prevEndTime += ((Footpath) s).getDuration() ;
				leg.put("endTime", (prevEndTime+tz) * 1000) ;
				leg.put("departureDelay", 0) ;
				leg.put("arrivalDelay", 0) ;
				leg.put("distance", ((Footpath) s).getDistance()) ;
				leg.put("mode", "WALK") ;
				legs.add(leg);
				leg = null ;

			} else {
				
				Connection c = (Connection) s ;
				
				if (prevC == null || ! c.getTripId().equals(prevC.getTripId())) {
					if (leg != null) { /* Signifie qu'on a changé de Leg et qu'on doit donc ajouter le segment précédent qui est terminé */	
						JSONObject to = new JSONObject() ;
						to.put("name", RoutingAccessors.getStop(space, prevC.getArrivalId()).getName()) ;
						to.put("stopId", prevC.getArrivalId()) ;
						to.put("stopSequence", prevC.getArrStopSequence()) ;
						leg.put("to", to) ;
						prevEndTime = prevC.getArrivalTime() ;
						leg.put("endTime", (prevEndTime+tz) * 1000) ;
						leg.put("arrivalDelay", 0) ;
						legs.add(leg) ;
						leg = null ;
					}
					
					/* Creation of a new transit path */
					leg = new JSONObject() ;
					JSONObject from = new JSONObject() ;
					from.put("name", RoutingAccessors.getStop(space, c.getDepartureId()).getName()) ;
					from.put("stopId", c.getDepartureId()) ;
					from.put("stopSequence", c.getDepStopSequence()) ;
					leg.put("from", from) ;
					leg.put("startTime", (c.getDepartureTime()+tz) * 1000) ;
					leg.put("departureDelay", 0) ;
					leg.put("distance", 0.1) ; /* Default value */
					leg.put("mode", "TRANSIT") ;
					leg.put("routeId", c.getRouteId()) ;
					leg.put("agencyId", "") ;
					leg.put("tripId", c.getTripId()) ;

				}
				
				prevC = c ;
			}
		}
		
		if (leg != null) { /* On doit ajouter le dernier segment (en cours) */	
			JSONObject to = new JSONObject() ;
			to.put("name", RoutingAccessors.getStop(space, prevC.getArrivalId()).getName()) ;
			to.put("stopId", prevC.getArrivalId()) ;
			to.put("stopSequence", prevC.getArrStopSequence()) ;
			leg.put("to", to) ;
			prevEndTime = prevC.getArrivalTime() ;
			leg.put("endTime", (prevEndTime+tz) * 1000) ;
			leg.put("arrivalDelay", 0) ;
			legs.add(leg) ;
			leg = null ;
		}
		
		itinerary.put("legs", legs) ;
		itineraries.add(itinerary) ;
		plan.put("itineraries", itineraries) ;
		obj.put("plan", plan) ;
		
        return obj.toString();
	}
	

	public void printJourney() {
		Connection c_prev = null ;
		for (Leg s : RoutingAccessors.getPath(solution)) {
			if (s instanceof Footpath) {
				System.out.println("Footpath : " + s.getDepartureId() + " --> " + s.getArrivalId() + " (" + ((Footpath) s).getDuration() + ")");
			} else {
				Connection c = (Connection) s ;
				if (c_prev == null || ! c.getTripId().equals(c_prev.getTripId())) {
					System.out.println("Transit : " + c.getRouteId() + ", " + c.getTripId());
				}
				System.out.println("\t" + c.getDepartureId() + " (" + c.getDepartureTime() + "), " + c.getArrivalId() + " (" + c.getArrivalTime() + ")");
				c_prev = c ;
			}
		}		
	}


}

