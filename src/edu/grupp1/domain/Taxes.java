package edu.grupp1.domain;

import java.util.List;

import edu.grupp1.data.datatransferobject.DataTransferObject;
import edu.grupp1.data.dto.FuelData;
import edu.grupp1.data.dto.RouteData;
import edu.grupp1.data.dto.TaxesData;

public class Taxes {

	private int id;
	private double taxrate;
	private String dateFrom;
	private String dateTo;

	public Taxes(Double taxrate) {
		this.taxrate = taxrate;
		id = 1;
	}

	public Taxes() {

	}
	
	public void setId(int id){
		this.id = id;
	}

	public double getTaxRate() {
		return taxrate;
	}

	public void setTaxRate(double taxRate) {
		this.taxrate = taxRate;
	}
	
	public double getTotalTax(List<Fuel> fuel, List<Route> routes, double tax){
		
		double totalEmissions = 0;
		
		for(Fuel fuel1: fuel){
			totalEmissions = totalEmissions + fuel1.getEmission();
		}
		for(Route route: routes){
			totalEmissions = totalEmissions + route.getEmission();
		}
		
		Calculator calc = new Calculator(tax);
		
		return calc.calculateTax(totalEmissions);
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
	
	public DataTransferObject transform() {
		DataTransferObject taxesData = new TaxesData(this);
		return taxesData;
	}

}
