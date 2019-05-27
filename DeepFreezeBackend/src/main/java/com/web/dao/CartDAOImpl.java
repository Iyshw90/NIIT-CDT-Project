package com.web.dao;

import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.model.Cart;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {
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
					if(cartItemList.get(count).getProductId() == cart.getProductId())
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

}
