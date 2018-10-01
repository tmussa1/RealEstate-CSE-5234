package edu.osu.cse5234.model;

public class ShippingInfo {
	private String customerName;
	private String lineOne;
	private String lineTwo;
	private String city;
	private String state;
	private String zipCode;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getLineOne() {
		return lineOne;
	}
	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}
	public String getLineTwo() {
		return lineTwo;
	}
	public void setLineTwo(String lineTwo) {
		this.lineTwo = lineTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public ShippingInfo(String customerName, String lineOne, String lineTwo, String city, String state,
			String zipCode) {
		super();
		this.customerName = customerName;
		this.lineOne = lineOne;
		this.lineTwo = lineTwo;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	public ShippingInfo() {
	}
	
	
}
