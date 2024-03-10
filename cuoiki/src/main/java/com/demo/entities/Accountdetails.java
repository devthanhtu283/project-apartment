package com.demo.entities;

import java.util.Date;

public class Accountdetails {
	private int id;
	private int accountid;
	private String name;
	private Date birthday;
	private String address;
	private String phonenumber;
	private String avatar;
	private Date updatedate;
	public Accountdetails(int id, int accountid, String name, Date birthday, String address, String phonenumber,
			String avatar, Date updatedate) {
		super();
		this.id = id;
		this.accountid = accountid;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.phonenumber = phonenumber;
		this.avatar = avatar;
		this.updatedate = updatedate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public Accountdetails() {
		super();
	}
	@Override
	public String toString() {
		return "Accountdetails [id=" + id + ", accountid=" + accountid + ", name=" + name + ", birthday=" + birthday
				+ ", address=" + address + ", phonenumber=" + phonenumber + ", avatar=" + avatar + ", updatedate="
				+ updatedate + "]";
	}
	
}
