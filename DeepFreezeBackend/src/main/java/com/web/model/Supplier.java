package com.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/*@Entity annotation defines that a class can be mapped to a table.*/

@Entity
public class Supplier {
	
	
	/*@Id marks a field in a model class as the primary key*/
	/*@GeneratedValue(strategy = GenerationType.IDENTITY) - It relies on an auto-incremented database column and lets the database generate a new value with each insert operation.*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supId;
	
	/*@NotNull constraint won’t allow null values for the constrained field*/
	@NotNull
	private String supName;
	
	@NotNull
	private String supAddr;

	/*Getter and Setter methods for accessing the feilds*/
	public int getSupId() {
		return supId;
	}

	public void setSupId(int supId) {
		this.supId = supId;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getSupAddr() {
		return supAddr;
	}

	public void setSupAddr(String supAddr) {
		this.supAddr = supAddr;
	}

}

