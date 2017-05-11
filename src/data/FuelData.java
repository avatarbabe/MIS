package data;

import datatransferobject.DataTransferObject;

public class FuelData extends DataTransferObject {
	private double volume;
	private double emissionRate;
	private double emission;
	
	public FuelData(double volume, double emissionRate, double emission){
		this.volume = volume;
		this.emissionRate = volume;
		this.emission = emission;
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
	
	
}
