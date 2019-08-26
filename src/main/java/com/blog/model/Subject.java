package com.blog.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.blog.utils.EnumUtil.Status;

public class Subject {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO )
	private long sub_id;
	private String name;
	private String url_name;
	private Status status;
	
	@OneToMany(mappedBy="sub_id")
	private List<Topic> topic=new ArrayList<Topic>();
	
	
	public long getSub_id() {
		return sub_id;
	}
	public void setSub_id(long sub_id) {
		this.sub_id = sub_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl_name() {
		return url_name;
	}
	public void setUrl_name(String url_name) {
		this.url_name = url_name;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	

	
	
}
