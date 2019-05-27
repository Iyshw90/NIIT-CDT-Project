package com.web.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.web.dao.ProductDAO;
import com.web.model.Product;

public class ProductDAOTest {
	
	static ProductDAO productDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.web");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	
	@Test
	public void addProductTest() {
		Product product = new Product();
		product.setProdName("Pants");
		product.setPrice(3000);
		product.setProdDesc("Women");
		product.setStock(50);
		product.setCatId(2);
		product.setSupId(2);
		
		assertTrue("Problem in adding product", productDAO.addProduct(product));
		
	}
	
	
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product = productDAO.getProduct(1);
		assertTrue("Problem in deleting product", productDAO.deleteProduct(product));
	}
	
	
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product = productDAO.getProduct(2);
		product.setPrice(9000);
		assertTrue("Problem in updating product", productDAO.updateProduct(product));
		
	}
	
	@Ignore
	@Test
	public void showProductListCategoryWise()
	{
		List<Product> productList = productDAO.getProductListCategoryWise(1);
		assertTrue("Problem in Listing Product", productList.size() > 0);
		
		for(Product product : productList)
		{
			System.out.println("Product Name:"+product.getProdName());
			System.out.println("Product Id :"+product.getProdId());
			System.out.println("Product Desc:"+product.getProdDesc());
			System.out.println("Product Price:"+product.getPrice());
			System.out.println("Product Stock:"+product.getStock());
			System.out.println("Category ID :"+product.getCatId());
			System.out.println("Supplier ID:"+product.getSupId());
		}
		
	}
		
	
	@Ignore
	@Test
	public void listProduct()
	{
		List<Product> productList = productDAO.listProduct();
		assertTrue("Problem in Listing Product", productList.size() > 0);
		
		for(Product product : productList)
		{
			System.out.println("Product Name:"+product.getProdName());
			System.out.println("Product Id :"+product.getProdId());
			System.out.println("Product Desc:"+product.getProdDesc());
			System.out.println("Product Price:"+product.getPrice());
			System.out.println("Product Stock:"+product.getStock());
			System.out.println("Category ID :"+product.getCatId());
			System.out.println("Supplier ID:"+product.getSupId());
		}
	}

}
