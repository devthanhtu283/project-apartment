package com.demo.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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
import com.demo.entities.Systemapartment;
import com.demo.models.BranchModel;
import com.demo.models.ChatModel;
import com.demo.models.SystemApartmentModel;
import com.google.gson.Gson;
@WebServlet("/chatuser")

/**
 * Servlet implementation class HomeServlet
 */
public class SystemApartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemApartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private Account account = null;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null) {
			doGet_Index(request, response);
		} 
	}
	protected void doGet_Index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SystemApartmentModel systemApartmentModel = new SystemApartmentModel();
	
		account = (Account) request.getSession().getAttribute("account");
		System.out.println(account);
		request.setAttribute("systemapartments", systemApartmentModel.findAll());
		request.setAttribute("activeSystem", "active");
		request.setAttribute("p", "../user/chatuser.jsp");
		request.getRequestDispatcher("/WEB-INF/views/layout/user.jsp").forward(request, response);
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
}
