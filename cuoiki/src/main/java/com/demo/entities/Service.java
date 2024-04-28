package com.demo.entities;

import java.util.Date;

public class Service {
	private int id;
	private String name;
	private String introduction;
	private int price;
	private String description;
	private boolean status;
	private Date created;
	public Service() {
		super();
	}
	public Service(int id, String name, String introduction, int price, String description, boolean status,
			Date created) {
		super();
		this.id = id;
		this.name = name;
		this.introduction = introduction;
		this.price = price;
		this.description = description;
		this.status = status;
		this.created = created;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	@Override
	public String toString() {
		return "Service [id=" + id + ", name=" + name + ", introduction=" + introduction + ", price=" + price
				+ ", description=" + description + ", status=" + status + ", created=" + created + "]";
	}

}