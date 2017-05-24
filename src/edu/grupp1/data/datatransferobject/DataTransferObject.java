package edu.grupp1.data.datatransferobject;

public class DataTransferObject {
	//object identifier ID
	private int id;
	private EnumState state = EnumState.CLEAN;
	
	
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	
}
