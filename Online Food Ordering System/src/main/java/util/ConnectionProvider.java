package util;

import java.sql.*;

public class ConnectionProvider {

	private static Connection con;
	
	// This works according to singleton pattern
	private ConnectionProvider() {
	}
	
	@SuppressWarnings("unused")
	public static Connection getDBConnection() {
		try {
			if (con == null || con.isClosed()) {

				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_project", "root", "root");
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static Connection init() {
		// TODO Auto-generated method stub
		return null;
	}
}
