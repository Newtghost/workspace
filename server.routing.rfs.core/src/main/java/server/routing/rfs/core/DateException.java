package server.routing.rfs.core;

public class DateException extends Exception {

	/**
	 * Default serial version ID
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "DateException : the date doesn't exist in the GTFS bundle.";
	}

}
