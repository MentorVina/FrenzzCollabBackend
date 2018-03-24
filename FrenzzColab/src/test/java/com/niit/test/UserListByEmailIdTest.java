package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.UserDAO;
import com.niit.Model.Blog;
import com.niit.Model.User;

public class UserListByEmailIdTest {
	
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
		
		List<User> listUsers=userDAO.listUser("chetan@yahoo.com");
		assertTrue("List of user data display",listUsers.size()>0);
		
		for(User users:listUsers)
		{
			System.out.println(users.getUserId()+"::");
			System.out.println(users.getfName()+"::");
			System.out.println(users.getEmail()+"::");
			System.out.println(users.getGender()+"::");
			System.out.println(users.getDob()+"::");
			
		}

}
}
