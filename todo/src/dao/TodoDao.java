package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Todo;

public class TodoDao {
	// todo 업데이트
	public void updateTodoDao(Connection conn, Todo todo) throws SQLException {
		System.out.println("TodoDao updateTodoDao "+todo.toString());
		
		String sql = TodoQuery.UPDATE_TODO;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getTodoContent());
		stmt.setString(2, todo.getFontColor());
		stmt.setString(3, todo.getMemberId());
		stmt.setInt(4, todo.getTodoNo());
		stmt.executeUpdate();
		
		stmt.close();
	}
	
	// 해당 todo 삭제
	public void deleteTodoOneDao(Connection conn, Todo todo) throws SQLException {
		System.out.println("TodoDao deleteTodoOneDao "+todo.toString());
		
		String sql = TodoQuery.DELETE_TODO_BY_TODO_NO;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getMemberId());
		stmt.setInt(2, todo.getTodoNo());
		stmt.executeUpdate();
		
		stmt.close();
	}
	
	// 일정 추가
	public void insertTodo(Connection conn, Todo todo) throws SQLException {
		System.out.println("TodoDao insertTodo "+todo.toString());
		
		String sql = TodoQuery.INSERT_TODO;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getMemberId());
		stmt.setString(2, todo.getTodoContent());
		stmt.setString(3, todo.getTodoDate());
		stmt.setString(4, todo.getFontColor());
		stmt.executeUpdate();
		
		stmt.close();
	}
	
	// 해당 유저의 해당 월 일정 뽑아내기
	public List<Todo> selectTodoListByMonth(Connection conn, String memberId, String ym) throws SQLException{
		System.out.println("TodoDao selectTodoListToDate memberId : "+memberId);
		System.out.println("TodoDao selectTodoListToDate targetMonth : "+ym);
		
		List<Todo> list = new ArrayList<>();
		String sql = TodoQuery.SELECT_TODO_LIST_BY_MONTH;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberId);
		stmt.setObject(2, ym);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Todo t = new Todo();
			t.setTodoDate(rs.getString("todo_date"));
	        list.add(t);		
		}
		
		return list;
	}
	
	// 해당 유저의 일정으로 데이터 뽑아내기
	public List<Todo> selectTodoListByDate(Connection conn, Todo todo) throws SQLException{
		System.out.println("TodoDao selectTodoListByDate "+todo.toString());
		
		List<Todo> list = new ArrayList<>();
		String sql = TodoQuery.SELECT_TODO_LIST_BY_DATE;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getMemberId());
		stmt.setString(2, todo.getTodoDate());
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Todo t = new Todo();
			t.setTodoNo(rs.getInt("todo_no"));
			t.setTodoContent(rs.getString("todo_content"));
			t.setTodoDate(rs.getString("todo_date"));
			t.setCreateDate(rs.getString("create_date"));
			t.setUpdateDate(rs.getString("update_date"));
			t.setFontColor(rs.getString("font_color"));
	        list.add(t);		
		}
		
		return list;
	}
	
	// 해당 todo_no로 데이터 뽑아내기
	public List<Todo> selectTodoListOne(Connection conn, Todo todo) throws SQLException{
		System.out.println("TodoDao selectTodoListOne "+todo.toString());
		
		List<Todo> list = new ArrayList<>();
		String sql = TodoQuery.SELECT_TODO_LIST_BY_NO;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, todo.getTodoNo());
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Todo t = new Todo();
			t.setTodoNo(rs.getInt("todo_no"));
			t.setTodoContent(rs.getString("todo_content"));
			t.setTodoDate(rs.getString("todo_date"));
			t.setCreateDate(rs.getString("create_date"));
			t.setUpdateDate(rs.getString("update_date"));
			t.setFontColor(rs.getString("font_color"));
	        list.add(t);		
		}
		
		return list;
	}
	
	// 일정 삭제
	public void deleteTodo(Connection conn, String memberId) throws SQLException {
		System.out.println("deleteTodo - memberId : "+ memberId);
		
		String sql = TodoQuery.DELETE_TODO;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberId);
		stmt.executeUpdate();
		stmt.close();
	}

}
