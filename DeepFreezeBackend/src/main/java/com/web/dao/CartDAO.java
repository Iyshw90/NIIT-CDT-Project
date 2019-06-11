package com.web.dao;

import java.util.List;

import com.web.model.Cart;

/*CartDAO Interface - Blueprint of "CartDAOImpl" class for implementing total abstraction,also used to achieve multiple inheritance*/
public interface CartDAO {
	
	public boolean addToCart(Cart cart);
	public boolean deleteItemFromCart(Cart cart);
	public boolean updateCartItem(Cart cart);
	public Cart getCartItem(int cartId);
	public List<Cart> listCartItems(String username);

}
