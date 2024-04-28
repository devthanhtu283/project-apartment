/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.servlet;


import com.demo.entities.Account;
import com.demo.entities.Accountdetails;
import com.demo.entities.Transaction;
import com.demo.helpers.Config;
import com.demo.models.AccountDetailsModel;
import com.demo.models.TransactionModel;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/payment")
/**
 *
 * @author CTT VNPAY
 */
public class PaymentServlet extends HttpServlet {
	  @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  	String action = req.getParameter("action");
		  	if(action == null) {
		  		doGet_Index(req, resp);
		  	} else if(action.equalsIgnoreCase("return")){
		  		doGet_Return(req, resp);
		  	}
	     
	    }

	    protected void doGet_Index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        req.getRequestDispatcher("/WEB-INF/views/payment.jsp").forward(req, resp);
	     
	    }
	    protected void doGet_Return(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	
	    	
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	    	SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
	    	String statusCode = req.getParameter("vnp_ResponseCode");
	    	String orderInfo = req.getParameter("vnp_OrderInfo");
	    	String transactionNo = req.getParameter("vnp_TransactionNo");
	    	String paymentType = req.getParameter("vnp_CardType");
	    	
	    	if(statusCode.equals("00")) {
	    		Account account = (Account) req.getSession().getAttribute("account");
		    	AccountDetailsModel accountDetailsModel = new AccountDetailsModel();
		    	Accountdetails accountdetails = accountDetailsModel.findAccountByAccountID(account.getId());
		    	System.out.println(accountdetails.getBalance());
	    		String amount = req.getParameter("vnp_Amount");
	    		System.out.println(Double.parseDouble(amount)/100);
	    		String date = req.getParameter("vnp_PayDate");
	    		accountdetails.setBalance(accountdetails.getBalance() + Double.parseDouble(amount)/100);
	    		Transaction transaction = new Transaction(1, Double.parseDouble(amount)/100, new Date(), account.getId() , orderInfo, paymentType, transactionNo);
	    		TransactionModel transactionModel = new TransactionModel();
	    		if(accountDetailsModel.updateBalance(accountdetails) && transactionModel.create(transaction)) {
	    			System.out.println("thanh cong");
	    		} else {
	    			System.out.println("That bai");
	    		}
	    		try {
					System.out.println(dateFormat2.format(dateFormat.parse(date)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	
	        req.getRequestDispatcher("/WEB-INF/views/user/return.jsp").forward(req, resp);
	     
	    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String orderType = "other";
        long amount = Integer.parseInt(req.getParameter("amount"))*100;
        String bankCode = req.getParameter("bankCode");
       
        String vnp_TxnRef = Config.getRandomNumber(8);
        String vnp_IpAddr = Config.getIpAddress(req);

        String vnp_TmnCode = Config.vnp_TmnCode;
        
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");
        
        if (bankCode != null && !bankCode.isEmpty()) {
            vnp_Params.put("vnp_BankCode", bankCode);
        }
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Nap vao " + amount/100 +  "  tai khoan");
        vnp_Params.put("vnp_OrderType", orderType);

        String locate = req.getParameter("language");
        if (locate != null && !locate.isEmpty()) {
            vnp_Params.put("vnp_Locale", locate);
        } else {
            vnp_Params.put("vnp_Locale", "vn");
        }
        vnp_Params.put("vnp_ReturnUrl", Config.vnp_ReturnUrl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
        
        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
        
        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = Config.hmacSHA512(Config.secretKey, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
        System.out.println(paymentUrl);
        resp.sendRedirect(paymentUrl);
    }

}
