package domain;

public class Calculator {

	private double emission;

	// Räknar ut utsläppen för en viss sträcka med ett visst fordon
	public double calculateRoute(double distance, double fuelConsumption) {
		emission = distance * fuelConsumption;
		emission = emission * 0.003;
		return emission;
	}

	// Räknar ut utsläppen för en viss mängd bränsle
	public double calculateFuel(double volume, double emissionRate) {
		emission = volume * emissionRate;
		return emission;
	}
	
	public double calculateTax(){
		return 1.0;
	}

}
