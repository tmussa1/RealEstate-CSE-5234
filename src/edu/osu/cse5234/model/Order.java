package edu.osu.cse5234.model;

import java.util.ArrayList;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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

}