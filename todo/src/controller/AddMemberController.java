package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import service.TodoService;
import vo.Member;
 

@WebServlet("/addMember")
public class AddMemberController extends HttpServlet {
	private MemberService memberService;
	private Member member;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인하면 못들어옴
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null) { // 이미 로그인이 되어 있는 상태
			response.sendRedirect(request.getContextPath()+"/member/calendar");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/view/addMember.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		System.out.println("AddMember memberId : "+ memberId);
		System.out.println("AddMember memberPw : "+ memberPw);
		
		// 구현
		memberService = new MemberService();
		memberService.addMember(memberId, memberPw);
		
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}
	
}
