package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TodoService;
import vo.Member;
import vo.Todo;


@WebServlet("/member/addTodo")
public class AddTodoController extends HttpServlet {
	private TodoService todoService;
	private Todo todo;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String todoDate = request.getParameter("todoDate");
		String todoContent = request.getParameter("todoContent");
		String memberId = ((Member)(request.getSession().getAttribute("loginMember"))).getMemberId();
		String fontColor = request.getParameter("fontColor");
		
		System.out.println("AddTodoController - todoDate : "+ todoDate);
		System.out.println("AddTodoController - todoContent : "+ todoContent);
		System.out.println("AddTodoController - memberId : "+ memberId);
		System.out.println("AddTodoController - fontColor : "+ fontColor);
		
		// 객체 셋팅
		todo = new Todo();
		todo.setTodoDate(todoDate);
		todo.setTodoContent(todoContent);
		todo.setMemberId(memberId);
		todo.setFontColor(fontColor);
		
		// 구현
		todoService = new TodoService();
		todoService.insertTodo(todo);
		
		// todoDate 잘라서 년 월 일 배치
		String y = todoDate.substring(0, 4);
		String m = todoDate.substring(5, 7);
		String d = todoDate.substring(8, 10);
		
		response.sendRedirect(request.getContextPath()+"/member/todoList?y="+y+"&m="+m+"&d="+d);
	}

}
