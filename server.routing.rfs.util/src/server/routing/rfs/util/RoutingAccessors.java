package server.routing.rfs.util;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.eclipse.emf.common.util.ECollections;

import routing.Connection;
import routing.Footpath;
import routing.Itinerary;
import routing.Leg;
import routing.Space;
import routing.StopPoint;
import common.Request;
import common.util.DateUtils;

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
			double aux = Util.gps2m(lat, lon, stop.getLatitude(), stop.getLongitude()) ;
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

	public static long getStartTime (Request r) {
		return DateUtils.parseTime (r.getTime()) ;
	}

	public static Date getDate(Request request) {
		return DateUtils.parseDate(request.getDate(), TimeZone.getDefault()); 
	}

	public static long getJetlag (Space space) {
		/* Depend de la Timezone - récupéré depuis le GTFS stocké dans le Space */
		if (space.getTimezone().equals("Portland")) {
			return 9 * 3600 ;
		}
		return 0 ;
	}

	public static Set<Date> getCalendarDates(Space space) {
		return space.getCalendar().keySet() ;
	}

	public static Set<Date> getAllValidDates(Space space) {
		return space.getCalendar().keySet() ;
	}

	public static List<String> getServicesIdForDate(Space space, Date d) {
		return space.getCalendar().get(d) ;
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
	
}
