package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.UserDAO;
import com.niit.Model.User;

public class UpdateOnlineStatusTest {
	private static DBConfig config;
	@Autowired
	private static UserDAO userDAO;

	@BeforeClass
	public static void setUp() {
		config = new DBConfig();
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
	userDAO =(UserDAO) context.getBean("userDAO");
	}
	@Test
	public void testupdateOnlineStatusTest() 
	{
		User user=userDAO.getUser("Pranali");
		System.out.println(userDAO.updateOnlineStatus("Y", user));
	    assertTrue("Status Updated",userDAO.updateOnlineStatus("Y", user));
		
	}

}
