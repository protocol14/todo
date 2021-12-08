package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;


@WebServlet("/admin/adminRemoveNotice")
public class AdminRemoveNoticeController extends HttpServlet {
	AdminService adminService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		System.out.println("AdminRemoveNoticeController - noticeNo : "+ noticeNo);
		
		adminService = new AdminService();
		adminService.adminDeleteNoticeService(noticeNo);
		
		response.sendRedirect(request.getContextPath()+"/admin/adminNotice");
		
	}

}
