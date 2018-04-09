package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.JobDAO;
import com.niit.Model.Blog;
import com.niit.Model.Job;

public class JobListByIdTest {
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

		List<Job> listJobs=jobDAO.listJob();
		assertTrue("List of job data display",listJobs.size()>0);
		
		for(Job jobs:listJobs)
		{
			System.out.println(jobs.getCompany()+"::");
			System.out.println(jobs.getJobDesc()+"::");
			System.out.println(jobs.getJobDesignation()+"::");
			System.out.println(jobs.getLocation()+"::");
			System.out.println(jobs.getSalary()+"::");
			
		}

}
}
