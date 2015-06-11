package gtfsrt.provider.util;

public class Trip {
	
	private String trip_id ;
	private int nb_sequences ;
	private int delay ;

	public Trip (String trip_id, int nb_sequences, int delay) {
		this.trip_id = trip_id ;
		this.nb_sequences = nb_sequences ;
		this.delay = delay ;
	}

	public String getTrip_id() {
		return trip_id;
	}

	public int getNb_sequences() {
		return nb_sequences;
	}

	public int getDelay() {
		return delay;
	}

	@Override
	public String toString() {
		return "Trip (" + trip_id + ") : " + nb_sequences
				+ " sequences with a delay of " + delay + " seconds.";
	}

}
