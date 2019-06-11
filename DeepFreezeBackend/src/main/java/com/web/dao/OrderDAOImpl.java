package com.web.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.model.OrderDetail;

/*DAO - Data access object is an object/interface that provides access to an underlying database or any other persistent storage.*/

/* @Repository - used to import the "orderDAO" into the DI container.*/
/*This is also to indicate that the class defines a data repository.*/

/*@Transactional - the boundary of transaction starts and boundary ends when method completes.*/

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO {
	
	/*@Autowired - used to auto wire "sessionFactory" bean from spring container.This enables us to inject the object dependency implicitly during runtime.*/
	@Autowired
	SessionFactory sessionFactory;

	public boolean paymentProcess(OrderDetail orderDetail) {
		try 
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e);
			return false;
		}
		
	}

	public boolean updateCartItemStatus(String userName, int orderId) {
		try
		{
			System.out.println(orderId);
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("update Cart set status='P',orderId=:ordid where username=:uname and status='NP'");
			query.setParameter("ordid", orderId);
			query.setParameter("uname", userName);
			int row_eff =query.executeUpdate();
						
			if(row_eff > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e);
			return false;
		}
	}

}
