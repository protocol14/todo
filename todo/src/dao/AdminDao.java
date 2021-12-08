package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Admin;
import vo.Member;
import vo.Notice;

public class AdminDao {
	
	// 공지사항 삭제
	public void adminDeleteNoticeDao(Connection conn, int noticeNo) throws SQLException {
		System.out.println("AdminDao adminDeleteNoticeDao noticeNo : "+ noticeNo);
		
		String sql = AdminQuery.DELETE_NOTICE;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, noticeNo);
		
		stmt.executeQuery();
		
		stmt.close();
		
		return;
	}
	
	// 공지사항 업데이트
	public void adminUpdateNoticeDao(Connection conn, Notice notice) throws SQLException {
		System.out.println("AdminDao adminUpdateNoticeDao "+notice.toString());
		String sql = AdminQuery.UPDATE_NOTICE;
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, notice.getNoticeTitle());
		stmt.setString(2, notice.getNoticeContent());
		stmt.setInt(3, notice.getNoticeNo());
		
		stmt.executeQuery();
		
		stmt.close();
		
		return;
	}
	
	// 공지사항 추가
	public void adminInsertNoticeDao(Connection conn, Notice notice) throws SQLException {
		System.out.println("AdminDao adminInsertNoticeDao "+notice.toString());
		String sql = AdminQuery.INSERT_NOTICE;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, notice.getNoticeNo());
		stmt.setString(2, notice.getNoticeTitle());
		stmt.setString(3, notice.getNoticeContent());
		
		stmt.executeQuery();
		
		stmt.close();
		
		return;
	}
	
	// 회원 강제 탈퇴
	public void adminDeleteMemberDao(Connection conn, String memberId) throws SQLException {
		System.out.println("AdminDao adminDeleteMemberDao memberId : "+ memberId);
		String sql = AdminQuery.DELETE_MEMBER;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberId);
		stmt.executeQuery();
		
		stmt.close();
		
		return;
	}
	
	// 회원 목록
	public List<Member> adminSelectMemberDao(Connection conn) throws SQLException {
		List<Member> memberList = new ArrayList<>();
		String sql = AdminQuery.SELECT_MEMBER;
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Member member = new Member();
			member.setMemberId(rs.getString("memberId"));
			member.setCreateDate(rs.getString("createDate"));
			member.setUpdateDate(rs.getString("updateDate"));
			memberList.add(member);
		}
		
		rs.close();
		stmt.close();
		return memberList;
	}
	
	// 로그인 메소드
	public Admin adminLoginDao(Connection conn, Admin paramAdmin) throws SQLException {
		System.out.println("AdminDao adminLoginDao "+paramAdmin.toString());
		
		Admin loginAdmin = null;
		// sql문 분리
		String sql = AdminQuery.ADMIN_LOGIN;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, paramAdmin.getAdminId());
		stmt.setString(2, paramAdmin.getAdminPw());
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			loginAdmin = new Admin();
			loginAdmin.setAdminId(rs.getString("adminId"));
		}
		
		rs.close();
		stmt.close();
		return loginAdmin;
	}
}
