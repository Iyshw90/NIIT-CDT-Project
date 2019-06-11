package com.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.dao.CartDAO;
import com.web.dao.OrderDAO;
import com.web.dao.UserDAO;
import com.web.model.Cart;
import com.web.model.OrderDetail;
import com.web.model.UserDetail;

/*@Controller annotation indicates that a particular class serves the role of a controller. */
/*The dispatcher scans such annotated classes for mapped methods and detects @RequestMapping annotations.*/

@Controller
public class PaymentController {
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@RequestMapping("/checkout")
	public String showOrderConfirmPage(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("grandTotal", this.calculateGrandTotal(listCartItems));
		
		UserDetail user = userDAO.getUser(username);
		m.addAttribute("addr", user.getAddress());
		
				
		return "OrderConfirm";
	}

	
	public int calculateGrandTotal(List<Cart> listCartItems)
	{
		int count=0, grandTotal =0;
		while(count < listCartItems.size())
		{
			grandTotal = grandTotal +listCartItems.get(count).getQuantity() * listCartItems.get(count).getPrice();
			count++;
		}
		return grandTotal;
	}
	
	@RequestMapping(value="/updateAddress" ,method=RequestMethod.POST)
	public String updateAddress(@RequestParam("addr") String addr, Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("grandTotal", this.calculateGrandTotal(listCartItems));
		
		
		UserDetail user = userDAO.getUser(username);
		user.setAddress(addr);
		userDAO.updateUser(user);
		
		m.addAttribute("addr", user.getAddress());
		
		return "OrderConfirm";
	}
	
	@RequestMapping(value="/pay", method=RequestMethod.POST)
	public String generateReceipt(@RequestParam("pmode") String pmode,Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("cartItems", listCartItems);
		
		int grandTotal = this.calculateGrandTotal(listCartItems);
		m.addAttribute("grandTotal", grandTotal);
		
		OrderDetail order= new OrderDetail();
		order.setUserName(username);
		order.setPmode(pmode);
		order.setOrderDate(new java.util.Date());
		order.setShopingAmount(grandTotal);
		
		orderDAO.paymentProcess(order);
		
		if(orderDAO.updateCartItemStatus(username, order.getOrderId()))
		{
			
			m.addAttribute("orderInfo", order);
			m.addAttribute("address", userDAO.getUser(username).getAddress());
			return "Receipt";
			
		}
		else
		{
			System.out.println("Not Completed");
			return "Cart";
			
		}
		
	}
	
	@RequestMapping("/paymentPage")
	public String showPaymentPage(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("grandTotal", this.calculateGrandTotal(listCartItems));
		
		return "Payment";
	}
	
	
}
