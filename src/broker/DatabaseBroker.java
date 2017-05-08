package broker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseBroker {
	
	public DatabaseBroker(){
		
		String url = "jdbc:mysql://mysql.iei.liu.se:5432/pgiei05";
		String username = "pgiei05";
		String password = "ZA0Nc((qfp4w";

		System.out.println("Connecting database...");

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
}
