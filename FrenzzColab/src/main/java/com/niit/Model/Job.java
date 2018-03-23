package com.niit.Model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
@Component
@Entity
public class Job {

	@Id
	@GeneratedValue(generator="job_sequence", strategy= GenerationType.SEQUENCE)
	@SequenceGenerator(name="job_sequence", sequenceName="job_seq", initialValue=1, allocationSize=1)
	int jobId;
	String jobDesignation;
	String company;
	int salary;
	String location;
	String jobDesc;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    Date lastDateApply;
	
	
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobDesignation() {
		return jobDesignation;
	}
	public void setJobDesignation(String jobDesignation) {
		this.jobDesignation = jobDesignation;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public Date getLastDateApply() {
		return lastDateApply;
	}
	public void setLastDateApply(Date lastDateApply) {
		this.lastDateApply = lastDateApply;
	}
	
	

}
