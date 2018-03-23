package com.niit.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.BlogDAO;
import com.niit.Model.Blog;

public class BlogGetByIdTest {
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
		public void testGetByIdBlog() 
		{
			
			Blog blog = new Blog();
			
			 blog=(Blog)blogDAO.getBlog(1);
			 
			 System.out.println("ID: "+blog.getBlogId()+ ",UserName: " +blog.getUsername());
		}

}
