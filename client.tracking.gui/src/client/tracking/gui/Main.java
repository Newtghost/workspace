package client.tracking.gui;

import org.eclipse.swt.widgets.Display;

import client.tracking.core.Tracker;
import client.tracking.core.Updater;
import client.tracking.core.Util;

public class Main {
	
	/* TODO : comment récupérer la timezone dans l'IHM de tracking ? Via la requête ? */
	public static int JET_LAG = 9*3600 ;
	
	private static int _refreshInterval = 1;

	private static Process pOTP ;
    private static Process pRFS ;
    private static Tracker tracker;
    
    @SuppressWarnings("unused")
	public Main () {
    	
		/* Launch OTP */
    	if (!Util.OTP_IS_RUNNING && Util.COMPUTE_WITH_OTP) pOTP = Util.launchOTP();
        
        /* Launch my solution - routing from scratch */
    	if (!Util.RFS_IS_RUNNING && Util.COMPUTE_WITH_RFS) pRFS = Util.launchRFS();

		/* Initialization of the tracker */
		tracker = new Tracker () ;

    }

    public static void startRefresh () {
		/* Thread to refresh the display */
		new Thread(new Runnable() {
		      public void run() {
		         while (true) {
		            Display.getDefault().asyncExec(new RefreshTask());
		            try { Thread.sleep(_refreshInterval * 1000); } catch (Exception e) { }
		         }
		      }
		   }).start();	
	}
	
	private static void update () {
		if (Util.COMPUTE_WITH_RFS) RFSView.instance.update(tracker.getRFS_itineraries());
		if (Util.COMPUTE_WITH_OTP) OTPView.instance.update(tracker.getOTP_itineraries());
	}

	@SuppressWarnings("unused")
	public static void stop () throws InterruptedException {
    	if (!Util.OTP_IS_RUNNING && Util.COMPUTE_WITH_OTP) Util.stopProcess(pOTP);
    	if (!Util.RFS_IS_RUNNING && Util.COMPUTE_WITH_RFS) Util.stopProcess(pRFS);
	}

    private static class RefreshTask implements Runnable {
		@Override
		public void run() {
			try {
				if (Updater.need2refresh) {
					Updater.need2refresh = false ;
					update();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static Tracker getTracker() {
		return tracker;
	}
}