package edu.grupp1.domain;

import java.util.ArrayList;

import edu.grupp1.data.datatransferobject.DataTransferObject;
import edu.grupp1.data.dto.RouteData;
import edu.grupp1.data.dto.UserData;
import edu.grupp1.ui.observer.IObserver;
import edu.grupp1.ui.observer.ISubject;
import edu.grupp1.ui.swing.Misma;

public class User {
	private String username;
	private String password;
	private int level;
	
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}

	public User(UserData userData) {
		username = userData.getUsername();
		password = userData.getPassword();
		level = userData.getLevel();
	}

	public User(String username, String password, int level) {
		this.username = username;
		this.password = password;
		this.level = level;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public DataTransferObject transform() {
		DataTransferObject userData = new UserData(this);
		return userData;
	}
}
