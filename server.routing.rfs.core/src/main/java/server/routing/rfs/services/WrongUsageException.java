package server.routing.rfs.services;

public class WrongUsageException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Usage: gtfs_feed_path serialization_path";
	}

}
