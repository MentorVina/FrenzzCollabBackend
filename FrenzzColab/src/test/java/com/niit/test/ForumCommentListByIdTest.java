package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.ForumDAO;

import com.niit.Model.ForumComment;

public class ForumCommentListByIdTest {
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
	public void testForumCommentList() {
		
		  ForumComment forumComment = new ForumComment();
			
			List<ForumComment> listForumComments= forumDAO.listForumComment(41);
			assertTrue("List of ForumComment data display",listForumComments.size()>0);
			
			for(ForumComment forumcomment:listForumComments)
			{
				System.out.println(forumcomment.getCommentId()+"::");
				System.out.println(forumcomment.getCommentText()+"::");
				System.out.println(forumcomment.getForumId()+"::");
				System.out.println(forumcomment.getUserName()+"::");
				
				
			}
		}
	}


