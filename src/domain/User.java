package domain;

public class User {
	private String username;
	private String password;
	private int level;
	
	public User(String username){
		this.username = username;
		//H�mta level fr�n databasen
	}
}
