package com.demo.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.demo.entities.Account;
import com.demo.helpers.MailHelper;
import com.demo.helpers.RandomStringHelper;
import com.demo.models.AccountDetailsModel;
import com.demo.models.AccountModel;
import com.demo.models.ContactModel;
import com.demo.models.FeedbackModel;

@WebServlet("/login")
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			doGet_Login(request, response);
		} else {
			if(action.equalsIgnoreCase("logout")) {
				doGet_Logout(request, response);
			} else if(action.equalsIgnoreCase("verify")) {
				doGet_Verify(request, response);
			} else if(action.equalsIgnoreCase("message")) {
				doGet_Message(request, response);
			}
		}
	}
	protected void doGet_Verify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String securityCode = request.getParameter("securityCode");
		AccountModel accountModel = new AccountModel();
		Account account = accountModel.findAccountByUsername(new String(username.getBytes("ISO-8859-1"), "UTF-8"));
		System.out.println(account);
		if(account.getUsername().equalsIgnoreCase(new String(username.getBytes("ISO-8859-1"), "UTF-8")) && account.getSecurityCode().equalsIgnoreCase(securityCode)) {
			account.setVerify(true);
			if(accountModel.update(account)) {
				response.sendRedirect("login");
			}
			
		} else {
			request.getSession().setAttribute("content", "aaaaa");
			response.sendRedirect("login?action=message");
		}
	}
	protected void doGet_Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountModel accountModel = new AccountModel();
		request.setAttribute("accounts", accountModel.findAll());
		request.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(request, response);
	}
	protected void doGet_Message(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/login/test.jsp").forward(request, response);
	}
	protected void doGet_Logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("accountAdmin");
		request.getSession().removeAttribute("accountdetails");
		request.getSession().removeAttribute("account");
		request.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(request, response);
	}
	protected void doGet_Account(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("login")) {
			doPost_Login(request, response);
		} else if(action.equalsIgnoreCase("register")) {
			doPost_Register(request, response);
		}
	}
	protected void doPost_Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AccountModel accountModel = new AccountModel();
		AccountDetailsModel accountDetailsModel = new AccountDetailsModel();
		Account account = accountModel.findAccountByUsername(new String(username.getBytes("ISO-8859-1"), "UTF-8"));
		FeedbackModel feedbackModel = new FeedbackModel();
		ContactModel contactModel = new ContactModel();
		if(accountModel.login(new String(username.getBytes("ISO-8859-1"), "UTF-8"), password)) {
			if(account.getRole() == 0) {
				request.getSession().setAttribute("accountAdmin", account);
				request.getSession().removeAttribute("accountdetails");
				request.getSession().removeAttribute("account");
				request.getSession().setAttribute("feedbacks", feedbackModel.findAll().size());
				request.getSession().setAttribute("contacts", contactModel.findAll().size());
				response.sendRedirect("admin/dashboard");
			} else if(account.getRole() == 1) {
				request.getSession().setAttribute("accountdetails", 
						accountDetailsModel.findAccountByAccountID(accountModel.findAccountByUsername(new String(username.getBytes("ISO-8859-1"), "UTF-8")).getId()));
				request.getSession().setAttribute("account", accountModel.findAccountByUsername(new String(username.getBytes("ISO-8859-1"), "UTF-8")));
				
				request.getSession().removeAttribute("accountAdmin");
				response.sendRedirect("account");
			}
			
		
		} else {
			request.getSession().setAttribute("msg", "Tài khoản hoặc mật khẩu không đúng");
			response.sendRedirect("login");
		}
	}
	protected void doPost_Register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String securityCode = RandomStringHelper.generateRandomString(6);
		Account account = new Account();
		account.setUsername(new String(username.getBytes("ISO-8859-1"), "UTF-8") );
		account.setEmail(email);
		account.setCreated(new Date());
		account.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
		account.setStatus(true);
		account.setVerify(false);
		account.setRole(1);
		account.setSecurityCode(securityCode);
		AccountModel accountModel = new AccountModel();
		if(accountModel.register(account)) {
			request.getSession().setAttribute("msg", "Đã đăng kí tài khoản thành công. Xin vui lòng đăng nhập tài khoản");
			String content = "Xin chào, đây là email từ $Apartment! Vui lòng nhấp vào <a href='http://localhost:8080/projectGroup2/login?action=verify&username=" + new String(username.getBytes("ISO-8859-1"), "UTF-8") + "&email=" + email +"&securityCode=" + securityCode + "'>Liên kết</a> để xác nhận tài khoản của bạn.";
			MailHelper.MailHelper(email, "Xác nhận tài khoản - $Apartment", content);
			response.sendRedirect("login?action=message");
		} else {
			request.getSession().setAttribute("msg", "Đăng kí không thành công do đã tồn tại người dùng.");
			response.sendRedirect("login");
		}
		
	
		
	
	}

}
