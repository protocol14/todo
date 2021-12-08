package dao;

public class TodoQuery {
	public static final String DELETE_TODO;
	public static final String DELETE_TODO_BY_TODO_NO;
	public static final String SELECT_TODO_LIST_BY_DATE;
	public static final String SELECT_TODO_LIST_BY_NO;
	public static final String SELECT_TODO_LIST_BY_MONTH;
	public static final String INSERT_TODO;
	public static final String UPDATE_TODO;
	static {
		DELETE_TODO = "DELETE FROM todo WHERE member_id=?";
		SELECT_TODO_LIST_BY_MONTH = "SELECT todo_date FROM todo WHERE member_id=? AND SUBSTRING(todo_date, 1,7)=?";
		SELECT_TODO_LIST_BY_DATE = "SELECT * FROM todo WHERE member_id=? AND todo_date=? ORDER BY todo_date DESC";
		SELECT_TODO_LIST_BY_NO = "SELECT * FROM todo WHERE todo_no=?";
		INSERT_TODO = "INSERT INTO todo(member_id, todo_content, todo_date, create_date, update_date, font_color) VALUES(?,?,?,now(),now(),?)";
		DELETE_TODO_BY_TODO_NO = "DELETE FROM todo WHERE member_id=? AND todo_no=?";
		UPDATE_TODO = "UPDATE todo SET todo_content=?, update_date=NOW(), font_color=? WHERE member_id=? AND todo_no=?";
	}
}
