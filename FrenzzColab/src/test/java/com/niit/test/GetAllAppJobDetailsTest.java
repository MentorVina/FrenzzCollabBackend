package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.JobDAO;
import com.niit.Model.ApplyJob;


public class GetAllAppJobDetailsTest {
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
	public void testGetAllJobdetails() {
		ApplyJob app = new ApplyJob();

	List<ApplyJob> listApplyJobs=jobDAO.getAllApplicationJobDetails();
	
	assertTrue("List of Applyjob data display",listApplyJobs.size()>0);
	
	for(ApplyJob j1:listApplyJobs)
	{
		System.out.println(j1.getApplicationId()+"::");
		System.out.println(j1.getJobId()+"::");
		System.out.println(j1.getLoginname()+"::");
		System.out.println(j1.getApplyDate()+"::");
	}
		
	}

}
