package at.hackenberger.exporter.utils;

/**
 * For building a SQL String
 * 
 * @author Hackenberger Christoph
 * @version 1.0
 */
public class SQLBuilder {

	private String sortField;

	private String sortDir;

	private String where;

	private String fields;

	private String table;

	/**
	 * Creates a new SQLBuilder
	 * @param fields the fields which should be shown
	 * @param table the table that should be used
	 */
	public SQLBuilder(String fields, String table) {
		this.fields = fields;
		this.table = table;
	}

	/**
	 * Creates a new SQLBuilder
	 * @param fields the fields which should be shown
	 * @param table the table that should be used
	 * @param where a where claus for example "cost < 10 OR text LIKE 'test%'"
	 * @param sortDir sort direction ASC or DESC
	 * @param sortField the field by which the table should be sorted
	 */
	public SQLBuilder(String fields, String table, String where, String sortDir, String sortField) {
		this(fields,table);
		this.where = where;
		this.sortDir = sortDir;
		this.sortField = sortField;
	}

	/**
	 * Generated the SQL String
	 * @return the SQL String
	 */
	public String generateSQL() {
		String out = "SELECT "+fields+" FROM " + table;
		if(where != null)
			out += " WHERE "+where;
		if(sortField != null)
			out += " ORDER BY "+sortField + " " + sortDir;
		return out;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public void setFields(String fields) {

	}

	public void setTable(String table) {

	}

}
