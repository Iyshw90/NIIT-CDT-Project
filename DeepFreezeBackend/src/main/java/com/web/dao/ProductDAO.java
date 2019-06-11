package com.web.dao;

import com.web.model.Product;
import java.util.List;

/*ProductDAO Interface - Blueprint of "ProductDAOImpl" class for implementing total abstraction,also used to achieve multiple inheritance*/
public interface ProductDAO {
	
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public Product getProduct(int productId);
	public List<Product> getProductListCategoryWise(int categoryId);
	public List<Product> listProduct();
	
	    

}

