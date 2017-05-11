package data;

import datatransferobject.DataTransferObject;

public class FuelData extends DataTransferObject {
	private double volume;
	private double emissionRate;
	private double emission;
	private String user;

	public FuelData(double volume, double emissionRate, double emission, String user) {
		this.volume = volume;
		this.emissionRate = volume;
		this.emission = emission;
		this.user = user;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getEmissionRate() {
		return emissionRate;
	}

	public void setEmissionRate(double emissionRate) {
		this.emissionRate = emissionRate;
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

}
