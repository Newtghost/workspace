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
	
	public Router (Space space) {
		this.space = space ;
	}
	
	public void processNewRequest (Request request) {
		this.request = request ;	
		
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
		Itinerary it = MyRoutingFactory.createItinerary(null, null, startTime - sourceStop.getMinimalConnectionTime(), startTime - sourceStop.getMinimalConnectionTime(), 0) ; /* Itinéraire qui domine tous les autres */
		it.setLastTrip("-1"); /* Allow to start the itinerary by any trip (TRANSIT or WALK) */
		RoutingAccessors.getJourneys(sourceStop).add(it) ;
		
		for (Footpath f : RoutingAccessors.getFootpaths(space, sourceStop.getStopId())) {
			updateStopPoint (sourceStop, RoutingAccessors.getStop(space, f.getArrivalId()), startTime, startTime + f.getDuration(), f, true) ;
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
			
			if (cArrStop.getStopId().equals(sourceStop.getStopId())) continue ;
			if (cDepStop.getStopId().equals(targetStop.getStopId())) continue ;
						
			if (cDepStop.getBestArrivalTime() + cDepStop.getMinimalConnectionTime() <= c.getDepartureTime() ||
					(c.getPrevC() != null && c.getPrevC().isRelaxed())) {
								
//				if (c.getTripId().equals("5371180")) { 
//					System.out.println("--- " + c.getDepStopSequence() + " : " + c.getArrivalTime() + " ; " + cArrStop.getStopId());
//				}

				updateStopPoint (cDepStop, cArrStop, c.getDepartureTime(), c.getArrivalTime(), c, cDepStop.getStopId().equals(sourceStop.getStopId())) ;

				footpaths = RoutingAccessors.getFootpaths(space, cArrStop.getStopId()) ;
				if (footpaths != null) { 
					for (Footpath f : footpaths) {
						updateStopPoint (RoutingAccessors.getStop(space, f.getDepartureId()), RoutingAccessors.getStop(space, f.getArrivalId()),
								Long.MAX_VALUE, c.getArrivalTime() + cArrStop.getMinimalConnectionTime() + f.getDuration(), f, false) ;
					}
				}
				
				c.setRelaxed(true);
			}

		}

		LOG.info("Computing succeed.");

		/* Print itineraries */
		if (App.DEBUG) printJourneys() ;		
	}

	public void updateStopPoint (StopPoint dep, StopPoint arr, long departureTime, long arrivalTime, Leg l, boolean fromSource) {
		List<Itinerary> depJourneys = RoutingAccessors.getJourneys(dep) ;
		List<Itinerary> arrJourneys = RoutingAccessors.getJourneys(arr) ;
				
		if (arrJourneys.size() == 0) { /* No journeys in the arrival stop point : we assume that the departure journeys are pareto-opt */
			for (Itinerary itdep : depJourneys) {
				if (itdep.getArrivalTime() + dep.getMinimalConnectionTime() > departureTime) continue ; /* In time for the transfer */
				if (itdep.getLastTrip().equals("") && l.getRouteId().equals("")) continue ; /* Transitive footpath closure */
				int nbTransfers = itdep.getNbTransfers() + (itdep.getLastTrip().equals(l.getRouteId())?0:1) ;
				Itinerary it = MyRoutingFactory.createItinerary(itdep, l, fromSource?departureTime:itdep.getDepartureTime(), arrivalTime, fromSource?1:nbTransfers) ;
				arrJourneys.add(it) ;
			}
		}
		else {
			for (Itinerary itdep : depJourneys) {
				boolean treated = false ;
				if (itdep.getArrivalTime() + dep.getMinimalConnectionTime() > departureTime) continue ; /* In time for the transfer */
				if (itdep.getLastTrip().equals("") && l.getRouteId().equals("")) continue ; /* Transitive footpath closure */
				int nbTransfers = itdep.getNbTransfers() + (itdep.getLastTrip().equals(l.getRouteId())?0:1) ;
				for (Itinerary itarr : new ArrayList<Itinerary>(arrJourneys)) { // Cloning to avoid stupid compilation error
					int dom = itarr.isDominated(arrivalTime - (fromSource?departureTime:itdep.getDepartureTime()), nbTransfers, itdep.getWalkingDistance()) ;
					if (dom == 1) { // The new itinerary is dominated by an existing one.
						treated = true ;
						break ; 
					} else if (dom == -1) { // The new itinerary dominate an existing one.
						arrJourneys.remove(itarr) ;
						break ;
					} 
				}
								
				if (! treated && arrJourneys.size() < MyRoutingFactory.NB_ITINERARIES) {
					Itinerary it = MyRoutingFactory.createItinerary(itdep, l, fromSource?departureTime:itdep.getDepartureTime(), arrivalTime, fromSource?1:nbTransfers) ;
					if (it != null) arrJourneys.add(it) ;
				}
			}
		}
		
		RoutingAccessors.sortJourneys(arr) ;
				
	}

	@SuppressWarnings("unchecked")
	public String journey2Json() throws IOException, JSONException {
		JSONObject obj = new JSONObject();
		JSONObject plan = new JSONObject();
		JSONArray itineraries = new JSONArray();
		JSONObject itinerary = null;
		JSONArray legs = null;
		JSONObject leg = null;

		Connection prevC = null ;
		long prevEndTime ; /* Utile pour calculer les start time et end time des footpaths */

		/* Le calcul d'itinéraire se fait avec un horaire local.
		 * Ce n'est qu'au moment de l'export json que l'on passe dans un référentiel global en 
		 * prenant en compte la timezone et la date.
		 */

		long tz = RoutingAccessors.getJetlag(space) ; 
		long date = DateUtils.parseDate(request.getDate(), TimeZone.getDefault()).getTime() / 1000 ;
		
		StopPoint targetStop = RoutingAccessors.getStop(space, request.getToStopId()) ;
		for (Itinerary it : RoutingAccessors.getJourneys(targetStop)) {

			prevEndTime = RoutingAccessors.getStartTime(request) ; 
			itinerary = new JSONObject();
			legs = new JSONArray();
			
			for (Leg s : RoutingAccessors.getPath(it)) {
	
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
		}
		
		plan.put("itineraries", itineraries) ;
		obj.put("plan", plan) ;
		
        return obj.toString();
	}

	public void printJourneys() {		
		StopPoint targetStop = RoutingAccessors.getStop(space, request.getToStopId()) ;
		List<Itinerary> journeys =  RoutingAccessors.getJourneys(targetStop) ;
		if (journeys.size() <= 0) {
			System.out.println("No solution found.") ;
		}
		int i = 0 ;
		for (Itinerary it : journeys) {
			System.out.println("----------------------- Itinerary # " + (++i) + " of " + it.getDuration() + "s -----------------------") ;
			Connection c_prev = null ;
			for (Leg s : RoutingAccessors.getPath(it)) {
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

}

