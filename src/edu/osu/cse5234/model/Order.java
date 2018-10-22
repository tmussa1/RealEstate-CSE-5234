package edu.osu.cse5234.model;

import java.util.ArrayList;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.osu.cse5234.business.view.Item;

@Component
@Scope("session")
public class Order {
	
	private List<Item> itemList;

	public Order(){
		itemList = new ArrayList<Item>();
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public int getTotalPrice() {
		int total = 0;
		int price = 0, quantity = 0;
		
		for(Item item: itemList) {
			price = Integer.parseInt(item.getPrice());
			quantity = item.getQuantity();
			total += (price * quantity);
		}
		return total;
	}
}