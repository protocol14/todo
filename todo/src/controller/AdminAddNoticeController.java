package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;
import vo.Notice;


@WebServlet("/admin/adminAddNotice")
public class AdminAddNoticeController extends HttpServlet {
	AdminService adminService;
	Notice notice;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		
		System.out.println("AdminAddNoticeController - noticeTitle : "+ noticeTitle);
		System.out.println("AdminAddNoticeController - noticeContent : "+ noticeContent);
		
		notice = new Notice();
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		
		adminService = new AdminService();
		adminService.adminInsertNoticeService(notice);
		
		response.sendRedirect(request.getContextPath()+"/admin/adminNotice");
	}

}
