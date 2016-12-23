package model.constants;

public class DatabaseConstants {
	public static final String DBDriver = "oracle.jdbc.driver.OracleDriver";
	/* For Local DB */
	public static final String DBServerIP = "localhost";
	public static final String DBServerPort = "1521";
	public static final String userName = "pk2";
	public static final String password = "pk2";
	public static final String connectionString = "jdbc:oracle:thin:@//" + DBServerIP + ":" + DBServerPort + "/xe";
}
