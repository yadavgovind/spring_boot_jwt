package com.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Author")
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int author_id;
	
	private String name;
	
	private String email;
	
	public Author() {}
	
	public Author(int author_id, String name, String email) {
		super();
		this.author_id = author_id;
		this.name = name;
		this.email = email;
	}
	
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
	
	

}
