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
	
	/*@Beforeclass - annotation is used if you want to execute some statements before all the test cases .Also this method should be static and it has to be executed before the class.*/
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.web");
		context.refresh();
		userDetailDAO = (UserDAO) context.getBean("userDetailDAO");
	}
	
	/*@Test - annotation is a replacement of org.junit.TestCase which indicates that public void method to which it is attached can be executed as a test Case.*/
	/*"assertTrue()" functionality is to check that a condition given is true or not.*/
	/*addUserTest() - For testing insertion operation into User Table*/
	@Ignore
	@Test
	public void addUserTest() {
		UserDetail user = new UserDetail();
		user.setUserName("Yang");
		user.setEmail("yang90@outlook.com");
		user.setPassword("1090");
		user.setRole("ROLE_ADMIN");
		user.setAddress("Galapagos");
		user.setCustomername("Yang Yang");
		user.setEnabled(true);
				
		assertTrue("Problem in adding User", userDetailDAO.addUser(user));
		
	}
	
	/*@Ignore - annotation can be used if you want to ignore some statements during test execution for e.g. disabling some test cases during test execution.*/
	/*updateUserTest() - For testing the update operation into User Table */
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
