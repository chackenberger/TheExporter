package at.hackenberger.exporter.error;

/**
 * ConnectionException
 *
 * @author Hackenberger Christoph
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ResultSetReadException extends Exception {

	/**
	 * Constructs a new {@link ResultSetReadException} with the specified detail message.
	 * @param message the detail message.
	 */
	public ResultSetReadException(String message) {
		super(message);
	}
}
