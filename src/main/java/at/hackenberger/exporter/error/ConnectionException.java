package at.hackenberger.exporter.error;

/**
 * ConnectionException
 *
 * @author Hackenberger Christoph
 * @version 1.0
 */
public class ConnectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7899143486948454498L;

	/**
	 * Constructs a new {@link ConnectionException} with the specified detail message.
	 * @param message the detail message.
	 */
	public ConnectionException(String message) {
		super(message);
	}
}
