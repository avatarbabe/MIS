package domain;

import java.util.ArrayList;
import java.util.List;

import data.UserData;
import datafacade.DataFacade;
import ui.Menu;

public class DomainFacade {

	private DataFacade data;
	private User aUser = null;
	
	public void register(DataFacade data) {
		this.data = data;
	}

	public User login(String username, String password) {
		
		UserData userData = new UserData(username, password);
		
		List<UserData> userList = data.find(userData);

		if(userList == null){
			return null;
		}else{
			System.out.println(userList.get(0).getUsername() + " aaa " + userList.get(0).getLevel());
			
			User user = new User(userList.get(0));
			System.out.println(user.getLevel());
			
			aUser = user;
			return user;
		}
		
	}

}
