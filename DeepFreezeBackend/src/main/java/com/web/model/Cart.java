package com.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/*@Entity annotation defines that a class can be mapped to a table.*/

@Entity
public class Cart {
	
	/*@Id marks a field in a model class as the primary key*/
	/*@GeneratedValue(strategy = GenerationType.IDENTITY) - It relies on an auto-incremented database column and lets the database generate a new value with each insert operation.*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItemId;
	
	private int orderId;
	
	private String username;
	
	private int prodId;
	
	private String productName;
	
	private int quantity;
	
	private int price;
	
	private String status;

	/*Getter and Setter methods for accessing the feilds*/
	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int productId) {
		this.prodId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
