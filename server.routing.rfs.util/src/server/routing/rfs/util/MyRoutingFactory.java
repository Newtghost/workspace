package server.routing.rfs.util;

import java.util.Arrays;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import routing.Itinerary;
import routing.Leg;
import routing.RoutingFactory;
import routing.RoutingPackage;
import routing.Space;
import routing.Connection;
import routing.Footpath;
import routing.StopPoint;
import common.CommonFactory;
import common.Request;
import common.util.EmfUtil;

public class MyRoutingFactory {
	
	private static final int DEFAULT_MAXIMUM_WALK = 750 ; /* in meters */
	private static final int DEFAULT_MAXIMUM_WAIT = 15*16 ; /* in seconds */
	private static final int DEFAULT_SIGNIFICANT_GAP_WALK = 250 ; /* in meters */
	private static final int DEFAULT_SIGNIFICANT_GAP_DEPARTURE = 600 ; /* in seconds */
	private static final int DEFAULT_SIGNIFICANT_GAP_DURATION = 300 ; /* in seconds */

	public static Connection createConnection (String serviceId, String tripId, String routeId, String departureId, String arrivalId, 
			long departureTime, long arrivalTime, int departureSeq, int arrivalSeq) {
		Connection c = RoutingFactory.eINSTANCE.createConnection() ;
		c.setServiceId(serviceId) ;
		c.setTripId(tripId) ;
		c.setRouteId(routeId) ;
		c.setArrivalId(arrivalId) ;
		c.setDepartureId(departureId) ;
		c.setArrivalTime(arrivalTime) ;
		c.setDepartureTime(departureTime) ;
		c.setDepStopSequence(departureSeq) ;
		c.setArrStopSequence(arrivalSeq) ;
		c.setDepartureDelay(0);
		c.setArrivalDelay(0);
		return c ;
	}
	
	public static Footpath createFootpath (String departureId, String arrivalId, double depLat, double depLon, double arrLat, double arrLon) {
		Footpath f = RoutingFactory.eINSTANCE.createFootpath() ;
		f.setDepartureId(departureId);
		f.setArrivalId(arrivalId);
		f.setTripId("");
		f.setDistance(Leg.gps2m(depLat, depLon, arrLat, arrLon)) ; /* Calcul de la distance */
		f.setDuration((int) (f.getDistance()/Leg.WALKING_SPEED));
		return f ;
	}
	
	public static StopPoint createStopPoint (String stopId, String name, int minimumConnectionTime, double latitude, double longitude, Set<String> routesId) {
		StopPoint s = RoutingFactory.eINSTANCE.createStopPoint() ;
		s.setStopId(stopId);
		s.setName(name);
		s.setMinimalConnectionTime(minimumConnectionTime);
		s.setLatitude(latitude);
		s.setLongitude(longitude);
		if (routesId != null) s.getRoutesId().addAll(routesId); /* Pas de routes qui passent par ce StopPoint */
		return s ;
	}

	public static Request createRequest (String departureId, String arrivalId, String time, String date, String bannedRoutes, 
			String maximumWait, String maximumWalk, String gapDeparture, String gapDuration, String gapWalk) {
		
		Request r = createRequest(time, date, bannedRoutes, maximumWait, maximumWalk, gapDeparture, gapDuration, gapWalk) ;
		r.setFromStopId(departureId);
		r.setToStopId(arrivalId);		
		return r ;
	}

	public static Request createRequest (String fromLat, String fromLon, String toLat, String toLon, String time, String date, 
			String bannedRoutes, String maximumWait, String maximumWalk, String gapDeparture, String gapDuration, String gapWalk) {
		
		Request r = createRequest(time, date, bannedRoutes, maximumWait, maximumWalk, gapDeparture, gapDuration, gapWalk) ;
		r.setFromLat(Double.parseDouble(fromLat));
		r.setFromLon(Double.parseDouble(fromLon));		
		r.setToLat(Double.parseDouble(toLat));
		r.setToLon(Double.parseDouble(toLon));
		return r ;
	}
	
	private static Request createRequest (String time, String date, String bannedRoutes, String maximumWait, String maximumWalk, 
			String gapDeparture, String gapDuration, String gapWalk) {
		
		Request r = CommonFactory.eINSTANCE.createRequest() ;
		
		/* Mandatory parameters of the request date and time */
		r.setTime(time);
		r.setDate(date);

		/* Banned routes */
		String[] routes = bannedRoutes.split(",");
		for (int i = 0; i < routes.length ; i++)
			r.getBannedRoutes().add(routes[i]);
		
		/* Parameters useful to define the user profile
		 * There are not mandatory because they have default values */
		if(maximumWait.equals("")) r.setMaximumWait(DEFAULT_MAXIMUM_WAIT);
		else r.setMaximumWait(Integer.parseInt(maximumWait));
		
		if (maximumWalk.equals("")) r.setMaximumWalk(DEFAULT_MAXIMUM_WALK);
		else r.setMaximumWalk(Integer.parseInt(maximumWalk));
		
		if (gapDeparture.equals("")) r.setSignificantGapDeparture(DEFAULT_SIGNIFICANT_GAP_DEPARTURE);
		else r.setSignificantGapDeparture(Integer.parseInt(gapDeparture));
		
		if (gapDuration.equals("")) r.setSignificantGapDuration(DEFAULT_SIGNIFICANT_GAP_DURATION);
		else r.setSignificantGapDuration(Integer.parseInt(gapDuration));

		if (gapWalk.equals("")) r.setSignificantGapWalk(DEFAULT_SIGNIFICANT_GAP_WALK);
		else r.setSignificantGapWalk(Integer.parseInt(gapWalk));
		
		return r ;
	}
	
	public static Connection addConnection (Space space, String serviceId, String tripId, String routeId, String departureId, String arrivalId, 
			long departureTime, long arrivalTime, int departureSeq, int arrivalSeq) {
		Connection c = createConnection(serviceId, tripId, routeId, departureId, arrivalId, departureTime, arrivalTime, departureSeq, arrivalSeq) ;
		if (space.getConnections().containsKey(departureId)) {
			space.getConnections().get(departureId).add(c) ;
		} else {
			EList<Connection> list = new BasicEList<Connection>(Arrays.asList(c));
			space.getConnections().put(departureId, list) ;
		}
		return c ;
	}
	
	public static void addFootpath (Space space, String departureId, String arrivalId, double depLat, double depLon, double arrLat, double arrLon) {
		Footpath f = createFootpath(departureId, arrivalId, depLat, depLon, arrLat, arrLon);
		if (space.getFootpaths().containsKey(departureId)) {
			space.getFootpaths().get(departureId).add(f) ;
		} else {
			EList<Footpath> list = new BasicEList<Footpath>(Arrays.asList(f));
			space.getFootpaths().put(departureId, list) ;
		}
	}
	
	public static void addStopPoint (Space space, String stopId, String name, int minimumConnectionTime, double latitude, double longitude, Set<String> routesId) {
		StopPoint s = createStopPoint(stopId, name, minimumConnectionTime, latitude, longitude, routesId);
		space.getStops().put(stopId, s) ;
	}

	public static boolean serialize(Space space, String path) {
		return EmfUtil.doSaveBin(space, path + "\\rfsMaps",".obj") ; 
	}

	public static Space deserialize(String path) {
		return (Space) EmfUtil.doOpenBin(RoutingPackage.eINSTANCE, path + "\\rfsMaps",".obj");
	}

	public static void initialize(Space space) {
		for (StopPoint p : RoutingAccessors.getStops(space)) {
			p.getBestJourneys().clear();
		}	
		
		for (String k : space.getConnections().keySet()) {
			for (Connection c : space.getConnections().get(k)) {
				c.setRelaxed(false);
			}	
		}
	}

	public static void addDate(Space space, String unformattedDate, String id) {
		/* The format of the unformatted date is YYYYMMDD due to convention of Onebusaway,
		 * we just reformat it into ISO_LOCAL_DATE format YYYY-MM-DD */
		String date = unformattedDate.substring(0,4) + "-" + unformattedDate.substring(4,6) + "-" + unformattedDate.substring(6,8) ;
		if (space.getCalendar().containsKey(date)) {
			space.getCalendar().get(date).add(id) ;
		} else {
			EList<String> list = new BasicEList<String>(Arrays.asList(id));
			space.getCalendar().put(date, list) ;
		}
	}

	
	/* */
	public static Itinerary createItinerary(Itinerary prevIt, Leg l, String tripId, long departureTime, long arrivalTime, int nbTransfers, double walkingDistance, long waitingTime, boolean isOnRightWay, String trips) {

		Itinerary it = RoutingFactory.eINSTANCE.createItinerary() ;

		it.setDepartureTime(departureTime);
		it.setArrivalTime(arrivalTime);
		it.setNbTransfers(nbTransfers);
		it.setLastTrip(tripId);
		it.setWalkingDistance(walkingDistance);
		it.setWaitingTime(waitingTime);
		it.setIsOnRightWay(isOnRightWay);
		it.setTrips(trips);

		/* Extend the previous itinerary */
		if (prevIt != null) it.getPath().addAll(prevIt.getPath()) ;		
		if (l != null) it.getPath().add(l) ;

		it.setDeprecated(false);

		return it;
	}

}
