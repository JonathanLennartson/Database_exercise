package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static String URL = "jdbc:mysql://localhost:3306/business_database?Timezone=UTC";
	private static String USER = "root";
	private static String PASSWORD = "jonathan";
	
	public static Connection getConnection() {
				
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		
		} catch (SQLException e) {
			throw new RuntimeException("Error " + e.getMessage());
		}
	}

}
