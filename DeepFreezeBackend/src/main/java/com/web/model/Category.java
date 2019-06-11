package com.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/*@Entity annotation defines that a class can be mapped to a table.*/
@Entity
public class Category {

	/*@Id marks a field in a model class as the primary key*/
	/*@GeneratedValue(strategy = GenerationType.IDENTITY) - It relies on an auto-incremented database column and lets the database generate a new value with each insert operation.*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catId;
	
	/*@NotNull constraint won’t allow null values for the constrained field*/
	@NotNull
	private String catName;
	
	@NotNull
	private String catDesc;

	
	/*Getter and Setter methods for accessing the feilds*/
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	public String getCatDesc() {
		return catDesc;
	}
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

}

