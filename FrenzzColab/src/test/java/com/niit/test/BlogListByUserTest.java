package com.niit.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.BlogDAO;
import com.niit.Model.Blog;

public class BlogListByUserTest {
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
	public void testGetListByUserBlog() 
	{
		
		Blog blog = new Blog();
		
		List<Blog> listBlogs=blogDAO.listBlog("Kiri");
		assertTrue("List of blog data display",listBlogs.size()>0);
		
		for(Blog blogs:listBlogs)
		{
			System.out.println(blogs.getBlogId()+"::");
			System.out.println(blogs.getBlogName()+"::");
			System.out.println(blogs.getBlogContent()+"::");
			System.out.println(blogs.getStatus()+"::");
			System.out.println(blogs.getUsername()+"::");
			
		}
	}
		
		
		
		 
	

}
	
