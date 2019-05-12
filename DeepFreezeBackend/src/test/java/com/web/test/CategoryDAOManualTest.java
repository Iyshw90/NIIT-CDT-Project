package com.web.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.web.dao.CategoryDAOImpl;
import com.web.model.Category;

public class CategoryDAOManualTest {
	public static void main(String args[])
	{
		//initiates the class which has @configuration annotation and runs it.
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//scans this base pacakage and complies all the java files in it.
		context.scan("com.web");
		context.refresh();
		
  CategoryDAOImpl categoryDAO = (CategoryDAOImpl)context.getBean("categoryDAO");
		
		Category category = new Category();
		//Category cat=categoryDAO.getCategory(1);
		//System.out.println("Cat Name :" + cat.getCatNmae());
		category.setCatId(2);
		category.setCatName("category1");
		category.setCatDesc("This is category1");
		categoryDAO.addCategory(category);
		System.out.println(">>>>>>>>>>>>.category added>>>>>>>>>>>>>>>>>>>>>>>>");
		
		
	}
	

}
