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

	/*@Beforeclass - annotation is used if you want to execute some statements before all the test cases .Also this method should be static and it has to be executed before the class.*/
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.web");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	
	/*@Test - annotation is a replacement of org.junit.TestCase which indicates that public void method to which it is attached can be executed as a test Case.*/
	/*"assertTrue()" functionality is to check that a condition given is true or not.*/
	/*addCategoryTest() - For testing insertion operation into Category Table*/
	@Test
	public void addCategoryTest() {
		Category category = new Category();
		category.setCatName("T-shirt");
		category.setCatDesc("Round neck shirt");
		
		
		assertTrue("Problem in adding category", categoryDAO.addCategory(category));
	}
	
	
	/*@Ignore - annotation can be used if you want to ignore some statements during test execution for e.g. disabling some test cases during test execution.*/
	/*deleteCategoryTest() - For testing the delete operation into Category Table */
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category = categoryDAO.getCategory(1);
		assertTrue("Problem in deleting category", categoryDAO.deleteCategory(category));
	}
	
	/*updateCategoryTest() - For testing the update operation into Category Table */
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category = categoryDAO.getCategory(1);
		category.setCatName("Normal shirt");
		assertTrue("Problem in deleting category", categoryDAO.updateCategory(category));
	}

	
	/*listCategory() - For listing all the items from the Category Table*/
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
