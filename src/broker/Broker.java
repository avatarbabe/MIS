package broker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import data.UserData;
import datatransferobject.DataTransferObject;

public abstract class Broker {
	
	private String url = "jdbc:mysql://mysql.iei.liu.se:5432/pgiei05";
	private String username = "pgiei05";
	private String password = "ZA0Nc((qfp4w";
	
	public Broker(){
		
		

		System.out.println("Connecting database...");

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}

	public Connection getDBConnection() {
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
		
		
	}

	public abstract List<DataTransferObject> find(UserData data);
	
	
}