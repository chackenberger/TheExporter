package at.hackenberger.exporter.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import at.hackenberger.exporter.jdbc.datasource.DataSourceFactory;

public class ConnectionFactory {

	/**
	 * 
	 * @param dbms
	 * @param hostname
	 * @param username
	 * @param password
	 * @param dbname
	 * @return
	 * @throws SQLException when there is an error accessing the database
	 */
	public static Connection getConnection(String dbms, String hostname, String username, String password, String dbname) throws SQLException {
		return DataSourceFactory.getDataSource(dbms, hostname, dbname, username, password).getConnection();
	}

}
