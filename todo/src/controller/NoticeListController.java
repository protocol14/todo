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


@WebServlet("/noticeList")
public class NoticeListController extends HttpServlet {
	private NoticeService noticeService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		noticeService = new NoticeService();
		List<Notice> noticeList = noticeService.getNoticeList();
		request.setAttribute("noticeList", noticeList);

		request.getRequestDispatcher("/WEB-INF/view/selectNoticeList.jsp").forward(request, response);
	}
}
