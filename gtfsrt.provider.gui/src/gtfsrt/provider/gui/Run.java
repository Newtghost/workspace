package gtfsrt.provider.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;

public class Run implements IHandler {

	public static Run instance = null ; /* Singleton */
	public static boolean isRunning = false ;
	private static final String PROVIDER_PATH = "C:\\Users\\david.leydier\\workspace\\gtfsrt.provider.util\\target\\";
	private Process provider = null ;
	
	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		instance = this ;
		
		if (isRunning) stopProccess();
		
		/* Create a new one */
		String[] cmd = new String[View.instance.getTrips_to_update().size()*3 + 3] ;
		cmd[0] = "java" ;
		cmd[1] = "-jar" ;
		cmd[2] = PROVIDER_PATH + "gtfsrt_provider.jar" ;
		int i = 3 ;
		for (Trip t : View.instance.getTrips_to_update()) {
			cmd[i] = t.getTrip_id() ;
			cmd[i+1] = Integer.toString(t.getNb_sequences()) ;
			cmd[i+2] = Integer.toString(t.getDelay()) ;
			i += 3 ;
		}
        
        try {
			provider = Runtime.getRuntime().exec(cmd);
			isRunning = true ;
		} catch (IOException e) {
			e.printStackTrace();
		}

        /* Récupération des flux pour éviter les inter-blocages */
        AfficheurFlux fluxSortie = new AfficheurFlux(provider.getInputStream());
        AfficheurFlux fluxErreur = new AfficheurFlux(provider.getErrorStream());
        new Thread(fluxSortie).start();
        new Thread(fluxErreur).start();

        return null;
	}

	public void stopProccess() {
		if (isRunning) {
			/* Detroy the existing provider */
			provider.destroy();
			try {
				provider.waitFor() ;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			isRunning = false ;
		}
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {

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