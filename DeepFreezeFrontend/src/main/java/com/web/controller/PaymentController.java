package com.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
	
	@Autowired 
	private JavaMailSender mailSender; 
	
	private int ORDER_ID;
	private Date ORDER_DATE;
	private String ORDER_MODE;
	private int ORDER_SUBTOTAL;
	private String ORDER_ITEMS =" ";
	 

	
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
		
		//Code for Mailing:
		ORDER_SUBTOTAL= grandTotal;
		
		for (Cart item : listCartItems) {
			
			ORDER_ITEMS= ORDER_ITEMS+ "\nProduct Name:" + item.getProductName() +"\n Product Price: " + item.getPrice() +"\n Product Quantity:" + item.getQuantity() +"\n Subtotal Amount" + item.getQuantity()*item.getPrice() +"\n\n";
		}
		
		OrderDetail order= new OrderDetail();
		order.setUserName(username);
		order.setPmode(pmode);
		order.setOrderDate(new java.util.Date());
		order.setShopingAmount(grandTotal);
		
		orderDAO.paymentProcess(order);
		
		if(orderDAO.updateCartItemStatus(username, order.getOrderId()))
		{
			//code for Mailing:
			ORDER_ID = order.getOrderId();
			ORDER_DATE =order.getOrderDate();
			ORDER_MODE = order.getPmode();
			
			
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
	
	@RequestMapping(value="/sendEmail",method = RequestMethod.GET)
	public String doSendEmail(HttpServletRequest request,HttpSession session) 
	{
		//Code for Bill:
		String username=(String)session.getAttribute("username");
		System.out.println("username:::::::"+username);
		
		
		int subTotal = ORDER_SUBTOTAL;
		int grandTotal = subTotal +150;
		Date date = ORDER_DATE;
		int orderId = ORDER_ID;
		String orderMode = ORDER_MODE;
		String orderUsername = userDAO.getUser(username).getCustomername();
		String address = userDAO.getUser(username).getAddress();
		
		
		String actualMessage= " Order # ORD		:"+orderId+ "\n" +
								"Billed To		:"+ orderUsername + "\n" +
								"Shipped To		:"+ address + "\n" +
								"Payment Method	:"+orderMode +"\n" +
								"Order Date		:"+date + "\n\n\n\n" +
								"Order summary	:"+ORDER_ITEMS +"\n\n" +
								"Subtotal		:"+subTotal +"\n" +
								"Shipping		:"+"INR. $150" +"\n" +
								"Total			:"+"INR. $"+grandTotal +"\n\n";									
		
		
		
		//Code for Email:
		System.out.println("Inside send email() Done####"); 
        // takes input from e-mail form 
        String recipientAddress = request.getParameter("email"); 
        String fname=request.getParameter("firstname"); 
        String subject =" Deepfreeze - Your Paid Receipt(Bill) "; 
        
        String finalmessage="Hi "+fname+",\n\n\n\n\n\n\n\n"+actualMessage+ "\n\n\n"; 
          
        
        
        System.out.println(recipientAddress+"  "+fname+" "); 
       
        
        System.out.println("To: " + recipientAddress); 
        System.out.println("Subject: " + subject); 
         
          
        // creates a simple e-mail object 
        SimpleMailMessage email = new SimpleMailMessage(); 
        email.setTo(recipientAddress); 
        email.setSubject(subject); 
        email.setText(finalmessage); 
          
        // sends the e-mail 
        mailSender.send(email); 
         System.out.println("Success"); 
        // forwards to the view named "Result" 
        return "Result"; 
   
	}
	
	
}
