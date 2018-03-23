package com.niit.test;

import static org.junit.Assert.*;



import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.BlogDAO;
import com.niit.Model.Blog;

public class BlogInsertTest {

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
	public void testInsertBlog() {

		Blog blog = new Blog();

		blog.setBlogName("test2");
		blog.setBlogContent("Politician");
		blog.setCreateDate(new java.util.Date());
		blog.setUsername("Kiri");
		blog.setStatus("A");
		blog.setLikes(0);
	assertTrue("Data inserted in blog table",blogDAO.addBlog(blog));
		System.out.println("Done Boss");

	}

}
