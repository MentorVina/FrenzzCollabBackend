package com.niit.DAO;

import java.util.List;

import com.niit.Model.ApplyJob;
import com.niit.Model.Job;

public interface JobDAO {

	public boolean addJob(Job job);
	public boolean deleteJob(Job job);
	public boolean updateJob(Job job);
	public Job getJob(int jobId);
	public List<Job> listJob();
	
	public boolean applyJob(ApplyJob app);
	public List<ApplyJob> getAllApplicationJobDetails();
}
