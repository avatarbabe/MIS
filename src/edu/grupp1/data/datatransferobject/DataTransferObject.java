package edu.grupp1.data.datatransferobject;

//Superklass f�r alla DTOs

public class DataTransferObject {
	
	//object identifier ID, h�ller ID fr�n databasen
	private int id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	
}
