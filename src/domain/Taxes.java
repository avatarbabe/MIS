package domain;

public class Taxes {

	private double taxRate;

	public Taxes() {

	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		//+ ändra i databasen
		this.taxRate = taxRate;
	}

}
