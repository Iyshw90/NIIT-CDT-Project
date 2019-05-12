package com.web.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.web.dao.CategoryDAO;
import com.web.model.Category;

public class CategoryDAOTest {

	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.web");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	
	@Test
	public void addCategoryTest() {
		Category category = new Category();
		category.setCatName("T-shirt");
		category.setCatDesc("Round neck shirt");
		
		
		assertTrue("Problem in adding category", categoryDAO.addCategory(category));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category = categoryDAO.getCategory(1);
		assertTrue("Problem in deleting category", categoryDAO.deleteCategory(category));
	}
	
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category = categoryDAO.getCategory(1);
		category.setCatName("Normal shirt");
		assertTrue("Problem in deleting category", categoryDAO.updateCategory(category));
	}

	
	
	@Test
	public void listCategory()
	{
		List<Category> categoryList = categoryDAO.listCategory();
		
		assertTrue("Problem in listing category", categoryList.size() > 0);
		
		for(Category category : categoryList)
		{
			System.out.println("Category ID:"+category.getCatId());
			System.out.println("Category Name:" +category.getCatName());
			System.out.println("Category Desc :" +category.getCatDesc());
			
		}
	}

}
