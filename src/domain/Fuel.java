package domain;

public class Fuel {
	private double volume;
	private String fuelType;
	private double emissionRate;
	private double emission;
	private String user;

	private Calculator calculator;

	public Fuel(double volume, String fuelType, double emissionRate, String user) {
		this.volume = volume;
		this.fuelType = fuelType;
		this.emissionRate = emissionRate;
		this.user = user;

		calculator = new Calculator();
		emission = calculator.calculateFuel(volume, emissionRate);
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
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

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	
}
