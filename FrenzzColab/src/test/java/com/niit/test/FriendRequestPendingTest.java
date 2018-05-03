package com.niit.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.FriendDAO;
import com.niit.Model.Friend;

public class FriendRequestPendingTest {
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
		public void FriendRequestPendingtest()
		{
		
			List<Friend> listFriendPending=friendDAO.showRequestPendingList("Pranali");
			assertNotNull("Problem found null pointer",listFriendPending);
			for(Friend friend:listFriendPending)
			{
				System.out.println(friend.getLoginName()+":::"+friend.getFriendloginName());
			}
			
		}

}
