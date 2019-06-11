package com.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

/*@Entity annotation defines that a class can be mapped to a table.*/

@Entity
public class Product {

	/*@Id marks a field in a model class as the primary key*/
	/*@GeneratedValue(strategy = GenerationType.IDENTITY) - It relies on an auto-incremented database column and lets the database generate a new value with each insert operation.*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prodId;
	
	/*@NotNull constraint won’t allow null values for the constrained field*/
	@NotNull
	private String prodName;
	
	/*@Transient - annotation used to mark a field in a model class as transient. Hence the data store engine won’t read or write this field’s value*/
	@Transient 
	MultipartFile pimage;
	
	@NotNull
	private String prodDesc;
	
	
	@NotNull @Min(5) @Max(150)
	private int stock;
	
	
	@NotNull @Min(7000) @Max(80000)
	private int price;
	
	
	@NotNull @Min(1)
	private int catId;
	
	
	@NotNull @Min(1)
	private int supId;
	
	
	/*Getter and Setter methods for accessing the feilds*/
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public int getSupId() {
		return supId;
	}
	public void setSupId(int supId) {
		this.supId = supId;
	}
	
	public MultipartFile getPimage() {
		return pimage;
	}
	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}
	

}

