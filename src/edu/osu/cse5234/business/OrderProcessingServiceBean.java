package edu.osu.cse5234.business;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {
	
	@PersistenceContext
	EntityManager entityManager;
	
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	InventoryService inventory = ServiceLocator.getInventoryService();
    	List<Item> itemList = converter(order);
    	
    	if(inventory.validateQuantity(itemList)){
    		inventory.updateInventory(itemList);
    		entityManager.persist(order);
    		entityManager.flush();
    	}
    	
    	return "E35961" + new Random().nextInt(1000);
    }

	private List<Item> converter(Order order) {
		if(order != null) {
		List<LineItem> lineItemList = order.getItemList();
    	List<Item> itemList = LineItem.lineItemToItemConverter(lineItemList);
    	return itemList;
		}
		return null;
	}

    public boolean validateItemAvailability(Order order) {
    	
    	List<Item> itemList = converter(order);
    	return ServiceLocator.getInventoryService().validateQuantity(itemList);
    }
}
