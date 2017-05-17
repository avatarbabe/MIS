package domain;

public class Calculator {

	private Taxes tax;
	private double emission;

	public Calculator(Taxes tax) {
		this.tax = tax;
	}

	public Calculator() {
		
	}

	// R�knar ut utsl�ppen f�r en viss str�cka med ett visst fordon
	public double calculateRoute(double distance, double fuelConsumption) {
		emission = distance * fuelConsumption;
		emission = emission * 0.003;
		return emission;
	}

	// R�knar ut utsl�ppen f�r en viss m�ngd br�nsle
	public double calculateFuel(double volume, double emissionRate) {
		emission = volume * emissionRate;
		return emission;
	}

	public double calculateTax(double emission) {
		return emission * tax.getTaxRate();
	}

}
