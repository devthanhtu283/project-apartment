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
import com.demo.models.AccountModel;
import com.demo.models.AccountPartialModel;
import com.demo.models.DurationModel;
import com.demo.models.FeedbackModel;
import com.demo.models.SaleModel;
import com.demo.models.SystemApartmentModel;
import com.google.gson.Gson;
@WebServlet({"/superadmin/sale"})
/**
 * Servlet implementation class AccountAdminServlet
 */
public class SaleAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaleAdminServlet() {
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
		} else if(action.equalsIgnoreCase("searchByName")) {
			doGet_SearchByName(request, response);
		} else if(action.equalsIgnoreCase("deleteSale")) {
			doGet_DeleteSale(request, response);
		}
	}
	protected void doGet_Index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("admin", "../admin/sales.jsp");
		request.setAttribute("activeAccount", "active");
		SaleModel saleModel = new SaleModel();
		request.setAttribute("sale", saleModel.findAll());
		
		

		request.getRequestDispatcher("/WEB-INF/views/layout/admin.jsp").forward(request, response);
	}
	
	protected void doGet_SearchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		String name = request.getParameter("name");
		SaleModel saleModel = new SaleModel();
		Gson gson = new Gson();
		writer.print(gson.toJson(saleModel.findSaleByName(name)));
	}
	
	protected void doGet_DeleteSale(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SaleModel saleModel = new SaleModel();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Sale sale = saleModel.findSaleById(id);
		sale.setStatus(false);
		if(saleModel.update(sale)) {
			request.getSession().setAttribute("msg", "Đã xóa doanh thu thành công");
			response.sendRedirect(request.getContextPath() + "/superadmin/sale");
			
		} else {
			System.out.println(1);
			response.sendRedirect(request.getContextPath() + "/superadmin/sale");
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
