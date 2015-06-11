package server.routing.rfs.core;

import java.io.IOException;
import java.net.URI;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class App {
	
    public static final boolean DEBUG = false ;
    
    // Builder
	Builder builder = null;

	// Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8079/myapp/";

	public App (String path) {
    	try {
			builder = new Builder (path);
		} catch (IOException e) {
			e.printStackTrace();
		}

    	/* Debug */
//    	Request request = RoutingFactory.createRequest("3932", "2391", 0) ;
//		Router router = new Router(builder, request) ;       
//		router.run_CSA();
//		router.printJourney();
	}
	
    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public void startServer() {
		// create a resource config that scans for JAX-RS resources and providers
        // in com.example.simple_service package
        final ResourceConfig rc = new ResourceConfig().packages("server.routing.rfs.core");
        rc.register(builder.makeBinder()) ;

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {
    	if (args.length != 1) {
			System.err.println("usage: gtfs_feed_path");
			System.exit(-1);
		}	
    	App myapp = new App (args[0]) ;
    	myapp.startServer();
    }

    
}
