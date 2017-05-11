package domain;

public class Route {

	private double distance;
	private String start;
	private String end;
	private double emission;
	private double fuelConsumption;
	private String user;
	
	private Calculator calculator;
	
	
	public Route(String start, String end, double distance, double fuelConsumption, String user){
		this.distance = distance;
		this.start = start;
		this.end = end;
		this.fuelConsumption =fuelConsumption;
		this.user = user;
		
		calculator = new Calculator();
		emission = calculator.calculateRoute(distance, fuelConsumption);
	}


	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}


	public String getStart() {
		return start;
	}


	public void setStart(String start) {
		this.start = start;
	}


	public String getEnd() {
		return end;
	}


	public void setEnd(String end) {
		this.end = end;
	}


	public double getEmission() {
		return emission;
	}


	public void setEmission(double emission) {
		this.emission = emission;
	}


	public double getFuelConsumption() {
		return fuelConsumption;
	}


	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}


	public Calculator getCalculator() {
		return calculator;
	}


	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


}
