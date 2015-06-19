package server.routing.rfs.util;

import java.util.Collection;
import java.util.Date;
import java.util.List;
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
	
	public static StopPoint getStop (Space space, String stopId) {
		return space.getStops().get(stopId) ;
	}

	public static Collection<StopPoint> getStops(Space space) {
		return space.getStops().values();
	}

	public static List<Leg> getPath (Itinerary it) {
		return it.getPath() ;
	}

	public static long getStartTime (Request r) {
		return DateUtils.parseTimeD (r.getTime()) ;
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

	public static List<String> getServicesIdForDate(Space space, Date d) {
		return space.getCalendar().get(d) ;
	}
	
}
