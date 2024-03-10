package com.demo.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entities.Systemapartment;
import com.demo.models.BranchModel;
import com.demo.models.SystemApartmentModel;
import com.google.gson.Gson;
@WebServlet("/systemapartment")
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null) {
			doGet_Index(request, response);
		} else if(action.equalsIgnoreCase("searchByDistrict")) {
			doGet_searchByDistrict(request, response);
		} else if(action.equalsIgnoreCase("searchByPrice")) {
			doGet_searchByPrice(request, response);
		} else if(action.equalsIgnoreCase("searchByPriceOver5")) {
			doGet_searchByPriceOver5(request, response);
		} else if(action.equalsIgnoreCase("searchByBedroom")) {
			doGet_searchByBedroom(request, response);
		} else if(action.equalsIgnoreCase("searchByArea")) {
			doGet_searchByArea(request, response);
		}
	}
	protected void doGet_Index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SystemApartmentModel systemApartmentModel = new SystemApartmentModel();
		request.setAttribute("systemapartments", systemApartmentModel.findAll());
		request.setAttribute("activeSystem", "active");
		request.setAttribute("p", "../user/systemapartment.jsp");
		request.getRequestDispatcher("/WEB-INF/views/layout/user.jsp").forward(request, response);
	}
	
	protected void doGet_searchByDistrict(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		String district = request.getParameter("district");
		SystemApartmentModel systemApartmentModel = new SystemApartmentModel();
		Gson gson = new Gson();
		writer.print(gson.toJson(systemApartmentModel.findSystemApartByDistrict(district)));
	}
	
	protected void doGet_searchByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		double price = Double.parseDouble(request.getParameter("price"));
		SystemApartmentModel systemApartmentModel = new SystemApartmentModel();
		Gson gson = new Gson();
		writer.print(gson.toJson(systemApartmentModel.findSystemApartByPrice(price)));
	}
	
	protected void doGet_searchByPriceOver5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		double price = Double.parseDouble(request.getParameter("price"));
		SystemApartmentModel systemApartmentModel = new SystemApartmentModel();
		Gson gson = new Gson();
		writer.print(gson.toJson(systemApartmentModel.findSystemApartByPriceOver5(price)));
	}
	
	protected void doGet_searchByBedroom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		int bedroom = Integer.parseInt(request.getParameter("bedroom"));
		SystemApartmentModel systemApartmentModel = new SystemApartmentModel();
		Gson gson = new Gson();
		writer.print(gson.toJson(systemApartmentModel.findSystemApartByBedroom(bedroom)));
	}
	
	protected void doGet_searchByArea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		double area = Double.parseDouble(request.getParameter("area"));
		SystemApartmentModel systemApartmentModel = new SystemApartmentModel();
		Gson gson = new Gson();
		writer.print(gson.toJson(systemApartmentModel.findSystemApartByArea(area)));
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
