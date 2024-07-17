package com.demo.helpers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.demo.servlets.test;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSHelper {

    public static void sendSMS(String body) throws ServletException, IOException {
        try {
            HttpPost post = new HttpPost("https://api.twilio.com/2010-04-01/Accounts/" + ACCOUNT_SID + "/Messages.json");
            String auth = ACCOUNT_SID + ":" + AUTH_TOKEN;
            String encodedAuth = java.util.Base64.getEncoder().encodeToString(auth.getBytes());
            post.setHeader("Authorization", "Basic " + encodedAuth);

            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair("To", "+18777804236"));
            urlParameters.add(new BasicNameValuePair("From", "+19129376559"));
            urlParameters.add(new BasicNameValuePair("Body", new String(body.getBytes("ISO-8859-1"), "UTF-8")));

            post.setEntity(new UrlEncodedFormEntity(urlParameters));
            
            CloseableHttpResponse httpResponse = httpClient.execute(post);
            String responseString = EntityUtils.toString(httpResponse.getEntity());
            System.out.println(responseString);
        } finally {
        	
				httpClient.close();
			
        }
    }

}
