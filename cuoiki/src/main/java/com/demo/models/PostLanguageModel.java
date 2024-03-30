package com.demo.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.demo.entities.ConnectDB;
import com.demo.entities.Post;
import com.demo.entities.PostLanguage;

public class PostLanguageModel {
	public List<PostLanguage> findAll() {
		List<PostLanguage> posts = new ArrayList<PostLanguage>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from postlanguage");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				PostLanguage post = new PostLanguage();
				post.setId(resultSet.getInt("id"));
				post.setLanguageID(resultSet.getInt("languageid"));
				post.setPostID(resultSet.getInt("postid"));
				post.setSubject(resultSet.getString("subject"));
				post.setDescription(resultSet.getString("description"));
			
				post.setAddress(resultSet.getString("address"));
	
				posts.add(post);
			}
		} catch (Exception e) {
			e.printStackTrace();
			posts = null;
			// TODO: handle exception
		} finally {
			ConnectDB.disconnect();
		}

		return posts;
	}
	public PostLanguage find(int postID, int languageID) {
		PostLanguage post = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from postlanguage where postid = ? and languageid = ?");
			preparedStatement.setInt(1, postID);
			preparedStatement.setInt(2, languageID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				post = new PostLanguage();
				post.setId(resultSet.getInt("id"));
				post.setLanguageID(resultSet.getInt("languageid"));
				post.setPostID(resultSet.getInt("postid"));
				post.setSubject(resultSet.getString("subject"));
				post.setDescription(resultSet.getString("description"));
			
				post.setAddress(resultSet.getString("address"));
	
			}
		} catch (Exception e) {
			e.printStackTrace();
			post = null;
			// TODO: handle exception
		} finally {
			ConnectDB.disconnect();
		}

		return post;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(new PostLanguageModel().findAll());
		System.out.println(new PostLanguageModel().find(218, 2).getAddress());
	}
}
