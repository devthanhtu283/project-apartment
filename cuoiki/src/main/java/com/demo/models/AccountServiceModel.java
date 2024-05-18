package com.demo.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.demo.entities.AccountService;
import com.demo.entities.Chat;
import com.demo.entities.ConnectDB;

public class AccountServiceModel {
	public List<AccountService> findAll(){
		List<AccountService> accountServices = new ArrayList<AccountService>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from account_service where status = 1");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				AccountService accountService = new AccountService();
				accountService.setId(resultSet.getInt("id"));
				accountService.setAccountID(resultSet.getInt("accountID"));
				accountService.setServiceID(resultSet.getInt("serviceID"));
				accountService.setDurationID(resultSet.getInt("durationID"));
				accountService.setSaleID(resultSet.getInt("saleID"));
				accountService.setCreated(resultSet.getTimestamp("created"));
				accountService.setStatus(resultSet.getBoolean("status"));
				accountServices.add(accountService);
			}
		} catch (Exception e) {
			e.printStackTrace();
			accountServices = null;
			// TODO: handle exception
		} finally {
			ConnectDB.disconnect();
		}
		
		return accountServices;
	}
	public static void main(String[] args) {
		AccountServiceModel accountServiceModel = new AccountServiceModel();
		System.out.println(accountServiceModel.findAll());
	}
}
