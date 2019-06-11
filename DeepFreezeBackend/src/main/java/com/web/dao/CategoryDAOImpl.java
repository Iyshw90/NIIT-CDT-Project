package com.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.model.Category;

/* @Repository - used to import the "categoryDAO" into the DI container.*/
/*This is also to indicate that the class defines a data repository.*/

/*DAO - Data access object is an object/interface that provides access to an underlying database or any other persistent storage.*/

/*@Transactional - the boundary of transaction starts and boundary ends when method completes.*/

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO{
	

	/*@Autowired - used to auto wire "sessionFactory" bean from spring container.This enables us to inject the object dependency implicitly during runtime.*/
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addCategory(Category category) {
		try {
			
			sessionFactory.getCurrentSession().save(category);
			
			return true;
		}
		catch(Exception e)
		{
			
			System.out.println("Add Category Exception:"+e);
			return false;
		}
	}

	public boolean deleteCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Delete Category Exception:"+e);
			return false;
		}
	}

	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Update Category Exception:"+e);
			return false;
		}
	}

	public Category getCategory(int categoryId) {
		Session session = sessionFactory.openSession();
		Category category = session.get(Category.class, categoryId);
		session.close();
		return category;
	}

	public List<Category> listCategory() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Category");
		List<Category> categoryList = query.list();
		return categoryList;
	}

}
