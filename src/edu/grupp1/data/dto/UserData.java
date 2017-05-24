package edu.grupp1.data.dto;

import edu.grupp1.data.datatransferobject.DataTransferObject;
import edu.grupp1.domain.User;

public class UserData extends DataTransferObject{
	private String username;
	private String password;
	private int level;
	
	public UserData (String username, String password){
		this.username = username;
		this.password = password;
	}

	public UserData(String username, String password, int level, int id) {
		this.username = username;
		this.password = password;
		this.level = level;
		super.setId(id);
	}

	public UserData(User user) {
		username = user.getUsername();
		password = user.getPassword();
		level = user.getLevel();
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



}
