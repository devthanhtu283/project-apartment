package com.demo.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entities.Account;
import com.demo.entities.Duration;
import com.demo.entities.Sale;
import com.demo.entities.Service;
import com.demo.models.AccountModel;
import com.demo.models.AccountPartialModel;
import com.demo.models.DurationModel;
import com.demo.models.FeedbackModel;
import com.demo.models.SaleModel;
import com.demo.models.ServiceModel;
import com.demo.models.SystemApartmentModel;
import com.google.gson.Gson;
@WebServlet({"/superadmin/service"})
/**
 * Servlet implementation class AccountAdminServlet
 */
public class ServiceAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceAdminServlet() {
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
		} else if(action.equalsIgnoreCase("deleteService")) {
			doGet_DeleteService(request, response);
		}
	}
	protected void doGet_Index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("admin", "../superadmin/accounts.jsp");
		request.setAttribute("activeAccount", "active");
		AccountPartialModel accountPartialModel = new AccountPartialModel();
		request.setAttribute("accounts", accountPartialModel.findAll());
		FeedbackModel feedbackModel = new FeedbackModel();
		

		request.getRequestDispatcher("/WEB-INF/views/layout/admin.jsp").forward(request, response);
	}
	
	protected void doGet_DeleteService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceModel serviceModel = new ServiceModel();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Service service = serviceModel.findByID(id);
		service.setStatus(false);
		if(serviceModel.update(service)) {
			request.getSession().setAttribute("msg", "Đã xóa dịch vụ thành công");
			response.sendRedirect(request.getContextPath() + "/superadmin/service");
			
		} else {
			System.out.println(1);
			response.sendRedirect(request.getContextPath() + "/superadmin/service");
		}

		
	}
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
