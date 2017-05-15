package data;

import datatransferobject.DataTransferObject;
import domain.Taxes;

public class TaxesData extends DataTransferObject {

	private double taxrate;

	public TaxesData(double taxRate) {
		this.taxrate = taxRate;
	}

	public TaxesData(Taxes tax) {
		taxrate = tax.getTaxRate();
	}

	public double getTaxRate() {
		return taxrate;
	}

	public void setTaxRate(double taxRate) {
		this.taxrate = taxRate;
	}

}
