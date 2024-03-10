package com.demo.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entities.Account;
import com.demo.entities.Contact;
import com.demo.models.AccountModel;
import com.demo.models.ContactModel;
import com.demo.models.FeedbackModel;
import com.google.gson.Gson;
@WebServlet({"/admin/contact"})
/**
 * Servlet implementation class AccountAdminServlet
 */
public class ContactAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactAdminServlet() {
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
		} else if(action.equalsIgnoreCase("deleteContact")) {
			doGet_DeleteContact(request, response);
		} else if(action.equalsIgnoreCase("updateContact")) {
			doGet_UpdateContact(request, response);
		} else if(action.equalsIgnoreCase("getContact")) {
			doGet_GetContact(request, response);
		}  else if(action.equalsIgnoreCase("checkContact")) {
			doGet_CheckContact(request, response);
		}
	}
	protected void doGet_Index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("admin", "../admin/contact.jsp");
		request.setAttribute("activeContact", "active");
		ContactModel contactModel = new ContactModel();
		request.setAttribute("contacts", contactModel.findAll());
		request.getRequestDispatcher("/WEB-INF/views/layout/admin.jsp").forward(request, response);
	}
	
	protected void doGet_DeleteContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactModel contactModel = new ContactModel();
		int id = Integer.parseInt(request.getParameter("id"));
		if(contactModel.delete(id)) {
			request.getSession().setAttribute("msg", "Đã xóa thành công");
			response.sendRedirect(request.getContextPath() + "/admin/contact");
		} else {
			request.getSession().setAttribute("msg", "Thất bại");
			response.sendRedirect(request.getContextPath() + "/admin/contact");
		}
	}
	
	protected void doGet_UpdateContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactModel contactModel = new ContactModel();
		int id = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactModel.findById(id);
		if(contactModel.update(contact)) {
			request.getSession().setAttribute("msg", "Đã giải quyết!");
			response.sendRedirect(request.getContextPath() + "/admin/contact");
		} else {
			request.getSession().setAttribute("msg", "Thất bại");
			response.sendRedirect(request.getContextPath() + "/admin/contact");
		}
	}
	protected void doGet_GetContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter printWriter = response.getWriter();
		Gson gson = new Gson();
		ContactModel contactModel = new ContactModel();
		printWriter.print(gson.toJson(contactModel.findTop3()));
	}
	protected void doGet_CheckContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		String number = request.getParameter("oldContact");
		int oldContact = Integer.parseInt(number);
		PrintWriter printWriter = response.getWriter();
		ContactModel contactModel = new ContactModel();
		int newContact = contactModel.findAll().size();
		if(request.getParameter("test") != null) {
			request.getSession().removeAttribute("contacts");
			request.getSession().setAttribute("contacts", contactModel.findAll().size());
		}
		printWriter.print(newContact);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}
