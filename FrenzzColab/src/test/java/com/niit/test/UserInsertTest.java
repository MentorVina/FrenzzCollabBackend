package com.niit.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public void testInsertUser() throws ParseException {
		String dt="04/03/2001";
		Date dobj=new SimpleDateFormat("dd/mm/yyyy").parse(dt);
			
		User user = new User();

		user.setfName("Aditi");
		user.setlName("Varma");
		user.setAge(24);
		user.setContactNo("1235647895");
		user.setDob(dobj);
		user.setGender("female");
		user.setEmail("aditi@gmail.com");
		user.setPass("1234");
		userDAO.addUser(user);
		System.out.println("Done Boss");

	}

}
