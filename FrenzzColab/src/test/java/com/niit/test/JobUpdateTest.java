package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.JobDAO;
import com.niit.Model.Job;

public class JobUpdateTest {
	private static DBConfig config;
	@Autowired
	private static JobDAO jobDAO;

	@BeforeClass
	public static void setUp() {
		config = new DBConfig();
		//blogDAO = new BlogDAOImpl(config.getSessionFactory(config.getDataSource()));
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		jobDAO =(JobDAO) context.getBean("jobDAO");
	}
	@Test
	public void testUpdateJob() {
		
		Job job = new Job();
		 job=(Job)jobDAO.getJob(2);
		 job.setJobTitle("Developer");
		 assertEquals("sucessfully updated from table" ,true,jobDAO.updateJob(job));
			
	}

}
