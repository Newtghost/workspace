
/**
 * Core of the routing app with the implementation of the CSA algorithm.
 * All the computation is achieved in Local Time : LocalDate / LocalDateTime
 * We taking into account timezones when we export itineraries into Json.
 * @author David Leydier
 */

package server.routing.rfs.core;

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
	private static final long ARRIVAL_MARGIN = 31*60; // in seconds

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
	
	public String processNewRequest (Request request) throws DateException, JSONException {
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
		
		/* Run the algorithm */
		run_CSA();
		
		/* Return the result */
		return journey2Json() ;
	}
	
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
	 * Pour cela cependant il faut que le time margin soit au moins de 30 minutes.
	 * Attention risque de degrader les perfs avec un time-margin trop grand. 
	 * Concernant les deux itinéraires plus rapides, on ne les trouve pas car il faudrait
	 * envisager des footpaths de plus de 800m ce qui n'est pas le cas aujourd'hui... */
	
	private void run_CSA () {

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
			LOG.info("Corresponding source and target stops not found.");
			return ;
		} else {
			LOG.info("Run CSA algorithm: " + sourceStop.getStopId() + " --> " + targetStop.getStopId());
		}
		
		long startTime = RoutingAccessors.getStartTime(request) ;
		LOG.info("Start time: " + startTime);
		
		updateLock.lock();
		try {
			/* Initialization */
			MyRoutingFactory.initialize(space) ;  
	
			/* Creation of the initial empty itinerary from the source */
			Itinerary it = MyRoutingFactory.createItinerary(null, null, "-1", startTime, startTime, 0, 0.0, 0, false, "") ; /* Itinéraire qui domine tous les autres */
			RoutingAccessors.getJourneys(sourceStop).add(it) ;
			
			/* Extend the first itinerary to all the neighbors */
			extendItineraryWithFootpaths(targetStop, it, sourceStop, sourceStop) ;
	
			/* Create the list of all recommended routes which allow to reach the target or a target's neighbor */
			Set<String> recommendedRoutes = new HashSet<>() ;
			recommendedRoutes.addAll(RoutingAccessors.getRoutesId(targetStop)) ;
			for (Footpath f : RoutingAccessors.getFootpaths(space, targetStop.getStopId())) {
				recommendedRoutes.addAll(RoutingAccessors.getRoutesId(RoutingAccessors.getStopFromId(space, f.getArrivalId()))) ;
			}
			LOG.info("Recommended routes : " + recommendedRoutes);
			
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
					
					updateStopPoint (cDepStop, cArrStop, c, targetStop, cDepStop.getStopId().equals(sourceStop.getStopId()), 
							recommendedRoutes.contains(c.getRouteId())) ;
									
					c.setRelaxed(true);
				}
	
			}
		}
		finally {
			updateLock.unlock();
		}
		
		LOG.info("Computing succeed.");

		/* Print itineraries */
		printJourneys() ;		
	}

	/* Version avec un test de domination avant ajout */
	public void updateStopPoint (StopPoint dep, StopPoint arr, Connection c, StopPoint target, boolean fromSource, boolean goodWay) {		
		List<Itinerary> depJourneys = RoutingAccessors.getJourneys(dep) ;
		for (Itinerary itdep : depJourneys) {

			if (itdep.getArrivalTime() + dep.getMinimalConnectionTime() > c.getDepartureTime() + c.getDepartureDelay()) continue ; /* In time for the transfer */
			
			/* Computing parameters of the new itinerary (itdep + l) */
			int nbTransfers = itdep.getNbTransfers() ; 
			long waitingTime = itdep.getWaitingTime() ; 
			String trips = itdep.getTrips() ; 
			if (!itdep.getLastTrip().equals(c.getTripId())) {
				nbTransfers ++;
				trips += c.getTripId() + ";" ;
				if (!fromSource) waitingTime += c.getDepartureTime() - itdep.getArrivalTime() ; 
			}

			Itinerary it = MyRoutingFactory.createItinerary(itdep, c, c.getTripId(), fromSource?c.getDepartureTime():itdep.getDepartureTime(), 
					c.getArrivalTime() + c.getArrivalDelay(), nbTransfers, itdep.getWalkingDistance(), waitingTime, goodWay, trips) ;
			
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
				int dom = itarr.isDominated(request, it, toTarget) ; 
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
						it.getArrivalTime() + arr.getMinimalConnectionTime() + f.getDuration(), it.getNbTransfers(), 
						it.getWalkingDistance() + f.getDistance(), it.getWaitingTime(), toTarget, it.getTrips()) ;
				itineraryAdded (RoutingAccessors.getStopFromId(space, f.getArrivalId()), itP, toTarget) ;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private String journey2Json() throws JSONException {
		final Instant instant = LocalTime.MIN.atDate(LocalDate.parse(request.getDate())).toInstant(ZoneOffset.UTC);
		final long date = instant.toEpochMilli() ; // in millis
		final long tzOffset = ZoneId.of(space.getTimezone()).getRules().getOffset(instant).getTotalSeconds() * 1000 ; // in millis

		long prevEndTime ; /* Utile pour calculer les start time et end time des footpaths */
		Connection prevC = null ;
		
		StopPoint targetStop;

		if (request.hasStopsId()) {
			targetStop = RoutingAccessors.getStopFromId(space, request.getToStopId()) ;
		} else {
			targetStop = RoutingAccessors.getStopFromCoordinates(space, request.getToLat(), request.getToLon()) ;
		}

		JSONObject obj = new JSONObject();
		JSONObject plan = new JSONObject();
		JSONArray itineraries = new JSONArray();
		JSONObject itinerary = null;
		JSONArray legs = null;
		JSONObject leg = null;

		for (Itinerary it : RoutingAccessors.getJourneys(targetStop)) {
			itinerary = jsonItinerary(it, date, tzOffset);
			legs = new JSONArray();
			prevEndTime = RoutingAccessors.getStartTime(request) * 1000 ; 
			for (Leg s : RoutingAccessors.getPath(it)) {
	
				if (s instanceof Footpath) {
	
					if (leg != null) { /* Signifie qu'on a changé de Leg et qu'on doit donc ajouter le segment précédent qui est terminé */	
						prevEndTime = (prevC.getArrivalTime() +  prevC.getArrivalDelay()) * 1000 ;
						completeJsonLeg (legs, leg, date, prevEndTime, tzOffset, prevC) ;
						leg = null ;
					}
	
					/* New leg corresponding to a footpath */
					leg = new JSONObject() ;
					initJsonLeg (leg, date, prevEndTime, tzOffset, s) ;
					completeJsonLeg (legs, leg, date, prevEndTime + ((Footpath) s).getDuration() * 1000, tzOffset, s) ;
					leg = null ;
	
				} else {
					
					Connection c = (Connection) s ;

					/* TODO : le agencyTimeZoneOffset d'une leg (c.getAgencyTimeZoneOffset() et c.setAgencyTimeZoneOffset()) 
					 	ne servent que pour le tracker (affichage leg par leg) il vaudrait mieux avoir l'info
					 	qu'une seule fois comme dans le nouveau tracker (angularJS) - à terme, supprimer */
					
					if (prevC == null || ! c.getTripId().equals(prevC.getTripId())) {
						if (leg != null) { /* Signifie qu'on a changé de Leg et qu'on doit donc ajouter le segment précédent qui est terminé */	
							prevEndTime = (prevC.getArrivalTime() + prevC.getArrivalDelay()) * 1000 ;
							completeJsonLeg (legs, leg, date, prevEndTime, tzOffset, prevC) ;
							leg = null ;
						}
						
						/* Creation of a new transit path */
						leg = new JSONObject() ;
						initJsonLeg (leg, date, (c.getDepartureTime() + c.getDepartureDelay()) * 1000, tzOffset, c) ;
	
					}
					
					prevC = c ;
				}
			}
			
			if (leg != null) { /* On doit ajouter le dernier segment (en cours) */	
				prevEndTime = (prevC.getArrivalTime() + prevC.getArrivalDelay()) * 1000 ;
				completeJsonLeg (legs, leg, date, prevEndTime, tzOffset, prevC) ;
				leg = null ;
			}
						
			itinerary.put("legs", legs) ;
			itineraries.add(itinerary) ;

			prevC = null ;
		}
		
		plan.put("itineraries", itineraries) ;
		obj.put("plan", plan) ;
		
        return obj.toString();
	}
	
	/* Les heures/dates passés dans le json correspondent au bon fuseau horaire,
	 * i.e. celui de Portland ici - ce qui explique le -tzOffset */
	private JSONObject jsonItinerary (Itinerary it, long date, long tzOffset) throws JSONException {
		JSONObject itinerary = new JSONObject();
		itinerary.put("startTime", it.getDepartureTime()*1000 + date - tzOffset) ;
		itinerary.put("endTime", it.getArrivalTime()*1000 + date - tzOffset) ;
		itinerary.put("duration", it.getDuration()*1000) ;
		itinerary.put("nbTransfers", it.getNbTransfers()) ;
		itinerary.put("walkingDistance", it.getWalkingDistance()) ;
		itinerary.put("waitingTime", it.getWaitingTime()*1000) ;
		itinerary.put("agencyTimeZoneOffset", tzOffset) ;
		return itinerary;
	}

	private void initJsonLeg (JSONObject leg, long date, long prevEndTime, long tzOffset, Leg l) throws JSONException {
		leg.put("agencyName", space.getAgencyName()) ;
		leg.put("agencyTimeZoneOffset", tzOffset) ;
		JSONObject from = new JSONObject() ;
		from.put("name", RoutingAccessors.getStopFromId(space, l.getDepartureId()).getName()) ;
		from.put("stopId", l.getDepartureId()) ;
		leg.put("startTime", prevEndTime + date - tzOffset) ;
		leg.put("departureDelay", 0) ;
		if (l instanceof Connection) {
			from.put("stopSequence", ((Connection) l).getDepStopSequence()) ;
			leg.put("mode", "TRANSIT") ;
			leg.put("distance", 0.1) ; /* Default value */
			leg.put("routeId", ((Connection) l).getRouteId()) ;
			leg.put("agencyId", "") ;
			leg.put("tripId", ((Connection) l).getTripId()) ;
		} else {
			leg.put("distance", ((Footpath) l).getDistance()) ;
			leg.put("mode", "WALK") ;
		}
		leg.put("from", from) ;
	}

	@SuppressWarnings("unchecked")
	private void completeJsonLeg (JSONArray legs, JSONObject leg, long date, long prevEndTime, long tzOffset, Leg l) throws JSONException {
		JSONObject to = new JSONObject() ;
		to.put("name", RoutingAccessors.getStopFromId(space, l.getArrivalId()).getName()) ;
		to.put("stopId", l.getArrivalId()) ;
		if (l instanceof Connection) to.put("stopSequence", ((Connection) l).getArrStopSequence()) ;
		leg.put("to", to) ;
		leg.put("endTime", prevEndTime + date - tzOffset) ;
		leg.put("arrivalDelay", 0) ;
		legs.add(leg) ;
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
			LOG.info("No solution found.");
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

