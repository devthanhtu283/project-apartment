package com.demo.models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.demo.entities.ConnectDB;
import com.demo.entities.Contact;
import com.demo.entities.Log;
import com.demo.ex.ConfigLog;

public class LogModel {
	public boolean create(Log log) {
		
		
		boolean status = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
			.prepareStatement("insert into log(ip,level,national,time,beforevalue,aftervalue) values(?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, log.getIp());
			preparedStatement.setString(2, log.getLevel());
			preparedStatement.setString(3, log.getNational());
			
			preparedStatement.setTimestamp(4, new Timestamp(log.getTime().getTime()));
			preparedStatement.setString(5, log.getBeforeValue());
			preparedStatement.setString(6, log.getAfterValue());
	
	
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
	public List<Log> findAll(){
		List<Log> logs = new ArrayList<Log>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from log");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Log log = new Log();
				log.setId(resultSet.getInt("id"));
				log.setLevel(resultSet.getString("level"));
				log.setIp(resultSet.getString("ip"));
				logs.add(log);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logs = null;
			// TODO: handle exception
		} finally {
			ConnectDB.disconnect();
		}
		
		return logs;
	}
	public static void main(String[] args) {
		System.out.println(new LogModel().findAll());
	}
}	