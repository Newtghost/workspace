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
	
	public static final double SPEED = 1.2; /* meter per second */

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
		f.setDistance(Util.gps2m(depLat, depLon, arrLat, arrLon)) ; /* Calcul de la distance */
		f.setDuration((int) (f.getDistance()/SPEED));
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

	public static Request createRequest (String departureId, String arrivalId, String time, String date) {
		Request r = CommonFactory.eINSTANCE.createRequest() ;
		r.setFromStopId(departureId);
		r.setToStopId(arrivalId);		
		r.setTime(time);
		r.setDate(date);
		return r ;
	}

	public static Request createRequest (String fromLat, String fromLon, String toLat, String toLon, String time, String date) {
		Request r = CommonFactory.eINSTANCE.createRequest() ;
		r.setFromLat(Double.parseDouble(fromLat));
		r.setFromLon(Double.parseDouble(fromLon));		
		r.setToLat(Double.parseDouble(toLat));
		r.setToLon(Double.parseDouble(toLon));		
		r.setTime(time);
		r.setDate(date);
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

	public static boolean serialize(Space space) {
		return EmfUtil.doSaveBin(space, Util.PATH + "rfsMaps",".obj") ; 
	}

	public static Space deserialize() {
		return (Space) EmfUtil.doOpenBin(RoutingPackage.eINSTANCE, Util.PATH + "rfsMaps",".obj");
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

	public static void addDate(Space space, String date, String id) {
		/* TODO : formatter la date ici pour avoir un format ISO */
//		LocalDate myDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE_TIME) ;
//		String formatedDate = myDate.format(DateTimeFormatter.ISO_LOCAL_DATE).toString() ;
		String formatedDate = date ;
		if (space.getCalendar().containsKey(formatedDate)) {
			space.getCalendar().get(formatedDate).add(id) ;
		} else {
			EList<String> list = new BasicEList<String>(Arrays.asList(id));
			space.getCalendar().put(formatedDate, list) ;
		}
	}

	public static Itinerary createItinerary(Itinerary prevIt, Leg l, String tripId, long departureTime, long arrivalTime, int nbTransfers, double walkingDistance, boolean isOnRightWay) {
		Itinerary it = RoutingFactory.eINSTANCE.createItinerary() ;

		/* Departure time */
		it.setDepartureTime(departureTime);

		/* Arrival time */
		it.setArrivalTime(arrivalTime);

		/* Nb of transfers */
		it.setNbTransfers(nbTransfers);
		
		/* Last trip ID : "" correspond to a footpath */
		it.setLastTrip(tripId);

		/* Extend the previous itinerary */
		if (prevIt != null) it.getPath().addAll(prevIt.getPath()) ;		
		if (l != null) it.getPath().add(l) ;

		/* Walking distance */
		it.setWalkingDistance(walkingDistance);
		
		/* Right way */
		it.setIsOnRightWay(isOnRightWay);
		
		/* Deprecated */
		it.setDeprecated(false);
		
		return it;
	}

}
