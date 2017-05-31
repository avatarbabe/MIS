package edu.grupp1.data.datatransferobject;

//Superklass för alla DTOs

public class DataTransferObject {
	
	//object identifier ID, håller ID från databasen
	private int id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	
}
