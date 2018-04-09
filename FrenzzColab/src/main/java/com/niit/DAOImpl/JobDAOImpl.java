package com.niit.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.JobDAO;
import com.niit.Model.ApplyJob;
import com.niit.Model.Blog;
import com.niit.Model.Job;
@Repository("JobDAO")
public class JobDAOImpl implements JobDAO {
	@Autowired
    SessionFactory sessionFactory;
	
	
	public JobDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	@Transactional
	public boolean addJob(Job job) {
	
		try
		{
			sessionFactory.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	@Transactional
	public boolean deleteJob(Job job) {
		try
		{
			sessionFactory.getCurrentSession().delete(job);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	@Transactional
	public boolean updateJob(Job job) {
		
		try
		{
			sessionFactory.getCurrentSession().update(job);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Job getJob(int jobId) {
		
		try
		{
			Session session=sessionFactory.openSession();
			Job job=session.get(Job.class,jobId);
			session.close();
			return job;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public List<Job> listJob() {
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(" from Job");
		query.list();
		List<Job> listJobs=query.list();
		return listJobs;
	}
	@Transactional
	public boolean applyJob(ApplyJob app) {
		try
		{
			sessionFactory.getCurrentSession().save(app);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public List<ApplyJob> getAllApplicationJobDetails() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(" from  ApplyJob");
		query.list();
		List<ApplyJob> applyjoblist=query.list();
		return applyjoblist;
	}

	
	
}
