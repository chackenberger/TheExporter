package at.hackenberger.exporter.io;

import java.io.IOException;

public class ConsoleOutputWriter implements OutputWriter {

	@Override
	public void writeToOutput(String[][] output, String delimiter) throws IOException {
		String o = "";
		for(String[] row : output) {
			for(String t : row) {
				o += t + delimiter;
			}
			o += '\n';
		}
		System.out.println(o);
	}

}
