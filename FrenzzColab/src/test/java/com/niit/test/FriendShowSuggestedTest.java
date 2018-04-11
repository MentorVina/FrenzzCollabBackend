package com.niit.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.FriendDAO;
import com.niit.Model.User;

public class FriendShowSuggestedTest {
	private static DBConfig config;
	@Autowired
	private static FriendDAO friendDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		friendDAO=(FriendDAO)context.getBean("friendDAO");
	}
		
		@Test
		public void FriendShowSuggestedtest()
		
		{
			List<User> suggestFriend=friendDAO.showSuggestedFriend("Pranali");
			assertNotNull("Problem found null pointer",suggestFriend);
			
			for(User user:suggestFriend)
			{
				System.out.println(user.getLoginName());
			}
		}
		

}
