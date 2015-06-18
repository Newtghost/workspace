package client.tracking.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Util {
	
	public static final boolean COMPUTE_WITH_OTP = true ;
	public static final boolean OTP_IS_RUNNING = true ;
	public static final boolean COMPUTE_WITH_RFS = false ;
	public static final boolean RFS_IS_RUNNING = false ;
	
	public static final boolean UPDATED = true ;

	public static final String CHEMIN_OTP = "C:\\Users\\david.leydier\\workspace\\otp\\target\\";
	public static final String CHEMIN_RFS = "C:\\Users\\david.leydier\\workspace\\routing\\target\\";
    
	public static Process launchOTP () {
        String[] cmd = {"java", "-jar", Util.CHEMIN_OTP + "otp-0.16.0-SNAPSHOT.jar", "--server", "--router", "r0"} ;
        return launchProcess(cmd) ;
	}
	
    public static Process launchRFS () {
        String[] cmd = {"java", "-jar", Util.CHEMIN_RFS + "rfs.jar", "C:\\Users\\david.leydier\\otp\\graphs\\gtfs"} ;
        return launchProcess(cmd) ;
	}

    private static Process launchProcess(String[] cmd) {
    	
    	Process p = null ;

    	/* Création du processus */
        try {
			p = Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}

        /* Récupération des flux pour éviter les inter-blocages */
        AfficheurFlux fluxSortie = new AfficheurFlux(p.getInputStream());
        AfficheurFlux fluxErreur = new AfficheurFlux(p.getErrorStream());
        new Thread(fluxSortie).start();
        new Thread(fluxErreur).start();
        
        return p ;
	}
	
	public static void stopProcess(Process p) throws InterruptedException {
		p.destroy() ;
		p.waitFor() ; 
	}

}

class AfficheurFlux implements Runnable {

    private final InputStream inputStream;

    AfficheurFlux(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    private BufferedReader getBufferedReader(InputStream is) {
        return new BufferedReader(new InputStreamReader(is));
    }

    public void run() {
        BufferedReader br = getBufferedReader(inputStream);
        String ligne = "";
        try {
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}