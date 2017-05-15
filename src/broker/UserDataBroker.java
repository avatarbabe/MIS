package broker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.FuelData;
import data.UserData;
import datatransferobject.DataTransferObject;
import domain.User;

public class UserDataBroker extends Broker {
	ArrayList<User> users;

	public UserDataBroker() {
		super();
	}

	public void deleteUser(User user) {
		users.remove(user.getUsername());
		System.out.println("User: " + user.getUsername() + ", deleted from database");
	}

	@Override
	public List<DataTransferObject> find(UserData data) {

		List<DataTransferObject> users = new ArrayList<>();

		try {
			Connection conn = super.getDBConnection();

			PreparedStatement selectUser = conn
					.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");

			selectUser.setString(1, data.getUsername());
			selectUser.setString(2, data.getPassword());

			ResultSet rst;
			rst = selectUser.executeQuery();

			while (rst.next()) {
				users.add(new UserData(rst.getString("username"), rst.getString("password"), rst.getInt("level")));
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
}
