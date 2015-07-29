package server.routing.rfs.services;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static final boolean DEBUG = false ;     
	public static Builder builder = null;
	
	public static void main(final String[] args) throws Exception {

		if (args.length != 2) {
			throw new WrongUsageException();
		}	

		LOG.info("Correct usage, start deploying the server.");
		
    	try { 
			builder = new Builder (args[0], args[1]);
		} catch (IOException e) {
			e.printStackTrace();
		}

    	if (DEBUG) {
    		builder.createRouter();
	        long currentTime = System.currentTimeMillis();
	    	Request request = MyRoutingFactory.createRequest("3932", "2391", "1:30pm", "07-01-2015", "", "", "", "", "", "") ;
			try {
				builder.getRouter().processNewRequest(request);
			} catch (DateException e) {
				e.printStackTrace();
			}
			LOG.info("Temps d'éxécution : " + (System.currentTimeMillis()-currentTime) + "ms.");
    	} else {
    		builder.createUpdater();
    		builder.createRouter();
    		builder.getUpdater().start();
        	SpringApplication.run(App.class, args);
    	}

	}
}