package dao;

public class AdminQuery {
	public static final String ADMIN_LOGIN;
	public static final String SELECT_MEMBER;
	public static final String DELETE_MEMBER;
	public static final String INSERT_NOTICE;
	public static final String UPDATE_NOTICE;
	public static final String DELETE_NOTICE;
	static {
		ADMIN_LOGIN = "SELECT admin_id adminId, admin_pw adminPW FROM admin WHERE admin_id=? AND admin_pw=?";
		SELECT_MEMBER = "SELECT m.member_id memberId, m.create_date createDate, m.update_date updateDate FROM member AS m INNER JOIN admin AS a ON m.member_id != a.admin_id";
		DELETE_MEMBER = "DELETE FROM member WHERE member_id=?";
		INSERT_NOTICE = "INSERT INTO notice(notice_no,notice_title,notice_content,create_date,update_date) VALUES(?,?,?,NOW(),NOW())";
		UPDATE_NOTICE = "UPDATE notice SET notice_title=?, notice_content=?, update_date=NOW() WHERE notice_no=?";
		DELETE_NOTICE = "DELETE FROM notice WHERE notice_no=?";
	}
}
