package com.niit.test;

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
		
		List<Blog> blogList=new ArrayList<Blog>();
		blogList=blogDAO.listBlog("Akshay");
		if(blogList.isEmpty())
		{
			System.out.println("error");
		}
		else
			
		{
			for(Blog blog1:blogList)
			{
				
				System.out.println("Blog Id:" + blog1.getBlogId() + "Blog Content:" + blog1.getBlogContent() +"Name:"+blog1.getUsername());
			}
		}
		 
	}

}
	
