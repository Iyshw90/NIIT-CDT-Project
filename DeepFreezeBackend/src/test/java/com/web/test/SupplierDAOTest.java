package com.web.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.web.dao.SupplierDAO;
import com.web.model.Supplier;

public class SupplierDAOTest {

	static SupplierDAO supplierDAO;

	/*@Beforeclass - annotation is used if you want to execute some statements before all the test cases .Also this method should be static and it has to be executed before the class.*/
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.web");
		context.refresh();
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	}
	
	/*@Test - annotation is a replacement of org.junit.TestCase which indicates that public void method to which it is attached can be executed as a test Case.*/
	/*"assertTrue()" functionality is to check that a condition given is true or not.*/
	
	/*addSupplierTest() - For testing insertion operation into Supplier Table*/
	@Test
	public void addSupplierTest() {
		Supplier supplier = new Supplier();
		supplier.setSupName("Basics");
		supplier.setSupAddr("T.nagar");
		
		assertTrue("Problem in adding Supplier", supplierDAO.addSupplier(supplier));
		
	}
	
	/*@Ignore - annotation can be used if you want to ignore some statements during test execution for e.g. disabling some test cases during test execution.*/
	/*deleteSupplierTest() - For testing the delete operation into Supplier Table */
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier = supplierDAO.getSupplier(2);
		assertTrue("Problem in deleting Supplier", supplierDAO.deleteSupplier(supplier));
	}

	
	/*updateSupplierTest() - For testing the update operation into Supplier Table */
	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier = supplierDAO.getSupplier(1);
		supplier.setSupAddr("Nungambakkam");
		
		assertTrue("Problem in updating Supplier", supplierDAO.updateSupplier(supplier));
		
	}
	
	/*listSupplier() - For listing all the items from the Supplier Table*/
	@Test
	public void listSupplier()
	{
		List<Supplier> supplierList = supplierDAO.listSupplier();
		assertTrue("Problem in Listing Supplier", supplierList.size() > 0);
		
		for(Supplier supplier : supplierList)
		{
			System.out.println("Supplier Id:"+supplier.getSupId());
			System.out.println("Supplier Name :"+supplier.getSupName());
			System.out.println("Supplier Addr:"+supplier.getSupAddr());
			
		}
	}

}
