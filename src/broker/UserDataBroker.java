package broker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.User;

public class UserDataBroker extends DatabaseBroker {
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

		Connection conn = super.getDBConnection();
		
		Statement stm;
		try {
			
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
}
