package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TodoService;
import vo.Member;
import vo.Todo;

/**
 * Servlet implementation class TodoListController
 */
@WebServlet("/member/todoList")
public class TodoListController extends HttpServlet {
	
	private TodoService todoService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String y = request.getParameter("y");
		String m = request.getParameter("m");
		String d = request.getParameter("d");
		
		if(m.length()<2) {
			m = "0"+m;
		}
		
		if(d.length()<2) {
			d = "0"+d;
		}
		
		String todoDate = y+"-"+m+"-"+d;	
		String memberId = ((Member)(request.getSession().getAttribute("loginMember"))).getMemberId();
		Todo todo = new Todo();
		todo.setTodoDate(todoDate);
		todo.setMemberId(memberId);
		
		todoService = new TodoService();
		List<Todo> todoList = todoService.getTodoListByDate(todo);
		
		request.setAttribute("todoDate", todoDate);
		request.setAttribute("todoList", todoList);
		
		request.getRequestDispatcher("/WEB-INF/view/todoList.jsp").forward(request, response);
	}

}
