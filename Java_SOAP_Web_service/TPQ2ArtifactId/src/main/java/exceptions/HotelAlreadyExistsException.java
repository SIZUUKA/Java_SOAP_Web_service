package exceptions;

public class HotelAlreadyExistsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HotelAlreadyExistsException() {
		
	}
	
	public HotelAlreadyExistsException(String message) {
		super(message);
	}
}
