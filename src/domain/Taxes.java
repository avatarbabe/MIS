package domain;

import java.util.List;

import data.FuelData;
import data.RouteData;
import datatransferobject.DataTransferObject;

public class Taxes {

	private double taxrate;

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
	
	public double getTotalTax(List<DataTransferObject> fuel, List<DataTransferObject> routes){
		double totalEmissions = 0;
		
		for(DataTransferObject dto: fuel){
			totalEmissions = totalEmissions + ((FuelData) fuel).getEmission();
		}
		for(DataTransferObject dto: routes){
			totalEmissions = totalEmissions + ((RouteData) fuel).getEmission();
		}
		
		return totalEmissions;
	}

}
