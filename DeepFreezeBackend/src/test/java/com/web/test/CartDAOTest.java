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
	
	/*@Beforeclass - annotation is used if you want to execute some statements before all the test cases .Also this method should be static and it has to be executed before the class.*/
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.web");
		context.refresh();
		
		cartDAO = (CartDAO) context.getBean("cartDAO");
	}

	
	/*@Test - annotation is a replacement of org.junit.TestCase which indicates that public void method to which it is attached can be executed as a test Case.*/
	/*"assertTrue()" functionality is to check that a condition given is true or not.*/
	/*addToCartTest() - For testing insertion operation into Cart Table*/
	@Test
	public void addToCartTest() {
		Cart cart= new Cart();
		cart.setProdId(12);
		cart.setProductName("R2");
		cart.setQuantity(2);
		cart.setPrice(25000);
		cart.setStatus("NP");
		cart.setUsername("Yang");
		
		
		assertTrue("Problem in adding item to cart",cartDAO.addToCart(cart));
	}
	
	/*@Ignore - annotation can be used if you want to ignore some statements during test execution for e.g. disabling some test cases during test execution.*/
	/*updateCartItemTest() - For testing the update operation into Cart Table */
	@Ignore
	@Test
	public void updateCartItemTest()
	{
		Cart cart= cartDAO.getCartItem(1);
		cart.setQuantity(2);
		
		assertTrue("Problem in updating cart Item", cartDAO.updateCartItem(cart));
		
	}
	
	/*deleteCartItemTest() - For testing the delete operation into Cart Table*/
	@Ignore
	@Test
	public void deleteCartItemTest()
	{
		Cart cart=cartDAO.getCartItem(2);
		assertTrue("Problem in Deleting cart Item", cartDAO.deleteItemFromCart(cart));
	}
	
	
	/*listCartItemTest() - For listing all the items from the Cart Table*/
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
