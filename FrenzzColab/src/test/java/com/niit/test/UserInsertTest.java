package com.niit.test;


import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.UserDAO;
import com.niit.Model.User;

public class UserInsertTest {

	
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
	public void testInsertUser() 
	{
		
			
		User user = new User();

		user.setfName("Chetan");
		user.setlName("Shirke");
		user.setAge(27);
		user.setContactNo("78956423589");
		user.setDob(new java.util.Date());
		user.setGender("Male");
		user.setEmail("chetan@gmail.com");
		user.setPass("6789");
		userDAO.addUser(user);
		System.out.println("Data inserted in users table");

	}

}
