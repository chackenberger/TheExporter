package at.hackenberger.exporter.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import at.hackenberger.exporter.error.ConnectionException;
import at.hackenberger.exporter.jdbc.datasource.DataSourceFactory;

/**
 * ConnectionFactory
 * 
 * @author Hackenberger Christoph
 * @version 1.0
 */
public class ConnectionFactory {

	/**
	 * Returns a {@link Connection} to a database
	 * @param dbms the DBMS of the database ex. mysql
	 * @param hostname the hostname of the database
	 * @param username the username of the database
	 * @param password the password of the database
	 * @param dbname the database name
	 * @return {@link Connection} to the database
	 * @throws ConnectionException when the connection to the database cannot be established
	 */
	public static Connection getConnection(String dbms, String hostname, String username, String password, String dbname) throws ConnectionException {
		try {
			return DataSourceFactory.getDataSource(dbms, hostname, dbname, username, password).getConnection();
		}catch (SQLException ex) {
			throw new ConnectionException("Could not access database. Please ensure that the database is reachable and you provided the right credentials!"+'\n'+
					"("+ex.getMessage()+")");
		}
	}

}
