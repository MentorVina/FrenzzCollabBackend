package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.ForumDAO;
import com.niit.Model.Forum;

public class ForumRejectTest {
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
	public void testApproveForum() 
	{
		Forum forum= new Forum();
		 forum=(Forum)forumDAO.getForum(3);
		 forum.setStatus("NA");
		 assertEquals("sucessfully updated status from table" ,true,forumDAO.rejectForum(forum));
		
	}

}
