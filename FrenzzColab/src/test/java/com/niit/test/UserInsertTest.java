package com.niit.test;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		user.setUserName(" Prama  Singh");
		user.setLoginName("Param");
		user.setAddress("54,Dharampeth");
		user.setAge(32);
		user.setContactNo("7895641236");
		user.setDob(new java.util.Date());
		user.setEmail("param@gmail.com");
		user.setGender("Male");
		user.setIsOnline("N");
		user.setPass("pass12345");
		user.setRole("ROLEADMIN");
		
		//System.out.println(userDAO.addUser(user));
		assertTrue("Data inserted in users table",userDAO.addUser(user));

	}

}
