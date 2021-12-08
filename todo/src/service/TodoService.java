package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import commons.DBUtil;
import dao.TodoDao;
import vo.Todo;

public class TodoService {
	private TodoDao todoDao;
	
	// todo 업데이트
	public void updateTodoService(Todo todo) {
		System.out.println("TodoService updateTodoService "+todo.toString());

		try {
			todoDao = new TodoDao();
			todoDao.updateTodoDao(DBUtil.conn, todo);
		} catch(Exception e) {
			System.out.println("[Debug] TodoService updateTodoService - conn Exception");
			e.printStackTrace();
		}
		
		return;
	}
	
	// 해당 todo 삭제
	public void deleteTodoOneService(Todo todo) {
		System.out.println("TodoService deleteTodoOneService "+todo.toString());

		try {
			todoDao = new TodoDao();
			todoDao.deleteTodoOneDao(DBUtil.conn, todo);
		} catch(Exception e) {
			System.out.println("[Debug] TodoService deleteTodoOneService - conn Exception");
			e.printStackTrace();
		}
		
		return;
	}
	
	// 일정 추가
	public void insertTodo(Todo todo) {
		System.out.println("TodoService insertTodo "+todo.toString());

		try {
			todoDao = new TodoDao();
			todoDao.insertTodo(DBUtil.conn, todo);
		} catch(Exception e) {
			System.out.println("[Debug] TodoService insertTodo - conn Exception");
			e.printStackTrace();
		}
		
		return;
	}
	
	// 해당 유저의 ID로 일정 뽑아내기
	public List<Todo> getTodoListByMonth(String memberId, String ym) {
		System.out.println("TodoService getTodoListByMonth memberId : "+memberId);
		System.out.println("TodoService getTodoListByMonth targetMonth : "+ym);
	      List<Todo> list = null;   

	      try {
	         todoDao = new TodoDao();
	         list = todoDao.selectTodoListByMonth(DBUtil.conn, memberId, ym);
	      } catch(Exception e) {
	    	  System.out.println("[Debug] TodoService getTodoListToDate - conn Exception");
	         e.printStackTrace();
	      }
	      
	      return list;
	   }
	
	// 해당 todo_no로 데이터 뽑아내기
	public List<Todo> getTodoListByOne(Todo todo) {
		System.out.println("TodoService getTodoListByOne "+todo.toString());
	      List<Todo> list = null;   

	      try {
	         todoDao = new TodoDao();
	         list = todoDao.selectTodoListOne(DBUtil.conn, todo);
	      } catch(Exception e) {
	    	  System.out.println("[Debug] TodoService getTodoListByOne - conn Exception");
	         e.printStackTrace();
	      }
	      
	      return list;
	   }
	
	// 해당 유저의 일정으로 데이터 뽑아내기
	public List<Todo> getTodoListByDate(Todo todo) {
		System.out.println("TodoService getTodoListByDate "+todo.toString());
	      List<Todo> list = null;   

	      try {
	         todoDao = new TodoDao();
	         list = todoDao.selectTodoListByDate(DBUtil.conn, todo);
	      } catch(Exception e) {
	    	  System.out.println("[Debug] TodoService getTodoListByDate - conn Exception");
	         e.printStackTrace();
	      }
	      
	      return list;
	   }
}
