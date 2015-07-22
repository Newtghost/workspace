package server.routing.rfs.core;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import routing.Connection;
import routing.Footpath;
import routing.Itinerary;
import routing.Leg;
import routing.Space;
import routing.StopPoint;
import common.Request;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import server.routing.rfs.util.RoutingAccessors;
import server.routing.rfs.services.App;
import server.routing.rfs.util.MyRoutingFactory;

public class Router {
	
    private static final Logger LOG = LoggerFactory.getLogger(Router.class);

    /* Useful to try to found more itineraries which could reach the target after the best one */
	private static final long ARRIVAL_MARGIN = 10*60; // in seconds

	private Request request ;
	
	Space space ;
	public Map<String, ArrayList<Connection>> sorted_connections_by_date ; 
	private ArrayList<Connection> sorted_connections ; 
	public final Lock updateLock = new ReentrantLock() ;
	public List<String> banned_routes ;
	private String currentDate = "" ;
	
	public Router (Space space, Updater updater) {
		this.space = space ;

		sorted_connections_by_date = new HashMap<String, ArrayList<Connection>>();
		
		/* Tri des connections par date */
		for (String date : RoutingAccessors.getAllValidDates(space)) {
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

		/* We have to update only connections available for the current date 
		 * there is no delay for a trip planned tomorrow */
		LocalDate today = LocalDate.now() ;
		updater.setConnectionsToUpdate(sorted_connections_by_date.get(today.toString()), updateLock);
		
		LOG.info("Lists of connections sorted by date created succesfully.");
	}
	
    public static int sortByAge(Connection p1, Connection p2) {
    	return 0 ;
    }
	
	public void processNewRequest (Request request) throws DateException {
		this.request = request ;	
		
		/* If the date isn't the same as before, then load the corresponding connections */
		if (!request.getDate().equals(currentDate)) { 
			if (!sorted_connections_by_date.containsKey(request.getDate())) {
				throw new DateException() ;
			}
			currentDate = request.getDate() ;
			sorted_connections = sorted_connections_by_date.get(request.getDate()) ;
		}
		
		/* Update the list of the banned routes */
		banned_routes = RoutingAccessors.getBannedRoutes(request) ;
	}
	
	public void run_CSA () {

		LOG.info("Start computing solutions.");

		StopPoint sourceStop, targetStop ;
		
		if (request.hasStopsId()) {
			sourceStop = RoutingAccessors.getStopFromId(space, request.getFromStopId()) ;
			targetStop = RoutingAccessors.getStopFromId(space, request.getToStopId()) ;
		} else {
			sourceStop = RoutingAccessors.getStopFromCoordinates(space, request.getFromLat(), request.getFromLon()) ;
			targetStop = RoutingAccessors.getStopFromCoordinates(space, request.getToLat(), request.getToLon()) ;
		}
		
		if (sourceStop == null || targetStop==null) {
			System.err.print("Corresponding source and target stops not found.");
			return ;
		} else {
			System.out.println(sourceStop.getStopId() + " --> " + targetStop.getStopId());
		}
		
		long startTime = RoutingAccessors.getStartTime(request) ;
		System.out.println("Start time : " + startTime) ;
		
		updateLock.lock();
		try {
			/* Initialization */
			MyRoutingFactory.initialize(space) ;  
	
			/* Creation of the initial empty itinerary from the source */
			Itinerary it = MyRoutingFactory.createItinerary(null, null, "-1", startTime, startTime, 0, 0.0, false) ; /* Itinéraire qui domine tous les autres */
			RoutingAccessors.getJourneys(sourceStop).add(it) ;
			
			/* Extend the first itinerary to all the neighbors */
			extendItineraryWithFootpaths(targetStop, it, sourceStop, sourceStop) ;
	
			/* Create the list of all recommended routes which allow to reach the target or a target's neighbor */
			Set<String> recommendedRoutes = new HashSet<>() ;
			recommendedRoutes.addAll(RoutingAccessors.getRoutesId(targetStop)) ;
			for (Footpath f : RoutingAccessors.getFootpaths(space, targetStop.getStopId())) {
				recommendedRoutes.addAll(RoutingAccessors.getRoutesId(RoutingAccessors.getStopFromId(space, f.getArrivalId()))) ;
			}
			System.out.println("Recommended routes : " + recommendedRoutes) ;
			
			StopPoint cDepStop, cArrStop ;
			
			/* Core of the algorithm */
			for (Connection c : sorted_connections) {
										
				if (c.getDepartureTime() < startTime) continue ; /* Before the departure */
				if (banned_routes.contains(c.getRouteId())) continue ; /* Banned route */
				
				/* If we can't improve the best arrival time to the target then we will only try to complete running itineraries */
				if (targetStop.getBestArrivalTime() <= c.getDepartureTime()) {
					if (targetStop.getBestArrivalTime() + ARRIVAL_MARGIN <= c.getDepartureTime()) break ;
					if (!recommendedRoutes.contains(c.getRouteId())) {
						continue ;
					}
				}			
				
				cDepStop = RoutingAccessors.getStopFromId(space, c.getDepartureId()) ;
				cArrStop = RoutingAccessors.getStopFromId(space, c.getArrivalId()) ;
	
				if (cArrStop.getStopId().equals(sourceStop.getStopId())) continue ;
				if (cDepStop.getStopId().equals(targetStop.getStopId())) continue ;
							
				if (cDepStop.getBestArrivalTime() + cDepStop.getMinimalConnectionTime() <= c.getDepartureTime() + c.getDepartureDelay() ||
						(c.getPrevC() != null && c.getPrevC().isRelaxed())) {

					/* Concernant l'horaire à 13h20,
					 * La deuxième connexion est coupée à cause d'un itinéraire bien plus performant à ce moment là, mais
					 * sur une moins bonne ligne... cependant on ne le sait pas à ce moment là.
					 * Ecart de 200m et de 900s environs.
					 * C'est "normal", à voir avec l'évolution de l'algorithme, etc. Le comportement est particulier,
					 * un itinéraire peu etre pas terrible, fort coût d'entrée, mais peut se révéler très bien... comment ne pas le couper, etre tres laxiste ?
					 * D'un autre côté si on ne coupe pas assez les itinéraires les performances explosent... exponentiel.
					 * */
					
					/* Concernant l'horaire à 11h30,
					 * Il ne trouve l'itinéraire de longueur 2 qui si l'on prolonge les bonnes lignes.
					 * Pour cela cependant il faut que le time margin ne soit pas nul...
					 * Attention risque de degrader les perfs avec un time-margin trop grand. 
					 * Concernant les deux itinéraires plus rapides, on ne les trouve pas car il faudrait
					 * envisager des footpaths de plus de 800m ce qui n'est pas le cas aujourd'hui... */
					
					if (c.getTripId().equals("5371182") && c.getDepartureId().equals("1612")) {
						System.out.println("---------------- On commence ------------------") ;
					}
					if (c.getTripId().equals("5371182") && c.getArrivalId().equals("2391")) {
						System.out.println("------------- Stop ---------------------") ;
					}
													
					updateStopPoint (cDepStop, cArrStop, c, targetStop, cDepStop.getStopId().equals(sourceStop.getStopId()), 
							recommendedRoutes.contains(c.getRouteId())) ;
									
					c.setRelaxed(true);
				}
	
			}
		}
		finally {
			updateLock.unlock();
		}

		cleanItineraries(RoutingAccessors.getJourneys(targetStop)) ;
		
		LOG.info("Computing succeed.");

		/* Print itineraries */
		printJourneys() ;		
	}

	/**
	 * @param itineraries
	 */
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
	public void updateStopPoint (StopPoint dep, StopPoint arr, Connection c, StopPoint target, boolean fromSource, boolean goodWay) {		
		List<Itinerary> depJourneys = RoutingAccessors.getJourneys(dep) ;
		for (Itinerary itdep : depJourneys) {
//			if (c.getTripId().equals("5369641")) {
//				System.out.println("Computing... ") ;
//			}
			if (itdep.getArrivalTime() + dep.getMinimalConnectionTime() > c.getDepartureTime() + c.getDepartureDelay()) continue ; /* In time for the transfer */
			
			/* Computing parameters of the new itinerary (itdep + l) */
			int nbTransfers = itdep.getNbTransfers() ; 
			if (!itdep.getLastTrip().equals(c.getTripId())) nbTransfers ++;

			Itinerary it = MyRoutingFactory.createItinerary(itdep, c, c.getTripId(), fromSource?c.getDepartureTime():itdep.getDepartureTime(), 
					c.getArrivalTime() + c.getArrivalDelay(), nbTransfers, itdep.getWalkingDistance(), goodWay) ;
			if (it == null) continue ;
							

			/* Create and add the new itinerary if needed */
			if (itineraryAdded (arr, it, arr.getStopId().equals(target.getStopId()))) {
				extendItineraryWithFootpaths(target, it, dep, arr) ;
			}
		}		
	}
	
	/* Compare the itinerary to the existing ones : check for domination and delete dominated itineraries
		Add the current itinerary to the list if it is not dominated */
	private boolean itineraryAdded (StopPoint arr, Itinerary it, boolean toTarget) {
		List<Itinerary> arrJourneys = RoutingAccessors.getJourneys(arr) ;
		boolean toBeAdded = true ;
		if (arrJourneys.size() > 0) {
			for (Itinerary itarr : new ArrayList<Itinerary>(arrJourneys)) { 
				int dom = itarr.isDominated(toTarget?it.getDuration():it.getDepartureTime(), it.getNbTransfers(), 
						it.getWalkingDistance(), toTarget, it.isIsOnRightWay()) ; 
				if (dom == 1) { /* The new itinerary is dominated by an existing one */
					toBeAdded = false ;
					break ; 
				} else if (dom == -1) { /* The new itinerary dominate an existing one */
					arrJourneys.remove(itarr) ;
				} 
			}
		}
		if (toBeAdded) arrJourneys.add(it) ; /* We add the itinerary to the list */
		return toBeAdded ;
	}
	
	/* Extend current itinerary with footpaths */
	private void extendItineraryWithFootpaths (StopPoint target, Itinerary it, StopPoint dep, StopPoint arr) {
		List<Footpath> footpaths = RoutingAccessors.getFootpaths(space, arr.getStopId()) ;
		if (footpaths != null) { 
			for (Footpath f : footpaths) {
				if (f.getArrivalId().equals(dep.getStopId())) continue ;
				boolean toTarget = f.getArrivalId().equals(target.getStopId()) ;
				Itinerary itP = MyRoutingFactory.createItinerary(it, f, f.getTripId(), it.getDepartureTime(), 
						it.getArrivalTime() + arr.getMinimalConnectionTime() + f.getDuration(), it.getNbTransfers(), it.getWalkingDistance() + f.getDistance(), toTarget) ;
				itineraryAdded (RoutingAccessors.getStopFromId(space, f.getArrivalId()), itP, toTarget) ;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public String journey2Json() throws IOException, JSONException {
		
		/* TODO : refactorer cette fonction en plus compact.... moins de duplication */
		
		JSONObject obj = new JSONObject();
		JSONObject plan = new JSONObject();
		JSONArray itineraries = new JSONArray();
		JSONObject itinerary = null;
		JSONArray legs = null;
		JSONObject leg = null;

		Connection prevC = null ;
		long prevEndTime ; /* Utile pour calculer les start time et end time des footpaths */

		/* Le calcul d'itinéraire se fait avec un horaire local : LocalDate / LocalDateTime
		 * Ce n'est qu'au moment de l'export json que l'on passe dans un référentiel "global" en 
		 * prenant en compte la date et la timezone.
		 */

		final Instant instant = LocalTime.MIN.atDate(LocalDate.parse(request.getDate())).toInstant(ZoneOffset.UTC);
		final long date = instant.toEpochMilli() ; // in millis
		final long tzOffset = ZoneId.of(space.getTimezone()).getRules().getOffset(instant).getTotalSeconds() * 1000 ; // in millis
				
		StopPoint targetStop;
		if (request.hasStopsId()) {
			targetStop = RoutingAccessors.getStopFromId(space, request.getToStopId()) ;
		} else {
			targetStop = RoutingAccessors.getStopFromCoordinates(space, request.getToLat(), request.getToLon()) ;
		}

		for (Itinerary it : RoutingAccessors.getJourneys(targetStop)) {

			prevEndTime = RoutingAccessors.getStartTime(request) * 1000 ; 
			itinerary = new JSONObject();
			legs = new JSONArray();
			
			for (Leg s : RoutingAccessors.getPath(it)) {
	
				if (s instanceof Footpath) {
	
					if (leg != null) { /* Signifie qu'on a changé de Leg et qu'on doit donc ajouter le segment précédent qui est terminé */	
						JSONObject to = new JSONObject() ;
						to.put("name", RoutingAccessors.getStopFromId(space, prevC.getArrivalId()).getName()) ;
						to.put("stopId", prevC.getArrivalId()) ;
						to.put("stopSequence", prevC.getArrStopSequence()) ;
						leg.put("to", to) ;
						prevEndTime = (prevC.getArrivalTime() +  prevC.getArrivalDelay()) * 1000 ;
						leg.put("endTime", prevEndTime + date - tzOffset) ;
						leg.put("arrivalDelay", prevC.getArrivalDelay()) ;
						legs.add(leg) ;
						leg = null ;
					}
	
					/* New leg corresponding to a footpath */
					leg = new JSONObject() ;
					leg.put("agencyName", space.getAgencyName()) ;
					leg.put("agencyTimeZoneOffset", tzOffset) ;
					JSONObject from = new JSONObject() ;
					JSONObject to = new JSONObject() ;
					from.put("name", RoutingAccessors.getStopFromId(space, s.getDepartureId()).getName()) ;
					from.put("stopId", s.getDepartureId()) ;
					to.put("name", RoutingAccessors.getStopFromId(space, s.getArrivalId()).getName()) ;
					to.put("stopId", s.getArrivalId()) ;
					leg.put("from", from) ;
					leg.put("to", to) ;
					leg.put("startTime", prevEndTime + date - tzOffset) ;
					prevEndTime += ((Footpath) s).getDuration() * 1000;
					leg.put("endTime", prevEndTime + date - tzOffset) ;
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
							to.put("name", RoutingAccessors.getStopFromId(space, prevC.getArrivalId()).getName()) ;
							to.put("stopId", prevC.getArrivalId()) ;
							to.put("stopSequence", prevC.getArrStopSequence()) ;
							leg.put("to", to) ;
							prevEndTime = (prevC.getArrivalTime() + prevC.getArrivalDelay()) * 1000 ;
							leg.put("endTime", prevEndTime + date - tzOffset) ;
							leg.put("arrivalDelay", prevC.getArrivalDelay()) ;
							legs.add(leg) ;
							leg = null ;
						}
						
						/* Creation of a new transit path */
						leg = new JSONObject() ;
						leg.put("agencyName", space.getAgencyName()) ;
						leg.put("agencyTimeZoneOffset", tzOffset) ;
						JSONObject from = new JSONObject() ;
						from.put("name", RoutingAccessors.getStopFromId(space, c.getDepartureId()).getName()) ;
						from.put("stopId", c.getDepartureId()) ;
						from.put("stopSequence", c.getDepStopSequence()) ;
						leg.put("from", from) ;
						leg.put("startTime", (c.getDepartureTime() + c.getDepartureDelay()) * 1000 + date - tzOffset) ;
						leg.put("departureDelay", c.getDepartureDelay()) ;
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
				to.put("name", RoutingAccessors.getStopFromId(space, prevC.getArrivalId()).getName()) ;
				to.put("stopId", prevC.getArrivalId()) ;
				to.put("stopSequence", prevC.getArrStopSequence()) ;
				leg.put("to", to) ;
				prevEndTime = (prevC.getArrivalTime() + prevC.getArrivalDelay()) * 1000 ;
				leg.put("endTime", prevEndTime + date - tzOffset) ;
				leg.put("arrivalDelay", prevC.getArrivalDelay()) ;
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
		StopPoint targetStop;
		if (request.hasStopsId()) {
			targetStop = RoutingAccessors.getStopFromId(space, request.getToStopId()) ;
		} else {
			targetStop = RoutingAccessors.getStopFromCoordinates(space, request.getToLat(), request.getToLon()) ;
		}

		List<Itinerary> journeys =  RoutingAccessors.getJourneys(targetStop) ;
		if (journeys.size() <= 0) {
			System.out.println("No solution found.") ;
		}
		int i = 0 ;
		for (Itinerary it : journeys) {
			System.out.println("----------------------- Itinerary # " + (++i) + " of " + it.getDuration() + "s with " + it.getNbTransfers() + " transfers and " + it.getWalkingDistance() + "m walking -----------------------") ;
			if (App.DEBUG) {
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

}

