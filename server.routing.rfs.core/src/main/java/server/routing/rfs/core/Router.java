package server.routing.rfs.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

import routing.Connection;
import routing.Footpath;
import routing.Itinerary;
import routing.Leg;
import routing.RoutingFactory;
import routing.Space;
import routing.StopPoint;
import common.Request;
import common.util.DateUtils;

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
	private String currentDate = "" ;
	private Itinerary solution ;
	
	public Router (Space space) {
		this.space = space ;
	}
	
	public void processNewRequest (Request request) {
		this.request = request ;	
		solution  = RoutingFactory.eINSTANCE.createItinerary() ; 
		
		if (currentDate.equals(request.getDate())) return ; // No need to recompute the list
				
		createSortedConnectionsList() ;	
	}
	
	private void createSortedConnectionsList() {
		currentDate = request.getDate() ;
		List<String> serviceIDs = RoutingAccessors.getServicesIdForDate(space, RoutingAccessors.getDate(request)) ;
		
		/* Contains all connections that the user could take in order to perform its trip */
		sorted_connections = new ArrayList<Connection>() ;
		for (String k : RoutingAccessors.getConnectionsKeySet(space)) {
			for (Connection c : RoutingAccessors.getConnections(space, k)) {
				if (serviceIDs.contains(c.getServiceId()))
					sorted_connections.add(c) ;				
			}
		}
		Collections.sort(sorted_connections); 
		// # connections : 351'093 vs 2'457'382	
	}

	public void run_CSA () {

		LOG.info("Start computing solutions.");

		StopPoint sourceStop, targetStop ;
		sourceStop = RoutingAccessors.getStop(space, request.getFromStopId()) ;
		targetStop = RoutingAccessors.getStop(space, request.getToStopId()) ;
		long startTime = RoutingAccessors.getStartTime(request) ;
		
		/* Initialization */
		MyRoutingFactory.initialize(space) ;  

		// TODO : il faut penser sur le dernier itinéraire itinéraire de rajouter le minimum connection time ??? Ou pas
		Itinerary it = MyRoutingFactory.createItinerary(null, null, startTime - sourceStop.getMinimalConnectionTime(), 0) ; /* Itinéraire qui domine tous les autres */
		RoutingAccessors.getJourneys(sourceStop).add(it) ;
		
		for (Footpath f : RoutingAccessors.getFootpaths(space, sourceStop.getStopId())) {
			updateStopPoint (RoutingAccessors.getStop(space, f.getDepartureId()), 
					RoutingAccessors.getStop(space, f.getArrivalId()), Long.MAX_VALUE, startTime + f.getDuration(), f) ;
		}

		StopPoint cDepStop, cArrStop ;
		List<Footpath> footpaths ;
		
		/* Core of the algorithm */
		for (Connection c : sorted_connections) {
									
			if (c.getDepartureTime() < startTime) continue ; /* Before the departure */
			/* Break if we can't improve the best arrival time to the target*/
			if (targetStop.getBestArrivalTime() <= c.getDepartureTime()) {
				break ;
			}
			
			cDepStop = RoutingAccessors.getStop(space, c.getDepartureId()) ;
			cArrStop = RoutingAccessors.getStop(space, c.getArrivalId()) ;
			
			if (cDepStop.getBestArrivalTime() + cDepStop.getMinimalConnectionTime() <= c.getDepartureTime() ||
					(c.getPrevC() != null && c.getPrevC().isRelaxed())) {
								
				updateStopPoint (cDepStop, cArrStop, c.getDepartureTime(), c.getArrivalTime(), c) ;

				footpaths = RoutingAccessors.getFootpaths(space, cArrStop.getStopId()) ;
				if (footpaths != null) { 
					for (Footpath f : footpaths) {
						updateStopPoint (RoutingAccessors.getStop(space, f.getDepartureId()), RoutingAccessors.getStop(space, f.getArrivalId()),
								Long.MAX_VALUE, c.getArrivalTime() + cArrStop.getMinimalConnectionTime() + f.getDuration(), f) ;
					}
				}
				
				c.setRelaxed(true);
			}

		}

		LOG.info("Computing succeed.");

		/* Print itineraries */
		System.out.println(RoutingAccessors.getJourneys(targetStop).size());
//		solution = RoutingAccessors.getJourneys(targetStop).get(0) ;
//		printJourney() ;		
	}

	public void updateStopPoint (StopPoint dep, StopPoint arr, long departureTime, long arrivalTime, Leg l) {
		int aux, nbTransfers ;
		List<Itinerary> depJourneys = RoutingAccessors.getJourneys(dep) ;
		List<Itinerary> arrJourneys = RoutingAccessors.getJourneys(arr) ;
		
		if (arrJourneys.size() <= 0) {
			for (Itinerary itdep : depJourneys) {
				if (itdep.getArrivalTime() + dep.getMinimalConnectionTime() > departureTime) continue ;
				nbTransfers = itdep.getNbTransfers() + (itdep.getLastTrip().equals(l.getRouteId())?0:1) ;
				Itinerary it = MyRoutingFactory.createItinerary(itdep, l, arrivalTime, nbTransfers) ;
				arrJourneys.add(it) ;
			}
		}
		else {
			for (Itinerary itarr : new ArrayList<Itinerary>(arrJourneys)) { // Cloning to avoid stupid compilation error
				for (Itinerary itdep : depJourneys) {
					nbTransfers = itdep.getNbTransfers() + (itdep.getLastTrip().equals(l.getRouteId())?0:1) ;
					aux = itarr.isDominated(arrivalTime, nbTransfers) ;
					if (aux == 1) {
						continue ; // The itinerary is dominated
					} else if (aux == -1) {
						arrJourneys.remove(itarr) ;
						Itinerary it = MyRoutingFactory.createItinerary(itdep, l, arrivalTime, nbTransfers) ;						
						arrJourneys.add(it) ;
					} else {
						if (arrJourneys.size() >= MyRoutingFactory.NB_ITINERARIES) continue ;
						Itinerary it = MyRoutingFactory.createItinerary(itdep, l, arrivalTime, nbTransfers) ;
						arrJourneys.add(it) ;
					}
				}
			}
		}
		
		
	}
	

//	private void buildJourney() {
//		StopPoint stop = RoutingAccessors.getStop(space, request.getToStopId());
//		Leg aux = stop.getBestArrivalLeg();
//		List<Leg> res = new ArrayList<Leg>() ;
//		while (true) {
//			res.add(aux); /* On rajoute le segment dans la solution */
//			stop = RoutingAccessors.getStop(space, aux.getDepartureId()) ;
//			aux = stop.getBestArrivalLeg() ;
//			if (stop.getBestArrivalLeg() == null || stop.getStopId().equals(request.getFromStopId())) break ; /* On est revenu au départ */
//		}		
//		Collections.reverse(res) ;
//		RoutingAccessors.getPath(solution).addAll(res) ;
//		LOG.info("Journey build successfully.");
//	}
	

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

		/* Le calcul d'itinéraire se fait avec un horaire local.
		 * Ce n'est qu'au moment de l'export json que l'on passe dans un référentiel global en 
		 * prenant en compte la timezone et la date.
		 */

		long tz = RoutingAccessors.getJetlag(space) ; 
		long date = DateUtils.parseDate(request.getDate(), TimeZone.getDefault()).getTime() / 1000 ;
		
		for (Leg s : RoutingAccessors.getPath(solution)) {

			if (s instanceof Footpath) {

				if (leg != null) { /* Signifie qu'on a changé de Leg et qu'on doit donc ajouter le segment précédent qui est terminé */	
					JSONObject to = new JSONObject() ;
					to.put("name", RoutingAccessors.getStop(space, prevC.getArrivalId()).getName()) ;
					to.put("stopId", prevC.getArrivalId()) ;
					to.put("stopSequence", prevC.getArrStopSequence()) ;
					leg.put("to", to) ;
					prevEndTime = prevC.getArrivalTime() ;
					leg.put("endTime", (prevEndTime+date+tz) * 1000) ;
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
				leg.put("startTime", (prevEndTime+date+tz) * 1000) ;
				prevEndTime += ((Footpath) s).getDuration() ;
				leg.put("endTime", (prevEndTime+date+tz) * 1000) ;
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
						leg.put("endTime", (prevEndTime+date+tz) * 1000) ;
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
					leg.put("startTime", (c.getDepartureTime()+date+tz) * 1000) ;
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
			leg.put("endTime", (prevEndTime+date+tz) * 1000) ;
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

