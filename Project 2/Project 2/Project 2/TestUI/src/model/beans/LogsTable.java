package model.beans;

import java.sql.Date;

/**
 * Data transfer object class for logs.
 * @author PRASHANT
 *
 */
public class LogsTable extends Table {
	private Integer logId = null;
	private String user = null;
	private Date time = null;
	private String tableName = null;
	private String operation = null;
	private String keyValue = null;

	public LogsTable(Integer logId, String user, Date time, String tableName, String operation, String keyValue) {
		super();
		this.logId = logId;
		this.user = user;
		this.time = time;
		this.tableName = tableName;
		this.operation = operation;
		this.keyValue = keyValue;
	}

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	@Override
	public String toString() {
		return "LogsTable [logId=" + logId + ", user=" + user + ", time=" + time + ", tableName=" + tableName
				+ ", operation=" + operation + ", keyValue=" + keyValue + "]";
	}
}
