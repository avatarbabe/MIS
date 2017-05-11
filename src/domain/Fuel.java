package domain;

public class Fuel {
	private double volume;
	private double emissionRate;
	private double emission;
	private String user;

	private Calculator calculator;

	public Fuel(double volume, double emissionRate, String user) {
		this.volume = volume;
		this.emissionRate = emissionRate;
		this.user = user;

		calculator = new Calculator();
		emission = calculator.calculateFuel(volume, emissionRate);
	}
	
}
