package domain;

public class Route {

	private int id;
	private double distance;
	private String start;
	private String end;
	private double emission;
	private double fuelConsumption;
	private String user;
	private String vehicle;

	private Calculator calculator;

	public Route(String start, String end, double distance, double fuelConsumption, String user, String vehicle) {
		this.distance = distance;
		this.start = start;
		this.end = end;
		this.fuelConsumption = fuelConsumption;
		this.user = user;
		this.vehicle = vehicle;

		calculator = new Calculator();
		emission = calculator.calculateRoute(distance, fuelConsumption);
	}

	public Route() {
		// TODO Auto-generated constructor stub
	}

	public Route(String start, String end, double distance, double fuelConsumption, String user, int id) {
		this.start = start;
		this.end = end;
		this.distance = distance;
		this.user = user;
		this.id = id;
		
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

}
