package broker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	// retrive list of students from the database
	public ArrayList<User> getAllUsers() {

		try {
			Connection conn = super.getDBConnection();
			Statement stm;
			stm = conn.createStatement();

			String sql = "Select * From users";
			ResultSet rst;
			rst = stm.executeQuery(sql);

			users = new ArrayList<>();

			while (rst.next()) {
				User user = new User(rst.getString("username"), rst.getString("password"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public User findUser(String username, String password) {
		
		try {
			Connection conn = super.getDBConnection();
			Statement stm;
			stm = conn.createStatement();

			String sql = "Select * From users WHERE username = \"" + username + "\" AND password = \"" + password + "\"";
			ResultSet rst;
			rst = stm.executeQuery(sql);

			while (rst.next()) {
				User user = new User(rst.getString("username"), rst.getString("password"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<DataTransferObject> find(UserData data) {
		
		List<DataTransferObject> users = new ArrayList<>();
		
		try {
			Connection conn = super.getDBConnection();
			Statement stm;
			stm = conn.createStatement();

			String sql = "Select * From users WHERE username = \"" + data.getUsername() + "\" AND password = \"" + data.getPassword() + "\"";
			ResultSet rst;
			rst = stm.executeQuery(sql);
			System.out.println(sql);
			while (rst.next()) {
				users.add(new UserData(rst.getString("username"), rst.getString("password")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
