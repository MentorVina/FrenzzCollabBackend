package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.UserDAO;
import com.niit.Model.Blog;
import com.niit.Model.User;

public class UserUpdateTest {

	
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
	public void testUpdateUser() 
	{
		User user = new User();
		user=(User)userDAO.getUser("Pranali");
		 user.setEmail("pranali@yahoo.com");
		 assertEquals("sucessfully updated into table" ,true,userDAO.updateUser(user));
	}
}
