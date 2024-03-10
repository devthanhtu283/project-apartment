package com.demo.models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.entities.Account;
import com.demo.entities.Accountdetails;
import com.demo.entities.ConnectDB;

public class AccountDetailsModel {
	public Accountdetails findAccountByAccountID(int accID) {
		Accountdetails account = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from accountdetails where accountid = ?");
			preparedStatement.setInt(1, accID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				account = new Accountdetails();
				account.setId(resultSet.getInt("id"));
				account.setAddress(resultSet.getString("address"));
				account.setAvatar(resultSet.getString("avatar"));
				account.setBirthday(resultSet.getDate("birthday"));
				account.setAccountid(resultSet.getInt("accountid"));
				account.setPhonenumber(resultSet.getString("phonenumber"));
				account.setUpdatedate(resultSet.getDate("updatedate"));
				account.setName(resultSet.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			account = null;
			// TODO: handle exception
		} finally {
			ConnectDB.disconnect();
		}
		return account;
	}
	
	public boolean create(Accountdetails accountdetails) {
		boolean status = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
			.prepareStatement("insert into accountdetails(accountid,name,birthday,address,phonenumber,avatar,updatedate) values(?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, accountdetails.getAccountid());
			preparedStatement.setString(2, accountdetails.getName());
			preparedStatement.setDate(3, new Date(accountdetails.getBirthday().getTime()));
			preparedStatement.setString(4, accountdetails.getAddress());
			preparedStatement.setString(5, accountdetails.getPhonenumber());
			preparedStatement.setString(6, accountdetails.getAvatar());
			preparedStatement.setDate(7, new Date(accountdetails.getUpdatedate().getTime()));
			
			status = preparedStatement.executeUpdate() > 0;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
			// TODO: handle exception
		} finally {
			ConnectDB.disconnect();
		}
		return status;
	}
	
	public boolean update(Accountdetails accountdetails) {
		boolean status = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
			.prepareStatement("update accountdetails set name = ?, birthday = ?, address = ?, phonenumber = ?, avatar = ?, updatedate = ? where accountid = ?");
			preparedStatement.setString(1, accountdetails.getName());
			preparedStatement.setDate(2, new Date(accountdetails.getBirthday().getTime()));
			preparedStatement.setString(3, accountdetails.getAddress());
			preparedStatement.setString(4, accountdetails.getPhonenumber());
			preparedStatement.setString(5, accountdetails.getAvatar());
			preparedStatement.setDate(6, new Date(accountdetails.getUpdatedate().getTime()));
			preparedStatement.setInt(7, accountdetails.getAccountid());
			
			status = preparedStatement.executeUpdate() > 0;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
			// TODO: handle exception
		} finally {
			ConnectDB.disconnect();
		}
		return status;
	}
	
	public static void main(String[] args) {
		AccountDetailsModel accountDetailsModel = new AccountDetailsModel();
		System.out.println(accountDetailsModel.update(new Accountdetails(1, 2, "Hoàng Tú", new java.util.Date(),"Hà Nội" ,"0916700827", "hoangtu.jpg", new java.util.Date())));
		System.out.println("Lê Thanh Tú");
	}
}
