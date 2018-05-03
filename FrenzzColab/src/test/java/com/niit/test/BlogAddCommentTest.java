package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;

import com.niit.DAO.BlogDAO;

import com.niit.Model.BlogComment;

public class BlogAddCommentTest {

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
	public void testAddBlogComment() {
		
		
	BlogComment blogComment	 = new BlogComment();

		blogComment.setCommentDate(new java.util.Date());
	    blogComment.setBlogId(25);
	    blogComment.setCommentText("Truly said");
	    blogComment.setUsername("Vinay");
	    
	assertTrue("Data inserted in blogComment table",blogDAO.addBlogComment(blogComment));
		
	}
}
