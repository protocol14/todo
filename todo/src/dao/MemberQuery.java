package dao;


// sql문 분리
public class MemberQuery {
	public static final String LOGIN;
	public static final String DELETE_MEMBER;
	public static final String SELECT_MEMBER_PW;
	public static final String INSERT_MEMBER;
	static {
		LOGIN = "SELECT member_id memberId FROM member WHERE member_id=? AND member_pw = ?";
		DELETE_MEMBER = "DELETE FROM member WHERE member_id=? AND member_pw=?";
		SELECT_MEMBER_PW = "SELECT member_pw FROM member WHERE member_id=?";
		INSERT_MEMBER = "INSERT INTO member(member_id, member_pw, create_date, update_date) VALUES(?,?,NOW(),NOW())";
	}
}
