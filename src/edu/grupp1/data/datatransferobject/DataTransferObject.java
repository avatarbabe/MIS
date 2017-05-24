package edu.grupp1.data.datatransferobject;

//Superklass för alla DTOs
//object identifier ID, håller ID från databasen

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
