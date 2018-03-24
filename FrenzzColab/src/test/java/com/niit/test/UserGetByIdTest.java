package com.niit.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.UserDAO;
import com.niit.Model.Blog;
import com.niit.Model.User;

public class UserGetByIdTest {
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
	public void testGetUserById() 
	{
		
		User user = new User();
		 user=(User)userDAO.getUser(22);
		 System.out.println("ID: "+user.getUserId()+ ",UserName: " +user.getfName()+ ",Age: " +user.getAge()+ ",Email: " +user.getEmail());
	}

}
