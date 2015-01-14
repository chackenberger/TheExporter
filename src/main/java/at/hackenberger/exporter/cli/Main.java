package at.hackenberger.exporter.cli;

/**
 * Main class for the Balancer
 * 
 * @author Hackenberger Christoph
 * @version 1.0
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import at.hackenberger.exporter.error.InvalidOptionException;
import at.hackenberger.exporter.io.ConsoleOutputWriter;
import at.hackenberger.exporter.io.FileOutputWriter;
import at.hackenberger.exporter.io.OutputWriter;
import at.hackenberger.exporter.jdbc.ConnectionFactory;
import at.hackenberger.exporter.utils.ResultSetDecoder;
import at.hackenberger.exporter.utils.SQLBuilder;

public class Main {

	public static void main(String[] args) {
		CLIParser p = new CLIParser();
		try {
			p.parse(args, "java -jar TheExporter.jar [options]");
		} catch (InvalidOptionException ex) {
			System.out.println(ex.getMessage());
			System.exit(1);
		}
		
		try {
			Connection con = ConnectionFactory.getConnection(p.getDBMS(), p.getHostname(), p.getUsername(), p.getPassword(), p.getDBName());
			Statement stmt = con.createStatement();
			
			SQLBuilder sb = new SQLBuilder(p.getFields(), p.getTable(), p.getWhere(), p.getSortDir(), p.getSortField());
			ResultSet rs = stmt.executeQuery(sb.generateSQL());
			ResultSetDecoder rsd = new ResultSetDecoder(rs);
			String[][] out = rsd.decode();
			OutputWriter op;
			if(p.getFile() != null)
				op = new FileOutputWriter(p.getFile());
			else
				op = new ConsoleOutputWriter();
			op.writeToOutput(out, p.getDelimiter());
		}catch (IOException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

}
