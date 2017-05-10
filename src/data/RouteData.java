package data;

import datatransferobject.DataTransferObject;

public class RouteData extends DataTransferObject {
	
	
	private String start;
	private String end;
	private double distance;
	private double emission;
	private double fuelConsumption;
	
	public RouteData(String start, String end, double distance, double fuelConsumption, double emission) {
		this.start = start;
		this.end = end;
		this.distance = distance;
		this.fuelConsumption = fuelConsumption;
		this.emission = emission;
	}

}
