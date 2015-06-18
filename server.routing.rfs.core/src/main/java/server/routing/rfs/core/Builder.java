package server.routing.rfs.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import routing.Connection;
import routing.RoutingFactory;
import routing.Space;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.onebusaway.gtfs.impl.GtfsDaoImpl;
import org.onebusaway.gtfs.model.Stop;
import org.onebusaway.gtfs.model.StopTime;
import org.onebusaway.gtfs.serialization.GtfsReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import server.routing.rfs.util.RoutingAccessors;
import server.routing.rfs.util.MyRoutingFactory;
import server.routing.rfs.util.Util;

public class Builder {
	
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	private static final boolean REBUILD = false; 
	private ArrayList<Connection> sorted_connections ; 
	Space space ;
		
	public Builder (String path) throws IOException {
		
		if (REBUILD) {
	    	 
			space = RoutingFactory.eINSTANCE.createSpace();
			
			/* TODO : est ce qu'on peut récupérer la Timezone du GTFS ? */
			space.setTimezone("Portland"); 
			
	    	// Read the GTFS
			GtfsReader reader = new GtfsReader();
			reader.setInputLocation(new File(path));
	
			GtfsDaoImpl store = new GtfsDaoImpl();
			reader.setEntityStore(store);
	
			reader.run();
	
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
			for (StopTime st : stop_times) {
				
				/* TODO : prendre en compte calendar.txt et calendar_dates.txt, etc */

				// Initialization
				if (prevST == null) prevST = st ;			
				// The same trip
				if (st.getTrip().getId().getId().equals(prevST.getTrip().getId().getId())) {
					// The next stop
					if (st.getStopSequence() == prevST.getStopSequence() + 1) {					
						// Create a new connection and add it to the map
						c = MyRoutingFactory.addConnection(space, st.getTrip().getId().getId(), st.getTrip().getRoute().getId().getId(), prevST.getStop().getId().getId(), 
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
			}
			
	        LOG.info("List of connections created successfully.");
	
			for (Stop s1 : store.getAllStops()) {
				for (Stop s2 : store.getAllStops()) {
					if (!s1.getId().getId().equals(s2.getId().getId()) && Util.isConnectionPossible (s1.getLat(), s1.getLon(), s2.getLat(), s2.getLon())) {
						MyRoutingFactory.addFootpath(space, s1.getId().getId(), s2.getId().getId(), s1.getLat(), s1.getLon(), s2.getLat(), s2.getLon());
					}
				}
				MyRoutingFactory.addStopPoint(space, s1.getId().getId(), s1.getName(), 0);
			}
	
			LOG.info("List of footpaths created successfully.");
	        LOG.info("List of stops created successfully.");
	
	        // Serialization
	        if (MyRoutingFactory.serialize(space)) {
		        LOG.info("Serialization proceeded successfully.");
	        }
		}
		else {
			// Deserialization 
			space = MyRoutingFactory.deserialize() ;
	        if (space != null) LOG.info("De-serialization proceeded successfully.");
		}
        
		// Création d'une liste des mêmes connections mais triée
		sorted_connections = new ArrayList<Connection>() ;
		for (String k : RoutingAccessors.getConnectionsKeySet(space)) {
			sorted_connections.addAll(RoutingAccessors.getConnections(space, k)) ;
		}
		Collections.sort(sorted_connections);

	} 

	/* Renvoie la liste des connections triée : plus simple pour le déroulement de l'algo */
	ArrayList<Connection> getSortedConnections() {
		return sorted_connections ;
	}

	/**
     * Return an HK2 Binder that injects this specific Builder instance into Jersey web resources.
     * This should be registered in the ResourceConfig (Jersey). Jersey forces us to use injection 
     * to get application context into HTTP method handlers.
     * More on custom injection in Jersey 2:
     * http://jersey.576304.n2.nabble.com/Custom-providers-in-Jersey-2-tp7580699p7580715.html
     */
     public AbstractBinder makeBinder() {
        return new AbstractBinder() {
            @Override
            protected void configure() {
                bind(Builder.this).to(Builder.class);
            }
        };
    }

 }
