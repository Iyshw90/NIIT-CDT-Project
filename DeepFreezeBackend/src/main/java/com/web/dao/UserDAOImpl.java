package com.web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.model.UserDetail;

@Repository("userDetailDAO")
@Transactional
public class UserDAOImpl implements UserDAO{
	
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
