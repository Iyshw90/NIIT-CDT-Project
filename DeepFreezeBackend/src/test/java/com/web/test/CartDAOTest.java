package com.web.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.web.dao.CartDAO;
import com.web.model.Cart;

public class CartDAOTest {
	
	static CartDAO cartDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.web");
		context.refresh();
		
		cartDAO = (CartDAO) context.getBean("cartDAO");
	}

	
	@Test
	public void addToCartTest() {
		Cart cart= new Cart();
		cart.setProductId(12);
		cart.setProductName("R2");
		cart.setQuantity(2);
		cart.setPrice(25000);
		cart.setStatus("NP");
		cart.setUsername("Yang");
		
		
		assertTrue("Problem in adding item to cart",cartDAO.addToCart(cart));
	}
	
	@Ignore
	@Test
	public void updateCartItemTest()
	{
		Cart cart= cartDAO.getCartItem(1);
		cart.setQuantity(2);
		
		assertTrue("Problem in updating cart Item", cartDAO.updateCartItem(cart));
		
	}
	
	@Ignore
	@Test
	public void deleteCartItemTest()
	{
		Cart cart=cartDAO.getCartItem(2);
		assertTrue("Problem in Deleting cart Item", cartDAO.deleteItemFromCart(cart));
	}
	
	
	@Test
	public void listCartItemTest()
	{
		List<Cart> cartItemList = cartDAO.listCartItems("Yang");
		
		assertTrue("Problem in Listing CartItems", cartItemList.size() > 0);
		
		for(Cart cart:cartItemList)
		{
			System.out.println(cart.getCartItemId() + ": :");
			System.out.println(cart.getProductName() + ": :");
			System.out.println(cart.getQuantity() + ": :");
		}
	}

}
