package at.hackenberger.exporter.cli;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import at.hackenberger.exporter.error.InvalidOptionException;

public class CLIParser {

	@Option(name="-h",usage="the hostname where the database is located. Default: localhost")
	private String hostname="localhost";

	@Option(name="-u",usage="the username of the database. Default: system username")
	private String username=System.getProperty("user.name");

	@Option(name="-p",usage="the password of the database. Default: none")
	private String password="";

	@Option(name="-d",usage="database name",required=true)
	private String dbname;

	@Option(name="-s",usage="the field by which the table should be sorted")
	private String sortField;

	@Option(name="-r",usage="the sort direction of which the table should be sorted ASC or DESC. only available when -s is set"
			,depends={"-s"})
	private String sortDir="ASC";

	@Option(name="-w",usage="where claus of the sql statement example: \"preis > 4\"")
	private String where;

	@Option(name="-f",usage="comma seperated list of fields which should be shown of the table or * for all fields",
			required=true)
	private String fields;

	@Option(name="-o",usage="path to the output file or when not set output to console")
	private File file;

	@Option(name="-T",usage="name of the table",required=true)
	private String table;

	private String dbms="mysql";
	
	@Option(name="-t",usage="delimiter for the output. Default: ;")
	private String delimiter=";";

	public void parse(String[] args, String usage) throws InvalidOptionException {
		CmdLineParser parser = new CmdLineParser(this);

		try {
			parser.parseArgument(args);
			if(this.sortField != null && this.sortDir.equalsIgnoreCase("ASC") && this.sortDir.equalsIgnoreCase("DESC"))
				throw new CmdLineException(parser, new Throwable("sort direction must be ASC or DESC"));
		} catch (CmdLineException ex) {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			parser.printUsage(out);
			throw new InvalidOptionException(ex.getMessage() + '\n' + usage + '\n' + out.toString());
		}
	}

	public String getHostname() {
		return this.hostname;
	}

	public String getUsername() {
		return this.password;
	}

	public String getPassword() {
		return this.password;
	}

	public String getDBName() {
		return this.dbname;
	}

	public String getSortField() {
		return this.sortField;
	}

	public String getSortDir() {
		return this.sortDir;
	}

	public String getWhere() {
		return this.where;
	}

	public String getFields() {
		return this.fields;
	}

	public File getFile() {
		return this.file;
	}

	public String getTable() {
		return this.table;
	}

	public String getDBMS() {
		return this.dbms;
	}
	
	public String getDelimiter() {
		return this.delimiter;
	}

}
