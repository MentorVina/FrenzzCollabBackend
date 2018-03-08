package com.niit.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.JobDAO;
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

	public List<Job> listJob(int jobId) {
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job where jobId=:jobId");
		query.setParameter("jobId",jobId);
		query.list();
		List<Job> job=query.list();
		return job;
	}

	
	
}
