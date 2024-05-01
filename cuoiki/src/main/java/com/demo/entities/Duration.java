package com.demo.entities;


import java.util.Date;

public class Duration {
	private int id;
	private Date start;
	private Date end;
	private boolean status;
	public Duration() {
		super();
	}
	public Duration(int id, Date start, Date end, boolean status) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Duration [id=" + id + ", start=" + start + ", end=" + end + ", status=" + status + "]";
	}
}
