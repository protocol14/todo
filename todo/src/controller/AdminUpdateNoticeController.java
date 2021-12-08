package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;
import service.NoticeService;
import vo.Notice;

@WebServlet("/admin/adminUpdateNotice")
public class AdminUpdateNoticeController extends HttpServlet {
	AdminService adminService;
	NoticeService noticeService;
	Notice notice;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		System.out.println("AdminUpdateNoticeController doGet noticeNo : "+ noticeNo);
		
		noticeService = new NoticeService();
		List<Notice> noticeList = noticeService.getNoticeOne(noticeNo);
		
		request.setAttribute("noticeList", noticeList);
		
		request.getRequestDispatcher("/WEB-INF/view/admin/updateNotice.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		notice = new Notice();
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		
		System.out.println("AdminUpdateNoticeController doPost noticeNo : "+ noticeNo);
		System.out.println("AdminUpdateNoticeController doPost noticeTitle : "+ noticeTitle);
		System.out.println("AdminUpdateNoticeController doPost noticeContent : "+ noticeContent);
		
		notice.setNoticeNo(noticeNo);
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		
		adminService = new AdminService();
		adminService.adminUpdateNoticeService(notice);
		
		response.sendRedirect(request.getContextPath()+"/admin/adminNotice");
	}

}
