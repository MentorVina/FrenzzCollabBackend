package com.niit.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.JobDAO;
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

		List<Job> jobList=new ArrayList<Job>();
		jobList=jobDAO.listJob(2);
		if(jobList.isEmpty())
		{
			System.out.println("error");
		}
		else
			
		{
			for(Job job1:jobList)
			{
				
				System.out.println("Job Id:" + job1.getJobId() +  ",Job Title:"  +  job1.getJobTitle()  +  ",Salary:" + job1.getSalary());
			}
		}
	}

}
