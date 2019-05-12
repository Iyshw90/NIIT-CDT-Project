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

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.web");
		context.refresh();
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	}
	
	
	@Test
	public void addSupplierTest() {
		Supplier supplier = new Supplier();
		supplier.setSupName("Basics");
		supplier.setSupAddr("T.nagar");
		
		assertTrue("Problem in adding Supplier", supplierDAO.addSupplier(supplier));
		
	}
	
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier = supplierDAO.getSupplier(2);
		assertTrue("Problem in deleting Supplier", supplierDAO.deleteSupplier(supplier));
	}

	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier = supplierDAO.getSupplier(1);
		supplier.setSupAddr("Nungambakkam");
		
		assertTrue("Problem in updating Supplier", supplierDAO.updateSupplier(supplier));
		
	}
	
	
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
