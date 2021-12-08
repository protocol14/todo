package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import service.NoticeService;
import vo.Member;
import vo.Notice;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private MemberService memberService;
	private Member member;
	private NoticeService noticeService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login 폼페이지
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null) { // 이미 로그인이 되어 있는 상태
			response.sendRedirect(request.getContextPath()+"/member/calendar");
			return;
		}
		
		noticeService = new NoticeService();
		List<Notice> noticeList = noticeService.getNoticeList5();
		request.setAttribute("noticeList", noticeList);

		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login 액션
		// request.setCharacterEncoding("utf-8"); // doPost 상단에 무조건 배치시켜야함. 한글 인코딩. -> 공통된 로직 중복 -> 필터 사용
		
		member = new Member();
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		memberService = new MemberService();
		Member loginMember = memberService.login(member);
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		 
		HttpSession session = request.getSession();
		session.setAttribute("loginMember", loginMember);
		
		response.sendRedirect(request.getContextPath()+"/member/calendar");
	}

}
