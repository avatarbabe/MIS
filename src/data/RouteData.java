package data;

import datatransferobject.DataTransferObject;
import domain.Route;

public class RouteData extends DataTransferObject {

	private int id;
	private String start;
	private String end;
	private double distance;
	private double emission;
	private String user;
	private String vehicle;

	public RouteData(String start, String end, double distance, double emission, String user, String vehicle) {
		this.start = start;
		this.end = end;
		this.distance = distance;
		this.emission = emission;
		this.user = user;
		this.vehicle = vehicle;
	}

	public RouteData(Route route) {
		start = route.getStart();
		end = route.getEnd();
		distance = route.getDistance();
		emission = route.getEmission();
		user = route.getUser();
		vehicle = route.getVehicle();
		id = route.getId();
	}
	
	public RouteData(String start, String end, double distance, double emission, String user, int id) {
		this.start = start;
		this.end = end;
		this.distance = distance;
		this.emission = emission;
		this.user = user;
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicle() {
		return vehicle;
	}

}
