package com.niit.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.ForumDAO;

import com.niit.Model.Forum;

public class ForumListByUserTest {

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
	public void testListByUserForum() {
		Forum forum = new Forum();
		List<Forum> forumList=new ArrayList<Forum>();
		forumList=forumDAO.listForum("Kiri");
		if(forumList.isEmpty())
		{
			System.out.println("error");
		}
		else
			
		{
			for(Forum forum1:forumList)
			{
				
				System.out.println("Forum Id:" + forum1.getForumId() +  "Forum Content:"  +  forum1.getForumContent()  +  "Name:" + forum1.getUsername());
			}
		}
		
		
	}
	
}

