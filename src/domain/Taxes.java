package domain;

public class Taxes {

	private double taxrate;

	public Taxes(Double taxrate) {
		this.taxrate = taxrate;
	}

	public double getTaxRate() {
		return taxrate;
	}

	public void setTaxRate(double taxRate) {
		//+ �ndra i databasen
		this.taxrate = taxRate;
	}

}
