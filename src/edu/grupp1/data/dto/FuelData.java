package edu.grupp1.data.dto;

import edu.grupp1.data.datatransferobject.DataTransferObject;
import edu.grupp1.domain.Fuel;

//Ärver från superklassen DataTransferObject

public class FuelData extends DataTransferObject {
	private int id;
	private double volume;
	private double emissionRate;
	private double emission;
	private String user;
	private String fuelType;
	private String dateFrom;
	private String dateTo;

	public FuelData(double volume, String fuelType, double emission, String user) {
		this.volume = volume;
		this.fuelType = fuelType;
		this.emission = emission;
		this.user = user;

	}

	public FuelData(double volume, String fuelType, double emission, String user, int id, double emissionRate) {
		this.volume = volume;
		this.fuelType = fuelType;
		this.emission = emission;
		this.user = user;
		this.id = id;
		this.emissionRate = emissionRate;

	}

	public FuelData(Fuel fuel) {
		volume = fuel.getVolume();
		fuelType = fuel.getFuelType();
		emission = fuel.getEmission();
		emissionRate = fuel.getEmissionRate();
		user = fuel.getUser();
		id = fuel.getId();
		dateFrom = fuel.getDateFrom();
		dateTo = fuel.getDateTo();
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getEmission() {
		return emission;
	}

	public void setEmission(double emission) {
		this.emission = emission;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getEmissionRate() {
		return emissionRate;
	}

	public void setEmissionRate(double emissionRate) {
		this.emissionRate = emissionRate;
	}

}
