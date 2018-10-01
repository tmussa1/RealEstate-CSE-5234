package edu.osu.cse5234.model;

public class PaymentInfo {
	private String creditCardNumber;
	private String expiryDate;
	private String cvv;
	private String holderName;
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public PaymentInfo(String creditCardNumber, String expiryDate, String cvv, String holderName) {
		super();
		this.creditCardNumber = creditCardNumber;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.holderName = holderName;
	}
	public PaymentInfo() {
	}
	
	
}
