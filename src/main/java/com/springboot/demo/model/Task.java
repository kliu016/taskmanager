package com.springboot.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private int id;
	
	private String title;
	private String description;
	
	private Date duedate;
	private String completestatus;
		
	private Date createdate;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	public String getCompletestatus() {
		return completestatus;
	}
	public void setCompletestatus(String completestatus) {
		this.completestatus = completestatus;
	}	
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}	
	
}
