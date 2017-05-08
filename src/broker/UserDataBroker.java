package broker;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import domain.User;

public class UserDataBroker extends DatabaseBroker {
	ArrayList<User> users;

	public UserDataBroker() {
		
	    users = new ArrayList<>();
	    
	    while (rst.next()) {
	        Customer customer = new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
	        customerList.add(customer);
	    }
		
		
		

	}

	public void deleteUser(User user) {
		users.remove(user.getUsername());
		System.out.println("User: " + user.getUsername() + ", deleted from database");
	}

	// retrive list of students from the database
	public ArrayList<User> getAllUsers() {
		return users;
	}
}
