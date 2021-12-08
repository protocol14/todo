package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;
import vo.Member;


@WebServlet("/admin/managementMember")
public class AdminManagementMemberController extends HttpServlet {
	AdminService adminService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		adminService = new AdminService();
		List<Member> memberList = adminService.adminSelectMemberService();
		
		request.setAttribute("memberList", memberList);
		
		request.getRequestDispatcher("/WEB-INF/view/admin/managementMember.jsp").forward(request, response);
		
	}

}
