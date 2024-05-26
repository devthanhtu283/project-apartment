package com.demo.servlet.user;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entities.Account;
import com.demo.entities.AccountService;
import com.demo.entities.Accountdetails;
import com.demo.entities.Duration;
import com.demo.entities.Invoice;
import com.demo.entities.Service;
import com.demo.helpers.PostHelper;
import com.demo.models.AccountDetailsModel;
import com.demo.models.AccountServiceModel;
import com.demo.models.DurationModel;
import com.demo.models.InvoiceModel;
import com.demo.models.ServiceModel;

/**
 * Servlet implementation class ServiceServlet
 */
@WebServlet("/plan")
public class PlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlanServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action == null) {
			doGet_Index(request, response);
		} else if (action.equalsIgnoreCase("buy")) {
			doGet_Buy(request, response);
		}
	}

	protected void doGet_Index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("activePlan", "active");
		request.setAttribute("p", "../user/plan.jsp");

		request.getRequestDispatcher("/WEB-INF/views/layout/user.jsp").forward(request, response);
	}

	protected void doGet_Buy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String serviceId = request.getParameter("id");
		int durationId = Integer.parseInt(request.getParameter("duration"));
		Calendar calendar = Calendar.getInstance();
		AccountServiceModel accountServiceModel = new AccountServiceModel();
		AccountDetailsModel accountDetailsModel = new AccountDetailsModel();
		ServiceModel serviceModel = new ServiceModel();
		DurationModel durationModel = new DurationModel();
		Duration duration = new Duration();
		int spaceIndex = durationModel.findById(durationId).getName().indexOf(' ');
	    String numberString = durationModel.findById(durationId).getName().substring(0, spaceIndex);
		calendar.add(Calendar.MONTH, Integer.parseInt(numberString));
		Date endDate = calendar.getTime();
		duration.setStatus(true);
		Account account = (Account) request.getSession().getAttribute("account");
		Accountdetails accountdetails = accountDetailsModel.findAccountByAccountID(account.getId());
		if (account == null) {
			request.getSession().setAttribute("msg", "Bạn cần đăng nhập để mua gói dịch vụ");
			response.sendRedirect("home");
		} else {
			accountdetails = accountDetailsModel.findAccountByAccountID(account.getId());
			if (accountdetails == null) {
				request.getSession().setAttribute("msg", "Bạn cần phải cập nhật thông tin tài khoản để nạp tiền");
				response.sendRedirect("account");
			} else {
				if (accountdetails.getBalance() > serviceModel.findByID(Integer.parseInt(serviceId)).getPrice()) {

					AccountService accountService = new AccountService();
					accountService.setAccountID(account.getId());
					accountService.setServiceID(Integer.parseInt(serviceId));
					accountService.setDurationID(durationId);
					accountService.setDescription(
							"Đăng kí gói: " + serviceModel.findByID(Integer.parseInt(serviceId)).getName() + " / " + durationModel.findById(durationId).getName());
					accountService.setCreated(new Date());
					accountService.setEndService(endDate);
					accountService.setStatus(true);
					accountService.setSaleID(0);
					if (accountServiceModel.register(accountService)) {
						accountdetails.setBalance(accountdetails.getBalance()
								- serviceModel.findByID(Integer.parseInt(serviceId)).getPrice());
						accountDetailsModel.update(accountdetails);
						request.getSession().removeAttribute("accountdetails");
						request.getSession().setAttribute("accountdetails", accountdetails);
						request.getSession().setAttribute("msg", "Mua thành công");
						response.sendRedirect("plan");
					} else {
						request.getSession().setAttribute("msg", "Mua thất bại");
						response.sendRedirect("plan");
					}

				} else {
					request.getSession().setAttribute("msg", "Bạn không đủ tiền để mua gói dịch vụ này");
					response.sendRedirect("plan");
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
