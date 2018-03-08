package com.niit.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BlogDAOTest {

	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
	}
		
		@Test
		public void test()
		{
			//fail(" Not yet implemented");
		}
		
}
