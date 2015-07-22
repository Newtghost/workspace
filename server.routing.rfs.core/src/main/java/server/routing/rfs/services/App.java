package server.routing.rfs.services;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import common.Request;
import server.routing.rfs.core.Builder;
import server.routing.rfs.core.DateException;
import server.routing.rfs.util.MyRoutingFactory;

@EnableAutoConfiguration
@SpringBootApplication 
@ComponentScan("server.routing.rfs.services")
@PropertySource(value = {"classpath:server.properties" })
public class App {

	public static final boolean DEBUG = false ;     
	public static Builder builder = null;
	
	public static void main(final String[] args) throws Exception {

		if (args.length != 1) {
			System.err.println("usage: gtfs_feed_path");
			System.exit(-1);
		}	
    	
		/* TODO : harmoniser les traces .... debug ..... connections etc */
		
    	try { 
			builder = new Builder (args[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}

    	if (DEBUG) {
    		builder.createRouter();
	        long currentTime = System.currentTimeMillis();
	    	Request request = MyRoutingFactory.createRequest("3932", "2391", "1:30pm", "07-01-2015", "") ;
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
        	SpringApplication.run(App.class, args);
    	}

	}
}