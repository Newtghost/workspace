package server.routing.rfs.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import routing.Connection;
import routing.Leg;
import routing.RoutingFactory;
import routing.Space;

import org.onebusaway.gtfs.impl.GtfsDaoImpl;
import org.onebusaway.gtfs.model.Agency;
import org.onebusaway.gtfs.model.ServiceCalendarDate;
import org.onebusaway.gtfs.model.Stop;
import org.onebusaway.gtfs.model.StopTime;
import org.onebusaway.gtfs.serialization.GtfsReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import server.routing.rfs.util.MyRoutingFactory;

public class Builder {
	
    private static final Logger LOG = LoggerFactory.getLogger(Builder.class);
	   
	private static final boolean REBUILD = false;          
	private Router router ;   
	private Updater updater = null ; 
	private Space space ; 
		 
	public Builder (String gtfsPath, String objPath) throws IOException {  
		  
		if (REBUILD) { 
	    	 
			space = RoutingFactory.eINSTANCE.createSpace(); 
			
	    	// Read the GTFS
			GtfsReader reader = new GtfsReader();
			reader.setInputLocation(new File(gtfsPath));
	
			GtfsDaoImpl store = new GtfsDaoImpl();
			reader.setEntityStore(store);
	
			reader.run();

			/* Treat only the case of a single agency */
			for (Agency agency : store.getAllAgencies()) {
				space.setAgencyName(agency.getName());
				space.setTimezone(agency.getTimezone());
				break ;
			}
			
			// Get and sort the list of stop times to make easier the creation of all connections
			ArrayList<StopTime> stop_times = new ArrayList<StopTime> (store.getAllStopTimes()) ;
			Collections.sort(stop_times, new Comparator<StopTime>( ){
				public int compare(StopTime o1, StopTime o2) {
					if (o1.getTrip().getId().getId().equals(o2.getTrip().getId().getId())) {
						return o1.getStopSequence() - o2.getStopSequence() ;
					}
					else {
						return o1.getTrip().getId().getId().compareTo(o2.getTrip().getId().getId()) ;
					}
				}			
			} );
				
			// Access entities through the store to create connections
			StopTime prevST = null ;
			Connection prevC = null, c = null ;  
			Map<Stop, Set<String>> arrivalRoutesToStop = new HashMap<>() ;
			for (StopTime st : stop_times) {
				
				// Initialization
				if (prevST == null) prevST = st ;			
				// The same trip
				if (st.getTrip().getId().getId().equals(prevST.getTrip().getId().getId())) {
					// The next stop
					if (st.getStopSequence() == prevST.getStopSequence() + 1) {					
						// Create a new connection and add it to the map
						c = MyRoutingFactory.addConnection(space, st.getTrip().getServiceId().getId(), st.getTrip().getId().getId(), st.getTrip().getRoute().getId().getId(), prevST.getStop().getId().getId(), 
								st.getStop().getId().getId(), prevST.getDepartureTime(), st.getArrivalTime(), prevST.getStopSequence(), st.getStopSequence()) ;
						c.setPrevC(prevC);
						prevC = c ;						
					}
					else {
						prevC = null ;
					}
				} 
				else {
					prevC = null ;
				}
	
				prevST = st ; 
				
				if (! arrivalRoutesToStop.containsKey(st.getStop())) arrivalRoutesToStop.put(st.getStop(), new HashSet<String>()) ;
				arrivalRoutesToStop.get(st.getStop()).add(st.getTrip().getRoute().getId().getId());
			}
			
	        LOG.info("List of connections created successfully.");
			
			// Create an hashmap indexed with the date that resume all the information contained in calendar.txt and calendar_dates.txt
			for (ServiceCalendarDate cd : store.getAllCalendarDates()) {
				MyRoutingFactory.addDate(space, cd.getDate().getAsString(), cd.getServiceId().getId()) ;
			}
			
	        LOG.info("List of dates created successfully.");
	
			for (Stop s1 : store.getAllStops()) {
				for (Stop s2 : store.getAllStops()) { 
					if (!s1.getId().getId().equals(s2.getId().getId()) && Leg.isConnectionPossible(s1.getLat(), s1.getLon(), s2.getLat(), s2.getLon())) { 
						MyRoutingFactory.addFootpath(space, s1.getId().getId(), s2.getId().getId(), s1.getLat(), s1.getLon(), s2.getLat(), s2.getLon());
					}
				}
				MyRoutingFactory.addStopPoint(space, s1.getId().getId(), s1.getName(), 0, s1.getLat(), s1.getLon(), arrivalRoutesToStop.get(s1));
			}
	
			LOG.info("List of footpaths created successfully.");
	        LOG.info("List of stops created successfully.");
	
	        // Serialization
	        if (MyRoutingFactory.serialize(space, objPath)) {
		        LOG.info("Serialization proceeded successfully.");
	        }
		}
		else {
			// Deserialization 
			space = MyRoutingFactory.deserialize(objPath) ;
	        if (space != null) LOG.info("De-serialization proceeded successfully.");
		}
	} 

 	public Updater getUpdater() {
		return updater;
	}

	public void createUpdater() {
		updater = new Updater();
	}

	public void createRouter() {
		router = new Router(space, updater) ;
	}

	public Router getRouter() {
		return router;
	}

 }
