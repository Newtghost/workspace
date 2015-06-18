package server.routing.rfs.util;

import java.util.Arrays;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

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

	public static Connection createConnection (String tripId, String routeId, String departureId, String arrivalId, 
			long departureTime, long arrivalTime, int departureSeq, int arrivalSeq) {
		Connection c = RoutingFactory.eINSTANCE.createConnection() ;
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
	
	public static Connection addConnection (Space space, String tripId, String routeId, String departureId, String arrivalId, 
			long departureTime, long arrivalTime, int departureSeq, int arrivalSeq) {
		Connection c = createConnection(tripId, routeId, departureId, arrivalId, departureTime, arrivalTime, departureSeq, arrivalSeq) ;
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
			p.setBestArrivalTime(Long.MAX_VALUE);
			p.setBestArrivalLeg(null);
		}	
		
		for (String k : space.getConnections().keySet()) {
			for (Connection c : space.getConnections().get(k)) {
				c.setRelaxed(false);
			}	
		}
	}

}
