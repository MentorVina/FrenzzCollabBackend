package com.niit.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;

import com.niit.DAO.BlogDAO;

import com.niit.Model.BlogComment;

public class BlogGetCommentByIdTest {
	private static DBConfig config;
	@Autowired
	private static BlogDAO blogDAO;

	@BeforeClass
	public static void setUp() {
		config = new DBConfig();
		//blogDAO = new BlogDAOImpl(config.getSessionFactory(config.getDataSource()));
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		blogDAO =(BlogDAO) context.getBean("blogDAO");
	}
		@Test
		public void testGetByIdBlogComment() 
		{
			BlogComment blogComment	 = new BlogComment();

			blogComment	=(BlogComment)blogDAO.getBlogComment(3);
			 
			 System.out.println("ID: "+blogComment.getBlogId()+ ",UserName: " +blogComment.getUsername()+ ", Comments:"+blogComment.getCommentText());
		}
		
}


