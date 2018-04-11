package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.FriendDAO;

public class FriendAcceptRequestTest {
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
		public void FriendAcceptRequesttest()
		{
                assertTrue("friend request accepted",friendDAO.acceptFriendRequest(11));
		}
}
