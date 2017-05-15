package data;

import datatransferobject.DataTransferObject;

public class TaxesData extends DataTransferObject {

	private double taxRate;

	public TaxesData(double taxRate) {
		this.taxRate = taxRate;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

}
