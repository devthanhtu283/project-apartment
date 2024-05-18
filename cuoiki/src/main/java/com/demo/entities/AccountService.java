package com.demo.entities;

import java.util.Date;

public class AccountService {
	private int id;
	private int accountID;
	private int serviceID;
	private int durationID;
	private Date created;
	private boolean status;
	private int saleID;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public int getServiceID() {
		return serviceID;
	}
	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}
	public int getDurationID() {
		return durationID;
	}
	public void setDurationID(int durationID) {
		this.durationID = durationID;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getSaleID() {
		return saleID;
	}
	public void setSaleID(int saleID) {
		this.saleID = saleID;
	}
	public AccountService(int accountID, int serviceID, int durationID, Date created, boolean status, int saleID) {
		super();
		this.accountID = accountID;
		this.serviceID = serviceID;
		this.durationID = durationID;
		this.created = created;
		this.status = status;
		this.saleID = saleID;
	}
	public AccountService() {
		super();
	}
	@Override
	public String toString() {
		return "AccountService [id=" + id + ", accountID=" + accountID + ", serviceID=" + serviceID + ", durationID="
				+ durationID + ", created=" + created + ", status=" + status + ", saleID=" + saleID + "]";
	}
	
	
}
