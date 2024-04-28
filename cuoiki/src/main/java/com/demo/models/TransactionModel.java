package com.demo.models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import com.demo.entities.ConnectDB;
import com.demo.entities.Post;
import com.demo.entities.Transaction;

public class TransactionModel {
	
	public boolean create(Transaction transaction) {
		boolean status = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
			.prepareStatement("insert into transaction(type,price,date,accountID ,orderinfo,paymenttype,transactionno) values(?, ?, ?, ?,?, ?, ?)");
			preparedStatement.setInt(1, transaction.getType());
			preparedStatement.setDouble(2, transaction.getPrice());
			preparedStatement.setTimestamp(3, new Timestamp(transaction.getDate().getTime()));
			preparedStatement.setInt(4, transaction.getAccountID());
			preparedStatement.setString(5, transaction.getOrderInfo());
			preparedStatement.setString(6, transaction.getPaymentType());
			preparedStatement.setString(7, transaction.getTransactionNo());
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
		Transaction transaction = new Transaction(1, 30000, new java.util.Date(), 2, "aaaa", "bbbb", "aaaa");
		System.out.println(new TransactionModel().create(transaction));
	}
}
