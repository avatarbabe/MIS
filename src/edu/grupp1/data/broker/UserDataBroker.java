package edu.grupp1.data.broker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.grupp1.data.datatransferobject.DataTransferObject;
import edu.grupp1.data.dto.FuelData;
import edu.grupp1.data.dto.UserData;
import edu.grupp1.domain.User;

public class UserDataBroker extends Broker {

	private ArrayList<User> users;

	private HashMap<String, DataTransferObject> cache = new HashMap<>();

	public List<DataTransferObject> find(DataTransferObject data) {

		List<DataTransferObject> dtos = new ArrayList<>();
		
		//Simple cache för inlogg
		//Kollar om username och password stämmer överens med något i hashmappen
		if (cache.containsKey(((UserData) data).getUsername()) && ((UserData) data).getPassword()
				.equals((((UserData) cache.get(((UserData) data).getUsername())).getPassword()))) {
			
			dtos.add(cache.get(((UserData) data).getUsername()));
			System.out.println("Cache!");
			return dtos;
		} else {
			dtos = this.findInStorage(data);

			for (DataTransferObject dto1 : dtos) {
				cache.put(((UserData) dto1).getUsername(), dto1);

			}
			System.out.println("No cache");
			return dtos;

		}
	}

	@Override
	public List<DataTransferObject> findInStorage(DataTransferObject data) {

		List<DataTransferObject> users = new ArrayList<>();

		try {
			Connection conn = super.getDBConnection();

			PreparedStatement selectUser = conn
					.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");

			selectUser.setString(1, ((UserData) data).getUsername());
			selectUser.setString(2, ((UserData) data).getPassword());

			ResultSet rst;
			rst = selectUser.executeQuery();

			while (rst.next()) {

				DataTransferObject dto = new UserData(rst.getString("username"), rst.getString("password"),
						rst.getInt("level"), rst.getInt("user_id"));

				users.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void insert(DataTransferObject data) {

		try {
			Connection conn = super.getDBConnection();
			PreparedStatement insertUser = conn
					.prepareStatement("INSERT INTO users(username, password, level) VALUES(?,?,?)");

			insertUser.setString(1, ((UserData) data).getUsername());
			insertUser.setString(2, ((UserData) data).getPassword());
			insertUser.setInt(3, ((UserData) data).getLevel());
			insertUser.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<DataTransferObject> findAll() {
		return null;
	}

	@Override
	public void update(DataTransferObject data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(DataTransferObject data) {
		// TODO Auto-generated method stub
		
	}
}
