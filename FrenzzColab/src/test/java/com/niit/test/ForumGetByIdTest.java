package com.niit.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.ForumDAO;
import com.niit.Model.Forum;

public class ForumGetByIdTest {
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
	public void testGetByIdForum() {
		
		Forum forum= new Forum();
		forum=(Forum)forumDAO.getForum(1);
		 System.out.println("ID: "+forum.getForumId()+ ",UserName: " +forum.getUsername());
	}

}
