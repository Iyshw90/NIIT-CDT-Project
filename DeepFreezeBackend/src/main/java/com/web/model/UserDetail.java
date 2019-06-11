package com.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

/*@Entity annotation defines that a class can be mapped to a table.*/

@Entity
public class UserDetail {
	
	/*@Id marks a field in a model class as the primary key*/
	@Id @NotNull
	private String username;
	
	/*@NotNull constraint won’t allow null values for the constrained field*/
	@NotNull
	private String password;
	
	@NotNull
	private String address;
	
	@NotNull
	private boolean enabled;
	
	@NotNull @Email
	private String email;
	
	@NotNull
	private String role;
	
	@NotNull
	private String customerName;
	
	/*Getter and Setter methods for accessing the feilds*/
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	

}
