package at.hackenberger.exporter.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultSetDecoder {

	private ResultSet resultSet;

	public ResultSetDecoder(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public String[][] decode() throws SQLException {
		if(resultSet.isClosed())
			throw new SQLException("Can not decode ResultSet it is already closed");
		ArrayList<ArrayList<String>> out = new ArrayList<>();
		while(resultSet.next()) {
			ArrayList<String> z = new ArrayList<String>();
			for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
				Object o = resultSet.getObject(i);
				if(o == null)
					z.add("NULL");
				else
					z.add(o.toString());
			}
			out.add(z);
		}
		String[][] array = new String[out.size()][];
		for (int i = 0; i < out.size(); i++) {
		    ArrayList<String> row = out.get(i);
		    array[i] = row.toArray(new String[row.size()]);
		}
		resultSet.close();
		return array;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

}
