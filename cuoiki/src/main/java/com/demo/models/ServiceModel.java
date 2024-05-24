package com.demo.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.demo.entities.ConnectDB;
import com.demo.entities.Service;

public class ServiceModel {
	public List<Service> findAll() {
		List<Service> services = new ArrayList<Service>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from service");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Service service = new Service();
				service.setId(resultSet.getInt("id"));
				service.setName(resultSet.getString("name"));
				service.setIntroduction(resultSet.getString("introduction"));
				service.setPrice(resultSet.getInt("price"));
				service.setDescription(resultSet.getString("description"));
				service.setStatus(resultSet.getBoolean("status"));
				service.setCreated(resultSet.getDate("created"));
				
				services.add(service);
			}
		} catch (Exception e) {
			e.printStackTrace();
			services = null;
			// TODO: handle exception
		} finally {
			ConnectDB.disconnect();
		}
		
		return services;
	}
	
	public Service findByID(int id) {
		Service service = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from service where id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				service = new Service();
				service.setId(resultSet.getInt("id"));
				service.setName(resultSet.getString("name"));
				service.setIntroduction(resultSet.getString("introduction"));
				service.setPrice(resultSet.getInt("price"));
				service.setDescription(resultSet.getString("description"));
				service.setPostNumber(resultSet.getInt("postNumber"));
				service.setStatus(resultSet.getBoolean("status"));
				service.setCreated(resultSet.getDate("created"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			service = null;
			// TODO: handle exception
		} finally {
			ConnectDB.disconnect();
		}
		
		return service;
	}
	
	public static void main(String[] args) {
		ServiceModel serivceModel = new ServiceModel();
		System.out.println(serivceModel.findByID(1).getPostNumber());
	}
}
