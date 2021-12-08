package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticeService;
import vo.Notice;


@WebServlet("/noticeOne")
public class NoticeController extends HttpServlet {
	private NoticeService noticeService;
	private Notice notice;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		System.out.println("NoticeController doGet noticeNo : "+ noticeNo);
		
		noticeService = new NoticeService();
		List<Notice> noticeElement = noticeService.getNoticeOne(noticeNo);
		
		request.setAttribute("noticeElement", noticeElement);
		
		request.getRequestDispatcher("/WEB-INF/view/selectNoticeOne.jsp?noticeNo="+noticeNo).forward(request, response);
	}

}
