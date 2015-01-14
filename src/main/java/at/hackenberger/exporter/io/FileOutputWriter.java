package at.hackenberger.exporter.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Writes a 2d array to a {@link File}
 * 
 * @author Hackenberger Christoph
 * @version 1.0
 */
public class FileOutputWriter implements OutputWriter {

	private File file;
	
	/**
	 * Creates a new Object of a {@link FileOutputWriter}
	 * @param file the {@link File} where to write
	 */
	public FileOutputWriter(File file) {
		if(file == null)
			throw new NullPointerException("file must not be null");
		this.file = file;
	}

	@Override
	public void writeToOutput(String[][] output, String delimiter) throws IOException{
		String o = "";
		for(String[] row : output) {
			for(String t : row) {
				o += t + delimiter;
			}
			o += '\n';
		}
		try(FileWriter fw = new FileWriter(file)) {
			fw.write(o);
		}
	}

}
