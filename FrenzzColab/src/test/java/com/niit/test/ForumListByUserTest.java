package com.niit.test;

import static org.junit.Assert.assertTrue;


import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.ForumDAO;

import com.niit.Model.Forum;

public class ForumListByUserTest {

	private static DBConfig config;
	private static ForumDAO forumDAO;

	@BeforeClass
	public static void setUp() {
		config = new DBConfig();
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		forumDAO =(ForumDAO) context.getBean("forumDAO");
	}

	@Test
	public void testListByUserForum() {
        Forum forum = new Forum();
		
		List<Forum> listForums= forumDAO.listForum();
		assertTrue("List of Forum data display",listForums.size()>0);
		
		for(Forum forums:listForums)
		{
			System.out.println(forums.getForumId()+"::");
			System.out.println(forums.getForumName()+"::");
			System.out.println(forums.getForumContent()+"::");
			System.out.println(forums.getStatus()+"::");
			System.out.println(forums.getUsername()+"::");
			
		}
	}
	
}

