package com.blog.model;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.blog.utils.EnumUtil.Status;

public class Topic {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int topic_id;
	
	@JoinColumn(name = "sub_id")	
	@ManyToOne
	private Subject subject;
	
	private String name;
	private Status status;
	
	
	
	@ManyToOne
	@JoinColumn(name="parent_topic")
	private Topic parentTopic;
	
	
	
	
	
	public int getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}
	
	
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Topic getParentTopic() {
		return parentTopic;
	}
	public void setParentTopic(Topic parentTopic) {
		this.parentTopic = parentTopic;
	}
	
	

}
