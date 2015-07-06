package server.routing.rfs.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
	private Map<Date, ArrayList<Connection>> sorted_connections_by_date ; 
	private ArrayList<Connection> sorted_connections ; 
	private String currentDate = "" ;
	
	public Router (Space space) {
		this.space = space ;
		
		sorted_connections_by_date = new HashMap<Date, ArrayList<Connection>>();
		
		/* Tri des connections par date */
		for (Date date : RoutingAccessors.getAllValidDates(space)) {
			List<String> serviceIDs = RoutingAccessors.getServicesIdForDate(space, date) ;
			/* Contains all connections that the user could take in order to perform its trip */
			ArrayList<Connection> myList = new ArrayList<Connection>() ;
			for (String k : RoutingAccessors.getConnectionsKeySet(space)) {
				for (Connection c : RoutingAccessors.getConnections(space, k)) {
					if (serviceIDs.contains(c.getServiceId()))
						myList.add(c) ;				
				}
			}
			Collections.sort(myList); 
			sorted_connections_by_date.put(date, myList) ;
		}

		LOG.info("Lists of connections sorted by date created succesfully.");
	}
	
	public void processNewRequest (Request request) {
		this.request = request ;	
		if (request.getDate().equals(currentDate)) return ; /* Pas besoin de changer la liste déjà uptodate */ 
		Date date = RoutingAccessors.getDate(request) ;
		if (!sorted_connections_by_date.containsKey(date)) {
			System.err.println("This date doesn't exist in the GTFS bundle.") ;
			return ;
		}
		currentDate = request.getDate() ;
		sorted_connections = sorted_connections_by_date.get(RoutingAccessors.getDate(request)) ;
	}
	
	public void run_CSA () {

		LOG.info("Start computing solutions.");

		StopPoint sourceStop, targetStop ;
		sourceStop = RoutingAccessors.getStop(space, request.getFromStopId()) ;
		targetStop = RoutingAccessors.getStop(space, request.getToStopId()) ;
		long startTime = RoutingAccessors.getStartTime(request) ;
		
		/* Initialization */
		MyRoutingFactory.initialize(space) ;  

		/* Creation of the initial empty itinerary from the source */
		// TODO : il faut penser sur le dernier itinéraire itinéraire de rajouter le minimum connection time ??? Ou pas
		Itinerary it = MyRoutingFactory.createItinerary(null, null, "-1", startTime - sourceStop.getMinimalConnectionTime(), 
				startTime - sourceStop.getMinimalConnectionTime(), 0, 0.0, false) ; /* Itinéraire qui domine tous les autres */
		RoutingAccessors.getJourneys(sourceStop).add(it) ;
		
		/* Spread the first itinerary to all the neighbors */
		for (Footpath f : RoutingAccessors.getFootpaths(space, sourceStop.getStopId())) {
			updateStopPoint (sourceStop, RoutingAccessors.getStop(space, f.getArrivalId()), f, true, f.getArrivalId().equals(targetStop.getStopId()), false) ;
		}

		/* Create the list of all recommended routes which allow to reach the target or a target's neighbor */
		Set<String> recommendedRoutes = new HashSet<>() ;
		recommendedRoutes.addAll(RoutingAccessors.getRoutesId(targetStop)) ;
		for (Footpath f : RoutingAccessors.getFootpaths(space, targetStop.getStopId())) {
			recommendedRoutes.addAll(RoutingAccessors.getRoutesId(RoutingAccessors.getStop(space, f.getArrivalId()))) ;
		}
		System.out.println("Recommended routes : " + recommendedRoutes) ;
		
		StopPoint cDepStop, cArrStop ;
		
		/* Core of the algorithm */
		for (Connection c : sorted_connections) {
									
			if (c.getDepartureTime() < startTime) continue ; /* Before the departure */
			
			/* Break if we can't improve the best arrival time to the target */
			if (targetStop.getBestArrivalTime() <= c.getDepartureTime()) {
				break ;
			}			
			
			cDepStop = RoutingAccessors.getStop(space, c.getDepartureId()) ;
			cArrStop = RoutingAccessors.getStop(space, c.getArrivalId()) ;

			if (cArrStop.getStopId().equals(sourceStop.getStopId())) continue ;
			if (cDepStop.getStopId().equals(targetStop.getStopId())) continue ;
						
			if (cDepStop.getBestArrivalTime() + cDepStop.getMinimalConnectionTime() <= c.getDepartureTime() ||
					(c.getPrevC() != null && c.getPrevC().isRelaxed())) {
												
//				if (c.getTripId().equals("5369641") && c.getDepStopSequence() == 22) { 
//					System.out.println("Start on 70 : " + cDepStop.getStopId());
//				}
//
//				if (c.getTripId().equals("5369641") && c.getArrStopSequence() == 41) { 
//					System.out.println("Stop on 70 : " + cArrStop.getStopId());
//				}
//
//				if (c.getTripId().equals("5371186") && c.getDepStopSequence() == 26) { 
//					System.out.println("Start on 77 : " + cArrStop.getStopId());
//				}
//
//				if (c.getTripId().equals("5371186") && cArrStop.getStopId().equals("2391")) { 
//					System.out.println("Target reached");
//				}
				
				updateStopPoint (cDepStop, cArrStop, c, cDepStop.getStopId().equals(sourceStop.getStopId()), 
						cArrStop.getStopId().equals(targetStop.getStopId()), recommendedRoutes.contains(c.getRouteId())) ;
				
				/* TODO : la gestion des footpaths n'a rien à faire ici, il faut directement étendre les nouveaux itinéraires que l'on crée... */
				List<Footpath> footpaths = RoutingAccessors.getFootpaths(space, cArrStop.getStopId()) ;
				if (footpaths != null) { 
					for (Footpath f : footpaths) {
						boolean toTarget = f.getArrivalId().equals(targetStop.getStopId()) ;
						updateStopPoint (RoutingAccessors.getStop(space, f.getDepartureId()), 
								RoutingAccessors.getStop(space, f.getArrivalId()), f, false, toTarget, toTarget) ;
					}
				}
				
				c.setRelaxed(true);
			}

		}

		cleanItineraries(RoutingAccessors.getJourneys(targetStop)) ;
		
		LOG.info("Computing succeed.");

		/* Print itineraries */
		if (App.DEBUG) printJourneys() ;		
	}

	private void cleanItineraries(List<Itinerary> itineraries) {
		List<Itinerary> aux_itineraries =  new ArrayList<Itinerary> (itineraries) ;
		for (int i=0 ; i<aux_itineraries.size() ; i++) {
			for (int j=i+1 ; j<aux_itineraries.size() ; j++) {
				int res = aux_itineraries.get(i).compare(aux_itineraries.get(j)) ;
				if (res > 0) { /* We keed i and remove j */
					itineraries.remove(aux_itineraries.get(j));
				} else if (res < 0) { /* We keep j and remove i */
					itineraries.remove(aux_itineraries.get(i));
				}
			}
		}
	}

	/* Version avec un test de domination avant ajout */
	public void updateStopPoint (StopPoint dep, StopPoint arr, Leg l, boolean fromSource, boolean toTarget, boolean goodWay) {
		List<Itinerary> depJourneys = RoutingAccessors.getJourneys(dep) ;
		List<Itinerary> arrJourneys = RoutingAccessors.getJourneys(arr) ;
		
		long departureTime = 0, arrivalTime = 0 ; /* Default values never used */
		
		if (l instanceof Connection) {
			departureTime = ((Connection) l).getDepartureTime() ;
			arrivalTime = ((Connection) l).getArrivalTime() ;
		}
		
		for (Itinerary itdep : depJourneys) {
			
			if (l instanceof Footpath) {
				departureTime = itdep.getArrivalTime() ;
				arrivalTime = departureTime + ((Footpath) l).getDuration() ; /* TODO : prendre en compte le temps minimum de correspondance */
			}
			
			boolean toBeAdded = true ;
			
			if (itdep.getArrivalTime() + dep.getMinimalConnectionTime() > departureTime) continue ; /* In time for the transfer */
			if (itdep.getLastTrip().equals("") && l.getTripId().equals("")) continue ; /* Transitive footpath closure */
			
			/* Computing parameters of the new itinerary (itdep + l) */
			int nbTransfers = itdep.getNbTransfers() ; 
			if (!l.getTripId().equals("") && !itdep.getLastTrip().equals(l.getTripId())) nbTransfers ++;
			long time = fromSource?departureTime:itdep.getDepartureTime() ; /* Departure time */
			if (toTarget) time = arrivalTime - time ; /* Duration */
			double walkingDistance = itdep.getWalkingDistance() ;
			if (l instanceof Footpath) walkingDistance += ((Footpath) l).getDistance() ;

			/* Compare the new itinerary to the existing ones : check for domination */
			if (arrJourneys.size() > 0) {
				for (Itinerary itarr : new ArrayList<Itinerary>(arrJourneys)) { 
					int dom = itarr.isDominated(time, nbTransfers, walkingDistance, toTarget, goodWay) ; 
//					if (l.getTripId().equals("5371186") && nbTransfers == 2) {
//						if (dom > 0) System.out.println("Dominé : " + walkingDistance + " vs " + itarr.getWalkingDistance() + " ; "
//								 + nbTransfers + " vs " + itarr.getNbTransfers() + " ; "
//								 + time + " vs " + itarr.getDepartureTime() + " ; "
//								 + goodWay + " vs " + itarr.isIsOnRightWay()) ;
//					}
					if (dom == 1) { // The new itinerary is dominated by an existing one.
						toBeAdded = false ;
						break ; 
					} else if (dom == -1) { // The new itinerary dominate an existing one.
						arrJourneys.remove(itarr) ;
					} 
				}
			}
							
			/* Create and add the new itinerary if needed */
			if (toBeAdded) {
				/* TODO : c'est ici qu'il faut propager les footpahts si on est dans le cas d'une connexion ... que sur les nouveau it, pas la peine deja fait pour les autres, ca entraine des merdes car mauvais arrival time */
				Itinerary it = MyRoutingFactory.createItinerary(itdep, l, l.getTripId(), fromSource?departureTime:itdep.getDepartureTime(), arrivalTime, nbTransfers, walkingDistance, goodWay) ;
				if (it != null) arrJourneys.add(it) ;
			}
		}		
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
			System.out.println("----------------------- Itinerary # " + (++i) + " of " + it.getDuration() + "s with " + it.getNbTransfers() + " transfers and " + it.getWalkingDistance() + "m walking -----------------------") ;
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

