package com.blog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.blog.utils.EnumUtil.Status;

@Entity
@Table(name="Comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int comment_id;
	private String comment_text;
	private int comment_by;
	private Date comment_date;
	private Status status;
	private int blog_id;
	private String email;
	private int parent_comment_id;
	private String anonymous_user_name;
	
	
	public Comment() {}
	
	
	public Comment(int comment_id, String comment_text, int comment_by, Date comment_date, Status status, int blog_id,
			String email, int parent_comment_id, String anonymous_user_name) {
		super();
		this.comment_id = comment_id;
		this.comment_text = comment_text;
		this.comment_by = comment_by;
		this.comment_date = comment_date;
		this.status = status;
		this.blog_id = blog_id;
		this.email = email;
		this.parent_comment_id = parent_comment_id;
		this.anonymous_user_name = anonymous_user_name;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public String getComment_text() {
		return comment_text;
	}
	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	public int getComment_by() {
		return comment_by;
	}
	public void setComment_by(int comment_by) {
		this.comment_by = comment_by;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getParent_comment_id() {
		return parent_comment_id;
	}
	public void setParent_comment_id(int parent_comment_id) {
		this.parent_comment_id = parent_comment_id;
	}
	public String getAnonymous_user_name() {
		return anonymous_user_name;
	}
	public void setAnonymous_user_name(String anonymous_user_name) {
		this.anonymous_user_name = anonymous_user_name;
	}
	
	
	
	
	
	
}
