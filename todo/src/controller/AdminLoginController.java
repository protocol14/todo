package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AdminService;
import vo.Admin;


@WebServlet("/adminLogin")
public class AdminLoginController extends HttpServlet {
	private AdminService adminService;
	private Admin admin;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null) { // 이미 로그인이 되어 있는 상태
			response.sendRedirect(request.getContextPath()+"/member/calendar");
			return;
		}
		if(session.getAttribute("loginAdmin") != null) { // 이미 로그인이 되어 있는 상태
			response.sendRedirect(request.getContextPath()+"/admin/adminIndex");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/view/adminLogin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		admin = new Admin();
		String adminId = request.getParameter("adminId");
		String adminPw = request.getParameter("adminPw");
		admin.setAdminId(adminId);
		admin.setAdminPw(adminPw);
		
		adminService = new AdminService();
		Admin loginAdmin = adminService.adminLoginService(admin);
		if(loginAdmin == null) {
			response.sendRedirect(request.getContextPath()+"/adminLogin");
			return;
		}
		HttpSession session = request.getSession();
		session.setAttribute("loginAdmin", loginAdmin);
		
		response.sendRedirect(request.getContextPath()+"/admin/adminIndex");
	}

}
