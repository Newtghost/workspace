package server.routing.rfs.services;

public class ParseParameterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type ;
	
	public ParseParameterException (String type) {
		this.type = type ;
	}
	
	@Override
	public String toString() {
		return "ParseParameterException : error while parasing parameters of the get request, " + type;
	}

}
