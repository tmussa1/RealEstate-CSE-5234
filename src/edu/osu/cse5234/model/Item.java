package edu.osu.cse5234.model;

public class Item {
	private String itemName;
	private String price;
	private String quantity;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public Item(String itemName, String price) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.quantity = "0";
	}
	public Item() {
	}
}
