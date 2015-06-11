/**
 * Copyright (C) 2012 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gtfsrt.provider.util;

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.onebusaway.guice.jsr250.LifecycleService;
import org.onebusway.gtfs_realtime.exporter.TripUpdatesServlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class GtfsrtTripUpdatesProducerMain {

	public static void main(String[] args) throws Exception {
		GtfsrtTripUpdatesProducerMain m = new GtfsrtTripUpdatesProducerMain();
		m.run(args);
	}

	private GtfsrtProviderImpl _provider;

	private LifecycleService _lifecycleService;

	@Inject
	public void setProvider(GtfsrtProviderImpl provider) {
		_provider = provider;
	}

	@Inject
	public void setLifecycleService(LifecycleService lifecycleService) {
		_lifecycleService = lifecycleService;
	}

	public void run(String[] args) throws Exception {

		System.out.println("Running a new instance of GTFS-RT provider.");
		
		Set<Module> modules = new HashSet<Module>();
		GtfsrtTripUpdatesProduceModule.addModuleAndDependencies(modules);

		Injector injector = Guice.createInjector(modules);
		injector.injectMembers(this);

		/* Set the map of all trips we want to update to add some delay */
		Map<String, Trip> trips = new HashMap<String, Trip> () ;
		for (int i = 0 ; i < args.length ; i += 3) {
			trips.put(args[i], new Trip(args[i], Integer.parseInt(args[i+1]), Integer.parseInt(args[i+2]))) ;
		}
		_provider.setTrips(trips); ;

		URL url = new URL("http://localhost:8077/trip-updates");
		TripUpdatesServlet servlet = injector.getInstance(TripUpdatesServlet.class);
		servlet.setUrl(url);		

		_lifecycleService.start();
	}

}
