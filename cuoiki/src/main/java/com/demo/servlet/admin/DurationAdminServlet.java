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
import com.demo.entities.Duration;
import com.demo.entities.Service;
import com.demo.models.AccountModel;
import com.demo.models.AccountPartialModel;
import com.demo.models.DurationModel;
import com.demo.models.FeedbackModel;
import com.demo.models.PostImageModel;
import com.demo.models.PostModel;
import com.demo.models.ServiceModel;
import com.demo.models.SystemApartmentModel;
import com.google.gson.Gson;
@WebServlet({"/superadmin/duration"})
/**
 * Servlet implementation class AccountAdminServlet
 */
public class DurationAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DurationAdminServlet() {
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
		}else if(action.equalsIgnoreCase("searchByStatus")) {
			doGet_SearchByStatus(request, response);
		}
			else if(action.equalsIgnoreCase("deleteDuration")) {
			doGet_DeleteDuration(request, response);
		} else if(action.equals("newDuration")){ 
			doGet_NewDuration(request, response);
		} 
	}
	protected void doGet_Index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("admin", "../admin/duration.jsp");
		request.setAttribute("activeDuration", "active");
		DurationModel durationModel = new DurationModel();
		request.setAttribute("duration", durationModel.findAll());

		request.getRequestDispatcher("/WEB-INF/views/layout/admin.jsp").forward(request, response);
	}
	
	protected void doGet_SearchByStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		int status = Integer.parseInt(request.getParameter("value"));
		Gson gson = new Gson();
		DurationModel durationModel = new DurationModel();
		if(status == 0) {
			writer.print(gson.toJson(durationModel.findAll()));
		} else if(status == 1) {
			writer.print(gson.toJson(durationModel.checkStatus(true)));
		} else if(status == 2) {
			writer.print(gson.toJson(durationModel.checkStatus(false)));
		}
	}
	
	protected void doGet_DeleteDuration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DurationModel durationModel = new DurationModel();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Duration duration = durationModel.findById(id);
		duration.setStatus(false);
		if(durationModel.update(duration)) {
			request.getSession().setAttribute("msg", "Đã xóa thời hạn thành công");
			response.sendRedirect(request.getContextPath() + "/superadmin/duration");
			
		} else {
			System.out.println(1);
			response.sendRedirect(request.getContextPath() + "/superadmin/duration");
		}
	}
	
	protected void doGet_NewDuration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("admin", "../admin/newDuration.jsp");
		
		request.getRequestDispatcher("/WEB-INF/views/layout/admin.jsp").forward(request, response);
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("newDuration")) {
			doPost_NewDuration(request, response);
		}
	}
	
	protected void doPost_NewDuration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		Duration duration = new Duration();
		Calendar calendar = Calendar.getInstance();
		DurationModel durationModel = new DurationModel();
		
		duration.setName(new String(name.getBytes("ISO-8859-1"), "UTF-8"));
		duration.setStatus(true);
		if(durationModel.create(duration)) {
			duration.setStatus(false);
			durationModel.update(duration);
			request.getSession().setAttribute("msg", "Đăng kí thời hạn thành công");
			response.sendRedirect(request.getContextPath() + "/superadmin/duration");
		} else {
			request.getSession().setAttribute("msg", "Đăng kí thời hạn thất bại");
			response.sendRedirect(request.getContextPath() + "/superadmin/duration");
		}
	}

}
