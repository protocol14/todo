package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.TodoService;
import vo.Member;
import vo.Todo;


@WebServlet("/member/updateTodo")
public class UpdateTodoController extends HttpServlet {
	private TodoService todoService;
	private Todo todo;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 매개변수
		todo = new Todo();
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		
		// 디버그
		System.out.println("UpdateTodoController doGet todoNo : "+ todoNo);
		
		todo.setTodoNo(todoNo);
		todoService = new TodoService();
		List<Todo> todoList = todoService.getTodoListByOne(todo);
		
		request.setAttribute("todoList", todoList);
		
		request.getRequestDispatcher("/WEB-INF/view/updateTodo.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 매개변수
		todo = new Todo();
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		String todoDate = request.getParameter("todoDate");
		String todoContent =  request.getParameter("todoContent");
		String memberId = request.getParameter("memberId");
		String fontColor = request.getParameter("fontColor");
		
		System.out.println("UpdateTodoController doPost memberId : "+ memberId);
		System.out.println("UpdateTodoController doPost todoNo : "+ todoNo);
		System.out.println("UpdateTodoController doPost todoDate : "+ todoDate);
		System.out.println("UpdateTodoController doPost todoContent : "+ todoContent);
		System.out.println("UpdateTodoController doPost fontColor : "+ fontColor);
		
		// 객체 셋팅
		todo.setMemberId(memberId);
		todo.setTodoDate(todoDate);
		todo.setTodoNo(todoNo);
		todo.setTodoContent(todoContent);
		todo.setFontColor(fontColor);
		
		// 구현
		todoService = new TodoService();
		todoService.updateTodoService(todo);
		
		// todoDate 잘라서 년 월 일 배치
		String y = todoDate.substring(0, 4);
		String m = todoDate.substring(5, 7);
		String d = todoDate.substring(8, 10);
		
		response.sendRedirect(request.getContextPath()+"/member/todoList?y="+y+"&m="+m+"&d="+d);
	}

}
