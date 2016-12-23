package model.database;

import java.io.Closeable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.common.Debugger;
import model.constants.DatabaseConstants;

public class DataStore implements Closeable {

	private Connection connection;
	private Statement statement;
	public ResultSet resultSet;

	public DataStore() {
		try {
			Class.forName(DatabaseConstants.DBDriver);
		} catch (ClassNotFoundException ex) {
			Debugger.consolePrintln("Oracle driver error: " + ex.getMessage());
		}

		try {
			connection = DriverManager.getConnection(DatabaseConstants.connectionString, DatabaseConstants.userName,
					DatabaseConstants.password);
			statement = connection.createStatement();
		} catch (SQLException ex) {
			Debugger.consolePrintln("OracleException: " + ex.getMessage());
			Debugger.consolePrintln("OracleState: " + ex.getSQLState());
			Debugger.consolePrintln("VendorError: " + ex.getErrorCode());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public CallableStatement prepareCall(String callableStatementIn) throws SQLException {
		return connection.prepareCall(callableStatementIn);
	}

	public void commit() throws SQLException {
		if (connection != null)
			connection.commit();
	}

	public void rollback() throws SQLException {
		if (connection != null)
			connection.rollback();
	}

	@Override
	public void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * It gives you the date in sql format
	 * 
	 * @return SQL DatE
	 */
	public static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	/**
	 * It gives you the date and time in sql format
	 * 
	 * @return SQL DatE
	 */
	public static java.sql.Timestamp getCurrentTimeStamp() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}

	public void executeCallableStatement(CallableStatement callableStatement) throws SQLException {
		if (callableStatement != null) {
			callableStatement.executeUpdate();
		}
	}

	public void setAutoCommit(boolean autoCommit) throws SQLException {
		if (connection != null) {
			connection.setAutoCommit(autoCommit);
		}
	}

}
