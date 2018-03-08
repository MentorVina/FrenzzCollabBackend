package com.niit.test;

import java.util.Date;
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
	public void testInsertJob() throws ParseException{
		String dt="08/11/2001";
		Date dobj=new SimpleDateFormat("dd/mm/yyyy").parse(dt);
		Job job = new Job();

		job.setJobTitle("Manager");
	job.setJobDescription("Managing design part");
		job.setJoinDate(dobj);
		job.setSalary(50000);

	    jobDAO.addJob(job);
		System.out.println("Done Boss");
		
	}
}
