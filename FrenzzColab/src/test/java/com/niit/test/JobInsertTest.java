package com.niit.test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.JobDAO;
import com.niit.Model.Job;

public class JobInsertTest {
	
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
	public void testInsertJob() {
		Job job = new Job();

		job.setCompany("ABC pvt.Ltd");
		job.setJobDesc("Food Company");
		job.setLastDateApply(new java.util.Date());
		job.setJobDesignation("Manager");
		job.setLocation("Pune");
		job.setSalary(45000);
	assertTrue("Data inserted in job table",jobDAO.addJob(job));
		
	}
}
