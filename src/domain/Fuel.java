package domain;

public class Fuel {
	private double volume;
	private double emissionRate;
	private double emission;
	
	private Calculator calculator;
	
	public Fuel(double volume, double emissionRate){
		this.volume = volume;
		this.emissionRate = emissionRate;
		
		calculator = new Calculator();
		emission = calculator.calculateFuel(volume, emissionRate);
	}
}
