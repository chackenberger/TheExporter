package at.hackenberger.exporter.utils;

public class SQLBuilder {

	private String sortField;

	private String sortDir;

	private String where;

	private String fields;

	private String table;

	public SQLBuilder(String fields, String table) {
		this.fields = fields;
		this.table = table;
	}

	public SQLBuilder(String fields, String table, String where, String sortDir, String sortField) {
		this(fields,table);
		this.where = where;
		this.sortDir = sortDir;
		this.sortField = sortField;
	}

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
