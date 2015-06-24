package server.routing.rfs.util;

import java.util.Arrays;
import java.util.Date;

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
	public static final double NB_ITINERARIES = 10; /* Max nb of pareto-opt itineraries per StopPoint */

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
		return c ;
	}
	
	public static Footpath createFootpath (String departureId, String arrivalId, double depLat, double depLon, double arrLat, double arrLon) {
		Footpath f = RoutingFactory.eINSTANCE.createFootpath() ;
		f.setDepartureId(departureId);
		f.setArrivalId(arrivalId);
		f.setRouteId("");
		f.setDistance(Util.gps2m(depLat, depLon, arrLat, arrLon)) ; /* Calcul de la distance */
		f.setDuration((int) (f.getDistance()/SPEED));
		return f ;
	}
	
	public static StopPoint createStopPoint (String stopId, String name, int minimumConnectionTime) {
		StopPoint s = RoutingFactory.eINSTANCE.createStopPoint() ;
		s.setStopId(stopId);
		s.setName(name);
		s.setMinimalConnectionTime(minimumConnectionTime);
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
	
	public static void addStopPoint (Space space, String stopId, String name, int minimumConnectionTime) {
		StopPoint s = createStopPoint(stopId, name, minimumConnectionTime);
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

	public static void addDate(Space space, Date date, String id) {
		if (space.getCalendar().containsKey(date)) {
			space.getCalendar().get(date).add(id) ;
		} else {
			EList<String> list = new BasicEList<String>(Arrays.asList(id));
			space.getCalendar().put(date, list) ;
		}
	}

	public static Itinerary createItinerary(Itinerary itdep, Leg l, long arrivalTime, int nbTransfers) {
		Itinerary it = RoutingFactory.eINSTANCE.createItinerary() ;

		/* Arrival time */
		it.setArrivalTime(arrivalTime);

		/* Nb of transfers */
		it.setNbTransfers(nbTransfers);
		
		/* Last trip ID - "" correspond to a footpath */
		if (l != null) {
			it.setLastTrip(l.getRouteId());
		} else {
			it.setLastTrip("");
		}

		/* Path - list of legs */
		if (itdep != null) {
			it.getPath().addAll(itdep.getPath()) ;
			it.getPath().add(l) ;
		}

		/* Walking distance */
		if (l == null) {
			it.setWalkingDistance(0.0);
		} else if (l instanceof Footpath) {
			it.setWalkingDistance(itdep.getWalkingDistance() + ((Footpath) l).getDistance());
		} else {
			it.setWalkingDistance(itdep.getWalkingDistance());
		}
		
		return it;
	}

}
