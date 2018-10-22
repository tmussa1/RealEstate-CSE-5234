package edu.osu.cse5234.business;

import java.util.Optional;
import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {
	
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	InventoryService inventory = ServiceLocator.getInventoryService();
    	if(inventory.validateQuantity(order.getItemList())) {
    		inventory.updateInventory(order.getItemList());
    	}
    	return "E35961" + new Random().nextInt(1000);
    }

    public boolean validateItemAvailability(Order order) {
    	return ServiceLocator.getInventoryService().validateQuantity(order.getItemList());
    }
}
