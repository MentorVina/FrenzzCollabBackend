package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;

import com.niit.DAO.BlogDAO;
import com.niit.Model.Blog;
import com.niit.Model.BlogComment;

public class BlogDeleteCommentTest {
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
	public void testDeleteBlogComment() {
		
		
		BlogComment blogComment	 = new BlogComment();
		
		blogComment=(BlogComment)blogDAO.getBlogComment(2);
		 assertEquals("sucessfully deleted from table" ,true,blogDAO.deleteBlogComment(blogComment));
		
	}

}
