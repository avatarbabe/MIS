package edu.grupp1.data.datatransferobject;

//Superklass f�r alla DTOs
//object identifier ID, h�ller ID fr�n databasen

public class DataTransferObject {
	
	private int id;
	private EnumState state = EnumState.CLEAN;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	
}
