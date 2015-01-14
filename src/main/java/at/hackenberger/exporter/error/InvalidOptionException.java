package at.hackenberger.exporter.error;

/**
 * InvalidOptionException
 *
 * @author Hackenberger Christoph
 * @version 1.0
 */
public class InvalidOptionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7440541755987949355L;

	/**
	 * Constructs a new {@link InvalidOptionException} with the specified detail message.
	 * @param message the detail message.
	 */
	public InvalidOptionException(String message) {
		super(message);
	}

}
