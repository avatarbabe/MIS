package domain;

import java.util.List;

import data.FuelData;
import data.RouteData;
import datatransferobject.DataTransferObject;

public class Taxes {

	private double taxrate;
	private String dateFrom;
	private String dateTo;

	public Taxes(Double taxrate) {
		this.taxrate = taxrate;
	}

	public Taxes() {
		// TODO Auto-generated constructor stub
	}

	public double getTaxRate() {
		return taxrate;
	}

	public void setTaxRate(double taxRate) {
		this.taxrate = taxRate;
	}
	
	public double getTotalTax(List<DataTransferObject> fuel, List<DataTransferObject> routes, double tax){
		double totalEmissions = 0;
		
		for(DataTransferObject dtoFuel: fuel){
			totalEmissions = totalEmissions + ((FuelData) dtoFuel).getEmission();
		}
		for(DataTransferObject dtoRoute: routes){
			totalEmissions = totalEmissions + ((RouteData) dtoRoute).getEmission();
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

}
