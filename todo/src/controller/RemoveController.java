package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

@WebServlet("/member/removeMember")
public class RemoveController extends HttpServlet {
	private MemberService memberService;
	private Member member;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 방어코드 필터에 존재
		request.getRequestDispatcher("/WEB-INF/view/removeMemberCheck.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 회원탈퇴 정보
		HttpSession session = request.getSession();
		member = new Member();
		Member loginMember = (Member)session.getAttribute("loginMember");
		String memberId = loginMember.getMemberId();
		String memberPw = request.getParameter("memberPw");
		
		// 디버그
		System.out.println("RemoveController - memberId : "+memberId);
		System.out.println("RemoveController - memberPw : "+memberPw);
		
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		// 탈퇴 처리 실행
		memberService = new MemberService();
		boolean removeMember = memberService.removeMember(memberId, memberPw);
		
		// 정상적으로 true값이 반환되면 로그아웃
		if(removeMember) {
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/view/removeMemberCheck.jsp").forward(request, response);
	}

}
