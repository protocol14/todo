package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;

@WebServlet("/admin/adminRemoveMember")
public class AdminRemoveMemberController extends HttpServlet {
	AdminService adminService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		System.out.println("adminRemoveMember doGet memberId : "+ memberId);
		
		adminService = new AdminService();
		adminService.adminDeleteMemberService(memberId);
		
		request.getRequestDispatcher("/WEB-INF/view/admin/managementMember.jsp").forward(request, response);
	}

}
