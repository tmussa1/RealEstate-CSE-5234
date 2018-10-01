package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;

@Controller
@ComponentScan(basePackages={"edu.osu.cse5234.config" , "edu.osu.cse5234.controller", "edu.osu.cse5234.model"})
@RequestMapping("/purchase")
@Scope("session")
public class RealEstateController {
	
	@Autowired
	HttpSession session;
	
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
	public String submitItems(@ModelAttribute Order order1, HttpServletRequest request ,
			HttpServletResponse response) {
		request.getSession().setAttribute("order", order1);
		return "redirect:/purchase/paymententry";
	}
	
	@RequestMapping(path = "/paymententry", method = RequestMethod.GET)
	public String paymentEntry(HttpServletRequest request , HttpServletResponse response) {
		request.setAttribute("paymentInfo", new PaymentInfo());
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitpayment",  method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute PaymentInfo paymentInfo, 
			HttpServletRequest request , HttpServletResponse response) {
		request.getSession().setAttribute("paymentInfo", paymentInfo);
		return "redirect:/purchase/shippingentry";
	}
	
	@RequestMapping (path ="/shippingentry", method = RequestMethod.GET)
	public String shippingEntry(HttpServletRequest request , HttpServletResponse response) {
		request.setAttribute("shippingInfo", new ShippingInfo());
		return "ShippingEntryForm";
	}
	
	@RequestMapping(path = "/submitshipping",  method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute ShippingInfo shippingInfo,
			HttpServletRequest request , HttpServletResponse response) {
		request.getSession().setAttribute("shippingInfo", shippingInfo);
		return "redirect:/purchase/vieworder";
	}
	
	@RequestMapping(path = "/vieworder",  method = RequestMethod.GET)
	public String viewOrder(HttpServletRequest request , HttpServletResponse responsen) {
		Order order = (Order) request.getSession().getAttribute("order");
		request.setAttribute("order", order);
		return "ViewOrder";
	}
	
	@RequestMapping(path = "/confirmorder",  method = RequestMethod.POST)
	public String confirmOrder(HttpServletRequest request , HttpServletResponse response) {
		return "redirect:/purchase/viewconfirmation";
	}
	
	@RequestMapping(path = "/viewconfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request , HttpServletResponse response) {
		return "ViewConfirmation";
	}
}
