package com.web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.model.UserDetail;

/*DAO - Data access object is an object/interface that provides access to an underlying database or any other persistent storage.*/

/* @Repository - used to import the "userDetailDAO" into the DI container.*/
/*This is also to indicate that the class defines a data repository.*/

/*@Transactional - the boundary of transaction starts and boundary ends when method completes.*/

@Repository("userDetailDAO")
@Transactional
public class UserDAOImpl implements UserDAO{
	
	/*@Autowired - used to auto wire "sessionFactory" bean from spring container.This enables us to inject the object dependency implicitly during runtime.*/
	@Autowired
	SessionFactory sessionFactory;


	public boolean addUser(UserDetail user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
			return false;
		}
	}

	public boolean updateUser(UserDetail user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
			return false;
		}
	}

	public UserDetail getUser(String userName) {
		Session session = sessionFactory.openSession();
		UserDetail user = session.get(UserDetail.class, userName);
		session.close();
		return user;
	}

}
