package com.example.demo.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Post implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private String content;
	private Timestamp creationDate;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Timestamp getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", creationDate=" + creationDate + "]";
	}
    
}