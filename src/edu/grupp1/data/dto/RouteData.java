package edu.grupp1.data.dto;

import edu.grupp1.data.datatransferobject.DataTransferObject;
import edu.grupp1.domain.Route;

public class RouteData extends DataTransferObject {

	private int id;
	private String start;
	private String end;
	private double distance;
	private double emission;
	private String user;
	private String vehicle;
	private String dateFrom;
	private String dateTo;

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
		dateFrom = route.getDateFrom();
		dateTo = route.getDateTo();
	}
	
	public RouteData(String start, String end, double distance, double emission, String user, int id, String vehicle) {
		this.start = start;
		this.end = end;
		this.distance = distance;
		this.emission = emission;
		this.user = user;
		this.id = id;
		this.vehicle = vehicle;
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

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

}
