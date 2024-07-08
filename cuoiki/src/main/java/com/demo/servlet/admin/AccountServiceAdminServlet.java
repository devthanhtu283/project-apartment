package com.demo.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entities.Account;
import com.demo.entities.AccountService;
import com.demo.entities.Chat;
import com.demo.entities.Duration;
import com.demo.entities.Sale;
import com.demo.entities.Service;
import com.demo.models.AccountModel;
import com.demo.models.AccountPartialModel;
import com.demo.models.AccountServiceModel;
import com.demo.models.ChatModel;
import com.demo.models.DurationModel;
import com.demo.models.FeedbackModel;
import com.demo.models.SaleModel;
import com.demo.models.ServiceModel;
import com.demo.models.SystemApartmentModel;
import com.google.gson.Gson;
@WebServlet({"/admin/accountService"})
/**
 * Servlet implementation class AccountAdminServlet
 */
public class AccountServiceAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServiceAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null) {
			doGet_Index(request, response);
		} else if(action.equals("cancelService")){ 
			doGet_CancelService(request, response);
		} 
	}
	protected void doGet_Index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("admin", "../admin/accountService.jsp");
		request.setAttribute("activeAccountService", "active");
		

		request.getRequestDispatcher("/WEB-INF/views/layout/admin.jsp").forward(request, response);
	}
	
	protected void doGet_CancelService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("admin", "../admin/listAccountService.jsp");
		request.setAttribute("activeServiceAccount", "active");
		String accountServiceID = request.getParameter("accountServiceID");
		System.out.println(accountServiceID);
		AccountServiceModel accountServiceModel = new AccountServiceModel();
		
		AccountService accountService = accountServiceModel.findById(Integer.parseInt(accountServiceID));
		System.out.println(accountService);
		accountService.setStatus(false);
		if(accountServiceModel.update(accountService)) {
			response.sendRedirect(request.getContextPath() + "/admin/accountService");
		} else {
			
		}
	
	}

	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("sendChat")) {
			doPost_SendChat(request, response);
		}
	}
	protected void doPost_SendChat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountID = request.getParameter("accountID");
		String message = request.getParameter("message");
		ChatModel chatModel = new ChatModel();
		Chat chat = new Chat(Integer.parseInt(accountID), 29, message, 0, new Date());
		if(chatModel.newChat(chat)) {
			response.sendRedirect(request.getContextPath()+ "/admin/chatadmin?id="+ accountID);
		}
		
	}

}
