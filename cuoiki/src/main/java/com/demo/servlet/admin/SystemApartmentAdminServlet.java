package com.demo.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.models.PostModel;
import com.demo.models.SystemApartmentImageModel;
import com.demo.models.SystemApartmentModel;
import com.google.gson.Gson;
@WebServlet({"/admin/systemapartment"})
/**
 * Servlet implementation class AccountAdminServlet
 */
public class SystemApartmentAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemApartmentAdminServlet() {
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
		} else if(action.equalsIgnoreCase("searchBySubject")) {
			doGet_SearchBySubject(request, response);
		} else if(action.equalsIgnoreCase("deleteSystem")) {
			doGet_DeleteSystemApart(request, response);
		}
	}
	protected void doGet_Index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("admin", "../admin/systemapartment.jsp");
		request.setAttribute("activeAdminSystem", "active");
		SystemApartmentModel systemApartmentModel = new SystemApartmentModel();
		request.setAttribute("systemapartment", systemApartmentModel.findAll());
		request.getRequestDispatcher("/WEB-INF/views/layout/admin.jsp").forward(request, response);
	}
	
	protected void doGet_SearchBySubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		String subject = request.getParameter("subject");
		SystemApartmentModel systemApartmentModel = new SystemApartmentModel();
		Gson gson = new Gson();
		writer.print(gson.toJson(systemApartmentModel.findSystemApartByDistrict(subject)));
	}
	
	protected void doGet_DeleteSystemApart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SystemApartmentImageModel systemApartmentImageModel = new SystemApartmentImageModel();
		SystemApartmentModel systemApartmentModel = new SystemApartmentModel();
		int id = Integer.parseInt(request.getParameter("id"));
		if(systemApartmentImageModel.delete(id)) {
			if(systemApartmentModel.delete(id)) {
				request.getSession().setAttribute("msg", "Xóa căn hộ hệ thống thành công");
				response.sendRedirect(request.getContextPath() + "/admin/systemapartment");
			} else {
				request.getSession().setAttribute("msg", "Xóa căn hộ hệ thống thất bại");
				response.sendRedirect(request.getContextPath() + "/admin/systemapartment");
			}
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
