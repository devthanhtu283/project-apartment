package com.demo.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.demo.entities.ConnectDB;
import com.demo.entities.Duration;
import com.demo.entities.Invoice;

public class DurationModel {
	public List<Duration> findAll(){
		List<Duration> durations = new ArrayList<Duration>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from duration");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Duration duration = new Duration();
				duration.setId(resultSet.getInt("id"));
				duration.setStart(resultSet.getDate("start"));
				duration.setEnd(resultSet.getDate("end"));
				duration.setStatus(resultSet.getBoolean("status"));
				
				durations.add(duration);
			}
		} catch (Exception e) {
			e.printStackTrace();
			durations = null;
			// TODO: handle exception
		} finally {
			ConnectDB.disconnect();
		}
		
		return durations;
	}
	
	public boolean register(Duration duration) {
		boolean status = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
			.prepareStatement("insert into duration(start, end, status) values(?, ?, ?)");
			preparedStatement.setTimestamp(1, new Timestamp(duration.getStart().getTime()));
			preparedStatement.setTimestamp(2, new Timestamp(duration.getEnd().getTime()));
			preparedStatement.setBoolean(3, duration.isStatus());
			
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
        // Lấy thời điểm hiện tại
		Duration duration = new Duration();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        Date currentDate = calendar.getTime();

        // Thêm 1 tháng vào thời điểm hiện tại
        duration.setStart(new Date());
        calendar.add(Calendar.MONTH, 1);
        Date endDate = calendar.getTime();
		duration.setEnd(endDate);
        // Lấy thời điểm kết thúc

        System.out.println("Thời điểm hiện tại: " + simpleDateFormat.format(duration.getStart()));
        System.out.println("Thời điểm kết thúc: " + simpleDateFormat.format(duration.getEnd()));
    }
}
