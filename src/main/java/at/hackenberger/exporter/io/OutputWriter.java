package at.hackenberger.exporter.io;

import java.io.IOException;

public interface OutputWriter {

	public void writeToOutput(String[][] output, String delimiter) throws IOException;

}
