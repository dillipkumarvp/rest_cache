package nl.fdmediagroup.companyinfo.exception;

/**
 * Custom exception to wrap other exception.
 * 
 * @author dillipkumar.vp
 *
 */

public class CarInfoException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 */
	public CarInfoException() {
		super();
	}

	/**
	 * Method to add error message to the error appender
	 * 
	 * @param message
	 */
	public CarInfoException(String message) {
		super(message);
	}

	/**
	 * Method to Add throwable/exception object to the error appender
	 * 
	 * @param cause
	 */

	public CarInfoException(Throwable cause) {
		super(cause);
	}

	/**
	 * Method to add Custom message and throwable object to error appender.
	 * 
	 * @param message
	 * @param throwable
	 */
	public CarInfoException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
