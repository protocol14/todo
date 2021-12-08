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
import vo.Todo;


@WebServlet("/member/removeTodo")
public class RemoveTodoController extends HttpServlet {
	private TodoService todoService;
	private Todo todo;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 매개변수
		HttpSession session = request.getSession();
		todo = new Todo();
		Member loginMember = (Member)session.getAttribute("loginMember");
		String memberId = loginMember.getMemberId();
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		String todoDate = request.getParameter("todoDate");
		
		// 디버그
		System.out.println("DeleteTodo - memberId : "+ memberId);
		System.out.println("DeleteTodo - todoNo : "+ todoNo);
		System.out.println("DeleteTodo - todoDate : "+ todoDate);
		
		todo.setMemberId(memberId);
		todo.setTodoNo(todoNo);
				
		// Todo 제거
		todoService = new TodoService();
		todoService.deleteTodoOneService(todo);
		
		// todoDate 잘라서 년 월 일 배치
		String y = todoDate.substring(0, 4);
		String m = todoDate.substring(5, 7);
		String d = todoDate.substring(8, 10);
		
		response.sendRedirect(request.getContextPath()+"/member/todoList?y="+y+"&m="+m+"&d="+d);
		
	}

}
