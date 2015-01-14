package at.hackenberger.exporter.io;

import java.io.IOException;

/**
 * Writes an 2d array to an output
 * @author Hackenberger Christoph
 * @version 1.0
 */
public interface OutputWriter {

	/**
	 * Writes an 2d array with the specified delimiter to an output
	 * @param output the 2d array to write
	 * @param delimiter the delimiter
	 * @throws IOException when something goes wrong while writing
	 */
	public void writeToOutput(String[][] output, String delimiter) throws IOException;

}
