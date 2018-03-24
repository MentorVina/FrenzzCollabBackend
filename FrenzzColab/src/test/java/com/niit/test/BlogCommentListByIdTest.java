package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.BlogDAO;
import com.niit.Model.Blog;
import com.niit.Model.BlogComment;

public class BlogCommentListByIdTest {
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
	public void testGetBlogCommentListById() 
	{
		BlogComment blogComment	 = new BlogComment();
		List<BlogComment> listBlogcomment=blogDAO.listBlogComment(25);
		assertTrue("List of blogComment data display",listBlogcomment.size()>0);
		for(BlogComment blogComments:listBlogcomment)
		{
			System.out.println(blogComments.getCommentId()+"::");
			System.out.println(blogComments.getCommentText()+"::");
			System.out.println(blogComments.getUsername()+"::");
		
			
		}
		
	}

}
