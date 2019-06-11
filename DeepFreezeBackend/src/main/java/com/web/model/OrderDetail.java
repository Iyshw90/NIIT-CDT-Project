package com.web.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*@Entity annotation defines that a class can be mapped to a table.*/

@Entity
public class OrderDetail {
	
	/*@Id marks a field in a model class as the primary key*/
	/*@GeneratedValue(strategy = GenerationType.IDENTITY) - It relies on an auto-incremented database column and lets the database generate a new value with each insert operation.*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String userName;
	private Date  orderDate;
	private int shopingAmount;
	private String pmode;
	
	/*Getter and Setter methods for accessing the feilds*/
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getShopingAmount() {
		return shopingAmount;
	}
	public void setShopingAmount(int shopingAmount) {
		this.shopingAmount = shopingAmount;
	}
	public String getPmode() {
		return pmode;
	}
	public void setPmode(String pmode) {
		this.pmode = pmode;
	}
	
	
}
