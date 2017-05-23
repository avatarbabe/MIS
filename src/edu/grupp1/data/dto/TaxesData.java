package edu.grupp1.data.dto;

import edu.grupp1.data.datatransferobject.DataTransferObject;
import edu.grupp1.domain.Taxes;

public class TaxesData extends DataTransferObject {

	private int id;
	private double taxrate;
	private String dateFrom;
	private String dateTo;

	public TaxesData(double taxRate) {
		this.taxrate = taxRate;
	}

	public TaxesData(Taxes tax) {
		taxrate = tax.getTaxRate();
		dateFrom = tax.getDateFrom();
		dateTo = tax.getDateTo();
	}

	public double getTaxRate() {
		return taxrate;
	}

	public void setTaxRate(double taxRate) {
		this.taxrate = taxRate;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateOne) {
		this.dateFrom = dateOne;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTwo) {
		this.dateTo = dateTwo;
	}

}
