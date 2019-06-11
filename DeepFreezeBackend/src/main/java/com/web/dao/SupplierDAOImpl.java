package com.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.model.Supplier;

/*DAO - Data access object is an object/interface that provides access to an underlying database or any other persistent storage.*/

/* @Repository - used to import the "supplierDAO" into the DI container.*/
/*This is also to indicate that the class defines a data repository.*/

/*@Transactional - the boundary of transaction starts and boundary ends when method completes.*/

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO{
	
	/*@Autowired - used to auto wire "sessionFactory" bean from spring container.This enables us to inject the object dependency implicitly during runtime.*/
	@Autowired
	SessionFactory sessionFactory;

	public boolean addSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
			return false;
		}
	}

	public boolean deleteSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
			return false;
		}
	}

	public boolean updateSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
			return false;
		}
	}

	public Supplier getSupplier(int supplierId) {
		Session session = sessionFactory.openSession();
		Supplier supplier = session.get(Supplier.class, supplierId);
		session.close();
		return supplier;
	}

	public List<Supplier> listSupplier() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Supplier");
		List<Supplier> supplierList = query.list();
		return supplierList;
	}

}
