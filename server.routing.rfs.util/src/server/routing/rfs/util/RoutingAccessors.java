package server.routing.rfs.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.ECollections;

import routing.Connection;
import routing.Footpath;
import routing.Itinerary;
import routing.Leg;
import routing.Space;
import routing.StopPoint;
import common.Request;

public class RoutingAccessors {

	public static List<Connection> getConnections (Space space, String stopId) {
		return space.getConnections().get(stopId) ;
	}

	public static Set<String> getConnectionsKeySet (Space space) {
		return space.getConnections().keySet() ;
	}

	public static List<Footpath> getFootpaths (Space space, String stopId) {
		return space.getFootpaths().get(stopId) ;
	}
	
	public static StopPoint getStopFromId (Space space, String stopId) {
		return space.getStops().get(stopId) ;
	}

	/* This function returns the nearest stop of the position passed in parameters. */
	public static StopPoint getStopFromCoordinates (Space space, double lat, double lon) {
		StopPoint nearestStop = null ;
		double shortestDistance = Double.MAX_VALUE; 
		for (StopPoint stop : RoutingAccessors.getStops(space)) {
			double aux = Leg.gps2m(lat, lon, stop.getLatitude(), stop.getLongitude()) ;
			if (aux < shortestDistance) {
				shortestDistance = aux ;
				nearestStop = stop ;
			}
		}
		System.out.println("The distance to the position is " + shortestDistance + "m") ;
		/* TODO : il faut envisager de rajouter un footpath avant le départ ou après l'arrivée donc renvoyer le couple avec la distance */
		return nearestStop ;
	}

	public static Collection<StopPoint> getStops(Space space) {
		return space.getStops().values();
	}

	public static List<Leg> getPath (Itinerary it) {
		return it.getPath() ;
	}

	/* Return the local start time in seconds */
	public static long getStartTime (Request request) {
		return LocalTime.parse(request.getTime(), DateTimeFormatter.ISO_TIME).toSecondOfDay() ;
	}

	public static Set<String> getAllValidDates(Space space) {
		return space.getCalendar().keySet() ;
	}

	public static List<String> getServicesIdForDate(Space space, String date) {
		return space.getCalendar().get(date) ;
	}

	public static List<Itinerary> getJourneys(StopPoint dep) {
		return dep.getBestJourneys();
	}

	public static void sortJourneys(StopPoint arr) {
		ECollections.sort(arr.getBestJourneys()); 
	}

	public static List<String> getRoutesId(StopPoint targetStop) {
		return targetStop.getRoutesId();
	}

	public static List<String> getBannedRoutes(Request request) {
		return request.getBannedRoutes();
	}
	
}
