package edu.grupp1.data.broker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.grupp1.data.datatransferobject.DataTransferObject;
import edu.grupp1.data.dto.RouteData;
import edu.grupp1.data.dto.UserData;

public abstract class Broker {

	private String url = "jdbc:mysql://mysql.iei.liu.se:5432/pgiei05";
	private String username = "pgiei05";
	private String password = "ZA0Nc((qfp4w";

	private HashMap<Integer, DataTransferObject> cache = new HashMap<>();

	public Broker() {

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

	public List<DataTransferObject> find(DataTransferObject data) {

		List<DataTransferObject> dtos = new ArrayList<>();
		
		//Simple cache för taxes 
		if (cache.containsKey(data.getId())) {
			dtos.add(cache.get(data.getId()));
			System.out.println("Cache!");
			return dtos;
		} else {
			dtos = this.findInStorage(data);

			for (DataTransferObject dto1 : dtos) {
				cache.put(dto1.getId(), dto1);

			}
			System.out.println("No cache");
			return dtos;

		}
	}
	
	public void putInCache(DataTransferObject dto){
		cache.put(dto.getId(), dto);
	}

	public abstract List<DataTransferObject> findInStorage(DataTransferObject data);

	public abstract void insert(DataTransferObject data);

	public abstract List<DataTransferObject> findAll();

	public abstract void update(DataTransferObject data);
	

	public void putInCache(DataTransferObject data) {
		cache.put(data.getId(), data);
		
	}

}
