package com.web.controller;

import java.util.List;

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

@Controller
public class CartController {
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/addToCart/{productId}")
	public String addToCart(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity,Model m)
	{
		Product product=productDAO.getProduct(productId);
		
		String username="Yang";
		
		Cart cart=new Cart();
		cart.setProductId(product.getProdId());
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
	public String deleteCartItem(@PathVariable("cartItemId")int cartItemId,Model m)
	{
		Cart cart=cartDAO.getCartItem(cartItemId);
		cartDAO.deleteItemFromCart(cart);
		
		String username ="Yang";
		
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("cartItems",listCartItems);
		m.addAttribute("grandTotal", this.calculateGrandTotal(listCartItems));
		
		
		return "Cart";
	}
	
	@RequestMapping("/updateCartItem/{cartItemId}")
	public String updateCartItem(@PathVariable("cartItemId") int cartItemId, @RequestParam("quantity") int quantity,Model m)
	{
		Cart cart= cartDAO.getCartItem(cartItemId);
		cart.setQuantity(quantity);
		cartDAO.updateCartItem(cart);
		
		String username="Yang";
		
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("cartItems",listCartItems);
		m.addAttribute("grandTotal", this.calculateGrandTotal(listCartItems));
		
		
		return "Cart";
		
	}
	

}
