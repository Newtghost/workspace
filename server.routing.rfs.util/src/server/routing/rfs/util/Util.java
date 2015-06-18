package server.routing.rfs.util;

public class Util {

	/* TODO : ne doit pas �tre en dur */
	public static final String PATH = "C:\\Users\\david.leydier\\workspace\\server.routing.rfs.core\\target\\"; 

	private static final double CONNECTION_THRESHOLD = 500;

	public static double gps2m (double lat_a, double lng_a, double lat_b, double lng_b) {
	    double pk = 180 / Math.PI;

	    double a1 = lat_a / pk;
	    double a2 = lng_a / pk;
	    double b1 = lat_b / pk;
	    double b2 = lng_b / pk;

	    double t1 = Math.cos(a1)*Math.cos(a2)*Math.cos(b1)*Math.cos(b2);
	    double t2 = Math.cos(a1)*Math.sin(a2)*Math.cos(b1)*Math.sin(b2);
	    double t3 = Math.sin(a1)*Math.sin(b1);
	    double tt = Math.acos(t1 + t2 + t3);
	   
	    return 6366000 * tt;
	}
	
	public static boolean isConnectionPossible (double lat_a, double lon_a, double lat_b, double lon_b) {
		return gps2m(lat_a, lon_a, lat_b, lon_b) < CONNECTION_THRESHOLD ;
	}

}
