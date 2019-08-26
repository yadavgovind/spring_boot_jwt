package com.blog.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.blog.utils.EnumUtil.Is_Published;
import com.blog.utils.EnumUtil.Status;
import com.blog.utils.EnumUtil.Type;

public class BlogContent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blog_id;
	
	@JoinColumn(name="topic_id")
	private int topic_id;
	private String title;
	private String description;
	private String content;			//****BLOB: need to confirm its data type ***
	private Date create_date;
	private Is_Published Is_Published;
	
	@JoinColumn(name="author_id")
	private int author_id;
	
	@JoinColumn(name="publisher_id")
	private int publisher_id;
	private Date publish_date;
	private Type type;
	private Status status;
	public int getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}
	public int getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Is_Published getIs_Published() {
		return Is_Published;
	}
	public void setIs_Published(Is_Published is_Published) {
		Is_Published = is_Published;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	
	
}
