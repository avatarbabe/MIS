package data;

import datatransferobject.DataTransferObject;
import domain.Fuel;

public class FuelData extends DataTransferObject {
	private int id;
	private double volume;
	private double emissionRate;
	private double emission;
	private String user;
	private String fuelType;

	public FuelData(double volume, String fuelType, double emission, String user) {
		this.volume = volume;
		this.fuelType = fuelType;
		this.emission = emission;
		this.user = user;

	}

	public FuelData(double volume, String fuelType, double emission, String user, int id) {
		this.volume = volume;
		this.fuelType = fuelType;
		this.emission = emission;
		this.user = user;
		this.id = id;

	}

	public FuelData(Fuel fuel) {
		volume = fuel.getVolume();
		fuelType = fuel.getFuelType();
		emission = fuel.getEmission();
		user = fuel.getUser();
		id = fuel.getId();
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getEmission() {
		return emission;
	}

	public void setEmission(double emission) {
		this.emission = emission;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
