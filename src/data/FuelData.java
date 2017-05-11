package data;

import datatransferobject.DataTransferObject;

public class FuelData extends DataTransferObject {
	private double volume;
	private double emissionRate;
	private double emission;
	private String user;
	private String fuelType;
	//wat

	public FuelData(double volume, String fuelType, double emission, String user) {
		this.volume = volume;
		this.fuelType = fuelType;
		this.emission = emission;
		this.user = user;
		
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

}
