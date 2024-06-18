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
import com.demo.models.AccountModel;
import com.demo.models.AccountPartialModel;
import com.demo.models.DurationModel;
import com.demo.models.FeedbackModel;
import com.demo.models.PostImageModel;
import com.demo.models.PostModel;
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

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
