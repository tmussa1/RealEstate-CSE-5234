package edu.osu.cse5234.model;

public class Item {
	private String itemName;
	private String price;
	private int quantity;
	
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
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Item(String itemName, String price) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.quantity = 0;
	}
	public Item() {
	}
}
