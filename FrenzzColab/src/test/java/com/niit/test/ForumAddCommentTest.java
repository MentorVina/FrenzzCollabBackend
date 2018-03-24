package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.ForumDAO;
import com.niit.Model.ForumComment;

public class ForumAddCommentTest {

	
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
	public void testAddForumComment(){
		  ForumComment forumComment = new ForumComment();



		    forumComment.setCommentDate(new java.util.Date());
			forumComment.setCommentText("best idea");
			forumComment.setForumId(23);
			forumComment.setUserName("Ram");
			
		   assertTrue("Data inserted in forumComment table",forumDAO.addForumComment(forumComment));
		
	}
}
