package domain;

public class Route {

	private double distance;
	private String from;
	private String to;
	private double emission;
	private double fuelConsumption;
	
	private Calculator calculator;
	
	
	public Route(double distance, String from, String to, double fuelConsumption){
		this.distance = distance;
		this.from = from;
		this.to = to;
		this.fuelConsumption =fuelConsumption;
		
		calculator = new Calculator();
		emission = calculator.calculateRoute(distance, fuelConsumption);
	}
}
