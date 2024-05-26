package com.demo.helpers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.demo.entities.Account;
import com.demo.entities.Chat;
import com.demo.models.ChatModel;
import com.demo.models.OwnerModel;
import com.google.gson.Gson;

//import com.demo.entities.Chat;
//import com.demo.models.ChatModel;

@ServerEndpoint("/chat")
public class ChatEndpoint {
	
	private List<String> msg = new ArrayList<String>();
    private static final Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session session) {
        clients.add(session);
    }
	
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
    
    	ChatModel chatModel = new ChatModel();
    	Chat chat = new Chat();
    	chat.setAdminID(29);

    	chat.setTime(new Date());
    	System.out.println(message);
    	
    	String accountID = message.substring(message.lastIndexOf('-') + 1);
    	System.out.println(accountID);
    	chat.setUserID(Integer.parseInt(accountID));
    	
        for (Session client : clients) {
        	
            if (!client.equals(session)) {
            	if(message.contains("-ADMIN21042003")) {
            		
            		chat.setMessage(message.replace("-ADMIN21042003" + "-" + accountID, ""));
            		chat.setRole(0);
            	} else if(message.contains("-USER21042003")){
            		chat.setMessage(message.replace("-USER21042003" + "-" + accountID, ""));
            		chat.setRole(1);
            	}
                client.getBasicRemote().sendText(message);
            }
          
        }
        if(chatModel.newChat(chat)) {
        	System.out.println("Thanh cong");
        } else {
        	System.out.println("That bai");
        }
    }

    @OnClose
    public void onClose(Session session) {
        clients.remove(session);
    }
}
