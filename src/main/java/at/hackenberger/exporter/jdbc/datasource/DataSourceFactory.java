package at.hackenberger.exporter.jdbc.datasource;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSourceFactory {

	public static DataSource getDataSource(String dbms, String hostname, String dbname, String username, String password) {
		BasicDataSource ds = new BasicDataSource();
		
		if(dbms.equalsIgnoreCase("mysql")) {
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			ds.setUrl("jdbc:mysql://"+hostname+":3306/"+dbname);
			ds.setUsername(username);
			ds.setPassword(password);
		}else {
			return null;
		}
		
		return ds;
	}

}
