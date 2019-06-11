package com.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.dao.CartDAO;
import com.web.dao.ProductDAO;
import com.web.model.Cart;
import com.web.model.Product;


/*@Controller annotation indicates that a particular class serves the role of a controller. */
/*The dispatcher scans such annotated classes for mapped methods and detects @RequestMapping annotations.*/

@Controller
public class CartController {
	
	/*@Autowired - used to auto wire "cartDAO" bean from spring container.This enables us to inject the object dependency implicitly during runtime.*/
	@Autowired
	CartDAO cartDAO;
	
	/*@Autowired - used to auto wire "productDAO" bean from spring container.*/
	@Autowired
	ProductDAO productDAO;
	
	/* @RequestMapping annotation specify what HTTP Request is handled by the controller and by this "addToCart()" method.*/
	@RequestMapping(value="/addToCart/{prodId}")
	public String addToCart(@PathVariable("prodId")int productId,@RequestParam("quantity")int quantity,Model m,HttpSession session)
	{
		Product product=productDAO.getProduct(productId);
		
		String username=(String)session.getAttribute("username");
		
		Cart cart=new Cart();
		cart.setProdId(product.getProdId());
		cart.setProductName(product.getProdName());
		cart.setQuantity(quantity);
		cart.setPrice(product.getPrice());
		cart.setUsername(username);
		cart.setStatus("NP");
		
		
		cartDAO.addToCart(cart);
		
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("grandTotal", this.calculateGrandTotal(listCartItems));
		
		return "Cart";
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
	
	@RequestMapping("/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId")int cartItemId,Model m,HttpSession session)
	{
		Cart cart=cartDAO.getCartItem(cartItemId);
		cartDAO.deleteItemFromCart(cart);
		
		String username=(String)session.getAttribute("username");
		
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("cartItems",listCartItems);
		m.addAttribute("grandTotal", this.calculateGrandTotal(listCartItems));
		
		
		return "Cart";
	}
	
	@RequestMapping("/updateCartItem/{cartItemId}")
	public String updateCartItem(@PathVariable("cartItemId") int cartItemId, @RequestParam("quantity") int quantity,Model m,HttpSession session)
	{
		Cart cart= cartDAO.getCartItem(cartItemId);
		cart.setQuantity(quantity);
		cartDAO.updateCartItem(cart);
		
		String username=(String)session.getAttribute("username");
		
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("cartItems",listCartItems);
		m.addAttribute("grandTotal", this.calculateGrandTotal(listCartItems));
		
		
		return "Cart";
		
	}
	
	@RequestMapping("/showCart")
	public String showCart(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("cartItems",listCartItems);
		m.addAttribute("grandTotal", this.calculateGrandTotal(listCartItems)); 
		
		return "Cart";
	}
	

}
