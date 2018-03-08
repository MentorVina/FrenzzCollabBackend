package com.niit.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Job {

	@Id
	@GeneratedValue(generator="job_sequence", strategy= GenerationType.SEQUENCE)
	@SequenceGenerator(name="job_sequence", sequenceName="job_seq", initialValue=1, allocationSize=1)
	int jobId;
	String jobTitle;
	String JobDescription;
	int salary;
	java.util.Date joinDate;
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return JobDescription;
	}
	public void setJobDescription(String jobDescription) {
		JobDescription = jobDescription;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public java.util.Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(java.util.Date joinDate) {
		this.joinDate = joinDate;
	}
	
	

}
