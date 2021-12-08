package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Member;

public class MemberDao {
	// 회원가입 아이디 중복체크
	public boolean memberIdCheckDao(Connection conn, String memberId) throws SQLException {
		System.out.println("MemberDao memberIdCheckDao memberId : "+ memberId);
		
		boolean result = true;
		
		// 비밀번호가 존재할 시 false 반환
		String sql = MemberQuery.SELECT_MEMBER_PW;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberId);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) { // 값이 존재하면
			result = false;
			return result;
		}

		return result;
	}
	
	// 멤버 추가
	public void insertMember(Connection conn, String memberId, String memberPw) throws SQLException {
		System.out.println("MemberDao insertMember memberId : "+ memberId);
		System.out.println("MemberDao insertMember memberPw : "+ memberPw);
		
		String sql = MemberQuery.INSERT_MEMBER;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberId);
		stmt.setString(2, memberPw);
		stmt.executeQuery();
		
		stmt.close();
	}
	
	// 멤버 삭제
	public boolean deleteMember(Connection conn, String memberId, String memberPw) throws SQLException {
		System.out.println("MemberDao insertMember memberId : "+ memberId);
		System.out.println("MemberDao insertMember memberPw : "+ memberPw);
		
		boolean result = true;
		String sql;
		
		// 비밀번호가 틀릴 시 false 반환
		sql = MemberQuery.SELECT_MEMBER_PW;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberId);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			String MEMBER_PW = rs.getString("member_pw");
			if(!(MEMBER_PW.equals(memberPw))) {
				result = false;
				return result;
			}
		}
		
		sql = MemberQuery.DELETE_MEMBER;
		PreparedStatement stmt2 = conn.prepareStatement(sql);
		stmt2.setString(1, memberId);
		stmt2.setString(2, memberPw);
		stmt2.executeUpdate();
		
		stmt2.close();
		rs.close();
		stmt.close();
		
		return result;
	}
	
	
	// 로그인 메소드
	public Member login(Connection conn, Member paramMeber) throws SQLException {
		System.out.println("MemberDao login "+paramMeber.toString());
		
		Member loginMember = null;
		// sql문 분리
		String sql = MemberQuery.LOGIN;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, paramMeber.getMemberId());
		stmt.setString(2, paramMeber.getMemberPw());
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			loginMember = new Member();
			loginMember.setMemberId(rs.getString("memberId"));
		}
		
		rs.close();
		stmt.close();
		return loginMember;
	}
}
