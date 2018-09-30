package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;

@Controller
@RequestMapping("/purchase")
public class RealEstateController {
	
	Order order = new Order();
	List<Item> items = new ArrayList<>();
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String displayItems(HttpServletRequest request , HttpServletResponse response) {
		
		for(int i = 0; i < 5; i++) {
		 items.add(new Item("item : " + i, i + "10"));
		}
		
		Order order = new Order();
		order.setItemList(items);
		
		request.setAttribute("order", order);
		return "OrderEntryForm";
	}
	
	@RequestMapping(path = "/submititem",  method = RequestMethod.POST)
	public String submitItems(@ModelAttribute Order order, HttpServletRequest request , HttpServletResponse response) {
		request.getSession().setAttribute("order", order);
		return "redirect:/paymententry";
	}
	
	@RequestMapping(path = "/paymententry", method = RequestMethod.GET)
	public String paymentEntry(HttpServletRequest request , HttpServletResponse response) {
		request.setAttribute("paymentInfo", new PaymentInfo());
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitpayment",  method = RequestMethod.POST)
	public String submitPayment(HttpServletRequest request , HttpServletResponse response) {
		//request.getSession().setAttribute("paymentInfo", request.getAttribute("paymentInfo"));
		return "redirect:/shippingentry";
	}
	
	@RequestMapping (path ="/shippingentry", method = RequestMethod.GET)
	public String shippingEntry(HttpServletRequest request , HttpServletResponse response) {
		return "ShippingEntryForm";
	}
	
	@RequestMapping(path = "/submitshipping",  method = RequestMethod.POST)
	public String submitShipping(HttpServletRequest request , HttpServletResponse response) {
		return "redirect:/vieworder";
	}
	
	@RequestMapping(path = "/vieworder",  method = RequestMethod.GET)
	public String viewOrder(HttpServletRequest request , HttpServletResponse response) {
		return "ViewOrder";
	}
	
	@RequestMapping(path = "/confirmorder",  method = RequestMethod.POST)
	public String confirmOrder(HttpServletRequest request , HttpServletResponse response) {
		return "redirect:/viewconfirmation";
	}
	
	@RequestMapping(path = "/viewconfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request , HttpServletResponse response) {
		return "ViewConfirmation";
	}
}
