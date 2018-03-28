package com.niit.test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.ForumDAO;
import com.niit.Model.Forum;

public class ForumInsertTest {
	
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
	public void testInsertForum()  {
		  Forum forum = new Forum();

		forum.setForumName("test1");
		forum.setForumContent("Regarding exam");
	    forum.setCreateDate(new java.util.Date());
		forum.setUsername("Karina");
		forum.setStatus("A");
		
	   assertTrue("Data inserted in forum table",forumDAO.addForum(forum));
		
}
}
