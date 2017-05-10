package data;

import datatransferobject.DataTransferObject;

public class RouteData extends DataTransferObject {
	
	
	private String start;
	private String end;
	private double distance;
	private double emission;
	
	public RouteData(String start, String end, double distance, double emission) {
		this.start = start;
		this.end = end;
		this.distance = distance;
		this.emission = emission;
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

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getEmission() {
		return emission;
	}

	public void setEmission(double emission) {
		this.emission = emission;
	}
	

}
