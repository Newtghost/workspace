package server.routing.rfs.core;

import java.io.IOException;
import java.net.URI;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import server.routing.rfs.util.MyRoutingFactory;
import common.Request;

public class App {
	
    public static final boolean DEBUG = false ; 
    
	Builder builder = null;

	// Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8079/myapp/";

	public App (String path) {
				
    	try { 
			builder = new Builder (path);
		} catch (IOException e) {
			e.printStackTrace();
		}

    	if (DEBUG) {
    		builder.createRouter();
	        long currentTime = System.currentTimeMillis();
	    	Request request = MyRoutingFactory.createRequest("3932", "2391", "1:30pm", "07-01-2015") ;
			try {
				builder.getRouter().processNewRequest(request);
			} catch (DateException e) {
				e.printStackTrace();
			}
			builder.getRouter().run_CSA();
	        System.out.println("Temps d'éxécution : " + (System.currentTimeMillis()-currentTime) + "ms.");
    	} else {
    		builder.createUpdater();
    		builder.createRouter();
    		builder.getUpdater().start();
    		startServer() ;
    	}
    	
	}
	
    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    private void startServer() {
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
    	
    	new App (args[0]) ;
    }
    
}
