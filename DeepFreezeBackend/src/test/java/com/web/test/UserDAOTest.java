package com.web.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.web.dao.UserDAO;
import com.web.model.UserDetail;

public class UserDAOTest {

static UserDAO userDetailDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.web");
		context.refresh();
		userDetailDAO = (UserDAO) context.getBean("userDetailDAO");
	}
	
	@Test
	public void addUserTest() {
		UserDetail user = new UserDetail();
		user.setUserName("Yang");
		user.setEmail("yang90@outlook.com");
		user.setPassword("1090");
		user.setRole("ROLE_ADMIN");
		user.setAddress("Galapagos");
		user.setCustomerName("Yang Yang");
		user.setEnabled(true);
				
		assertTrue("Problem in adding User", userDetailDAO.addUser(user));
		
	}
	
	@Ignore
	@Test
	public void updateUserTest()
	{
		UserDetail user = userDetailDAO.getUser("Iyshw");
		user.setAddress("Chennai");
		user.setEmail("iyshwaryaah90@hotmail.com");
		
		assertTrue("Problem in updating user", userDetailDAO.updateUser(user));
		
	}
	
	
	

}
