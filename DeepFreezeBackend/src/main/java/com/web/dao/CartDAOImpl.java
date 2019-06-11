package com.web.dao;

import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.model.Cart;
/*DAO - Data access object is an object/interface that provides access to an underlying database or any other persistent storage.*/

/*DAO classes is the one where we write methods to perform operations over Database.*/

/* @Repository - used to import the "cartDAO" into the DI container.*/
/*This is also to indicate that the class defines a data repository.*/
/*@Repository - used so that any platform-specific exceptions are caught and then re-thrown as one of Spring’s unchecked data access exceptions.*/


/*@Transactional - the boundary of transaction starts and boundary ends when method completes.*/
/*Using @Transactional - Any exception will result in rollback of all JPA transactions with DB. Internally JPA transaction are used by Spring.*/

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {
	
	/*@Autowired - used to auto wire "sessionFactory" bean from spring container.This enables us to inject the object dependency implicitly during runtime.*/
	@Autowired
	SessionFactory sessionFactory;

	public boolean addToCart(Cart cart) {
		try {
			
			List<Cart> cartItemList =this.listCartItems(cart.getUsername());
			if(cartItemList.size() > 0)
			{
				int count=0,flag=0;
				while(count<cartItemList.size())
				{
					if(cartItemList.get(count).getProdId() == cart.getProdId())
					{
						Cart cart1=cartItemList.get(count);
						cart1.setQuantity(cart1.getQuantity() + cart.getQuantity());
						this.updateCartItem(cart1);
						return true;
					}
					count++;
				}
			}
			

			sessionFactory.getCurrentSession().save(cart);
			return true;
		} 
		catch (Exception e) {

			System.out.println("Add cart Exception:" + e);
			return false;
		}
	}

	public boolean deleteItemFromCart(Cart cart) 
	{
		try {

			sessionFactory.getCurrentSession().delete(cart);
			return true;
		} 
		catch (Exception e) {

			System.out.println("Delete cart Exception:" + e);
			return false;
		}
	}

	public boolean updateCartItem(Cart cart) 
	{
		try {

			sessionFactory.getCurrentSession().update(cart);
			return true;
		} 
		catch (Exception e) {

			System.out.println("Update cart Exception:" + e);
			return false;
		}
	}

	public Cart getCartItem(int cartId)
	{
		Session session=sessionFactory.openSession();
		Cart cart=session.get(Cart.class,cartId);
		session.close();
		return cart;
	}

	public List<Cart> listCartItems(String username)
	{
		Session session=sessionFactory.openSession();
		Query query= session.createQuery("from Cart where username=:uname and status='NP'");
		query.setParameter("uname", username);
		List<Cart> cartListItems = query.list();
		session.close();
		
		return cartListItems;
	}

	/*can use @Autowired annotation to auto wire spring bean on setter method, instance variable, and constructor. 
	 * If you use @Autowired annotation, spring container auto-wires the bean by matching data type.*/
	
	/* For target beans annotated with @Transactional, Spring will create a TransactionInterceptor, and pass it to the generated proxy object.*/
	/*When the invocation finishes, the TransactionInterceptor commits/rolls back the transaction*/
}
