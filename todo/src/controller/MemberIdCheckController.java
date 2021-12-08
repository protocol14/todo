package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.Member;


@WebServlet("/memberIdCheck")
public class MemberIdCheckController extends HttpServlet {
	private MemberService memberService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberIdCheck");
		
		System.out.println("MemberIdCheck memberId : "+ memberId);
		
		// 구현
		memberService = new MemberService();
		boolean idCheck;
		// 실행과 동시에 false값을 받아오면 memberId값을 반환하지 않음
		if((idCheck = memberService.memberIdCheckService(memberId)) == false) {
			request.getRequestDispatcher("/WEB-INF/view/addMember.jsp?idCheck="+idCheck).forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/view/addMember.jsp?idCheck="+idCheck+"&memberId="+memberId).forward(request, response);
	}

}
