package org.reploop.parser.mysql.tree;

public abstract class CreateTable extends DdlStatement {

	String tableName;

	boolean temporary;

	boolean ifNotExists;

	public CreateTable(String tableName, boolean temporary, boolean ifNotExists) {
		this.tableName = tableName;
		this.temporary = temporary;
		this.ifNotExists = ifNotExists;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public boolean isTemporary() {
		return temporary;
	}

	public void setTemporary(boolean temporary) {
		this.temporary = temporary;
	}

	public boolean isIfNotExists() {
		return ifNotExists;
	}

	public void setIfNotExists(boolean ifNotExists) {
		this.ifNotExists = ifNotExists;
	}

}
