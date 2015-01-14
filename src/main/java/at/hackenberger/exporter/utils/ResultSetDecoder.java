package at.hackenberger.exporter.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import at.hackenberger.exporter.error.ResultSetReadException;

/**
 * Decodes a {@link ResultSet} to an 2d array
 * 
 * @author Christoph
 *
 */
public class ResultSetDecoder {

	private ResultSet resultSet;

	/**
	 * Creates a new object of ResultSetDecoder
	 * 
	 * @param resultSet
	 *            the {@link ResultSet} which should be decoded
	 */
	public ResultSetDecoder(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	/**
	 * Decodes the {@link ResultSet}
	 * 
	 * @return decoded {@link ResultSet} as 2d array
	 * @throws ResultSetReadException when something goes wrong while decoding the {@link ResultSet}
	 */
	public String[][] decode() throws ResultSetReadException {
		try {
			if (resultSet.isClosed())
				throw new SQLException(
						"Can not decode ResultSet it is already closed");
			ArrayList<ArrayList<String>> out = new ArrayList<>();
			while (resultSet.next()) {
				ArrayList<String> z = new ArrayList<String>();
				for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
					Object o = resultSet.getObject(i);
					if (o == null)
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
		} catch (SQLException ex) {
			throw new ResultSetReadException("Error while reading from database. Please check your information you provided!"+'\n'+
					"("+ex.getMessage()+")");
		}
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

}
