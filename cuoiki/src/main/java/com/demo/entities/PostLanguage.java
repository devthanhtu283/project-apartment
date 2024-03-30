package com.demo.entities;

public class PostLanguage {
	private int id;
	private int languageID;
	private int postID;
	private String subject;
	private String address;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLanguageID() {
		return languageID;
	}
	public void setLanguageID(int languageID) {
		this.languageID = languageID;
	}
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public PostLanguage(int id, int languageID, int postID, String subject, String address, String description) {
		super();
		this.id = id;
		this.languageID = languageID;
		this.postID = postID;
		this.subject = subject;
		this.address = address;
		this.description = description;
	}
	public PostLanguage() {
		super();
	}
	@Override
	public String toString() {
		return "PostLanguage [id=" + id + ", languageID=" + languageID + ", postID=" + postID + ", subject=" + subject
				+ ", address=" + address + ", description=" + description + "]";
	}
	
}
