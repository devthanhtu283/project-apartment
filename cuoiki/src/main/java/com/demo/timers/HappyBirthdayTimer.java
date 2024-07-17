package com.demo.timers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import javax.servlet.ServletException;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.twilio.rest.api.v2010.account.Message;
import com.demo.entities.AccountPartial;
import com.demo.entities.Accountdetails;
import com.demo.helpers.SMSHelper;
import com.demo.models.AccountDetailsModel;
import com.demo.models.AccountPartialModel;
import com.twilio.Twilio;

public class HappyBirthdayTimer extends TimerTask{
	@Override
	public void run() {
		Date date = new Date();
		AccountPartialModel accountDetailsModel = new AccountPartialModel();
		for (AccountPartial accountdetails : accountDetailsModel.findAll()) {
			if(accountdetails.getBirthday().getDate() == date.getDate() && (accountdetails.getBirthday().getMonth()+1) == (date.getMonth()+1)) {
				try {
					SMSHelper.sendSMS("He thong T-Apartment chuc mung sinh nhat ban!");
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

    public static void main(String[] args) {
    	Date date = new Date();
		AccountPartialModel accountDetailsModel = new AccountPartialModel();
		for (AccountPartial accountdetails : accountDetailsModel.findAll()) {
			if(accountdetails.getBirthday().getDate() == date.getDate() && (accountdetails.getBirthday().getMonth()+1) == (date.getMonth()+1)) {
				System.out.println(accountdetails);
			}
		}
		
    }
}
