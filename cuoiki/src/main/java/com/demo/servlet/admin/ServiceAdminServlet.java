package com.demo.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entities.Account;
import com.demo.entities.AccountService;
import com.demo.entities.Duration;
import com.demo.entities.Sale;
import com.demo.entities.Service;
import com.demo.models.AccountDetailsModel;
import com.demo.models.AccountModel;
import com.demo.models.AccountPartialModel;
import com.demo.models.AccountServiceModel;
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
		} else if(action.equals("addService")){ 
			doGet_AddService(request, response);
		} 
	}
	protected void doGet_Index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("admin", "../admin/service.jsp");
		request.setAttribute("activeAccount", "active");
		ServiceModel serviceModel = new ServiceModel();
		request.setAttribute("service", serviceModel.findAll());
		

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
	
	protected void doGet_AddService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("admin", "../admin/addService.jsp");
		
		request.getRequestDispatcher("/WEB-INF/views/layout/admin.jsp").forward(request, response);
		
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("addService")) {
			doPost_AddService(request, response);
		}
	}
	
	protected void doPost_AddService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String introduction = request.getParameter("introduction");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		int postNumber = Integer.parseInt(request.getParameter("postNumber"));
		
		Service service = new Service();
		Calendar calendar = Calendar.getInstance();
		ServiceModel serviceModel = new ServiceModel();
		
		service.setName(name);
		service.setIntroduction(introduction);
		service.setPrice(price);
		service.setDescription(description);
		service.setPostNumber(postNumber);
		service.setStatus(true);
		service.setCreated(new Date());
		if(serviceModel.create(service)) {
			service.setStatus(false);
			serviceModel.update(service);
			request.getSession().setAttribute("msg", "Đăng kí gói dịch vụ thành công");
			response.sendRedirect(request.getContextPath() + "/superadmin/service");
		} else {
			request.getSession().setAttribute("msg", "Đăng kí gói dịch vụ thất bại");
			response.sendRedirect(request.getContextPath() + "/superadmin/service");
		}
	}

}
