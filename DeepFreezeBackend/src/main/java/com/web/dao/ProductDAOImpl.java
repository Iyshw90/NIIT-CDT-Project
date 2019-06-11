package com.web.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.model.Product;

/*DAO - Data access object is an object/interface that provides access to an underlying database or any other persistent storage.*/

/* @Repository - used to import the "productDAO" into the DI container.*/
/*This is also to indicate that the class defines a data repository.*/

/*@Transactional - the boundary of transaction starts and boundary ends when method completes.*/

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{
	
	/*@Autowired - used to auto wire "sessionFactory" bean from spring container.This enables us to inject the object dependency implicitly during runtime.*/
	@Autowired
	SessionFactory sessionFactory;

	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} 
		catch (Exception e) 
		{
			System.out.println("Exception:"+e);
			return false;

		}
	}

	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} 
		catch (Exception e)
		{
			System.out.println("Exception:"+e);
			return false;

		}
	}

	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch (Exception e)
		{
			System.out.println("Exception:"+e);
			return false;

		}
	}

	public Product getProduct(int productId) {
		Session session = sessionFactory.openSession();
		Product product = session.get(Product.class, productId);
		session.close();
		return product;
	}
	
	public List<Product>  getProductListCategoryWise(int categoryId)
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product where catId =: catId");
		query.setParameter("catId", categoryId);
		List<Product> productList = query.list();
		return productList;
	}

	public List<Product> listProduct() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		List<Product> productList = query.list();
		return productList;
	}

}
