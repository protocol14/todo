package service;

import java.sql.Connection;
import java.sql.SQLException;

import commons.DBUtil;
import dao.MemberDao;
import dao.TodoDao;
import vo.Member;

public class MemberService {
	private MemberDao memberDao;
	private TodoDao todoDao;
	
	// 아이디 중복 체크
	public boolean memberIdCheckService(String memberId) {
		System.out.println("MemberService memberIdCheckService memberId : "+ memberId);
		
		boolean result = true;

		try {
			memberDao = new MemberDao();
			
			// 중복 = false
			if(memberDao.memberIdCheckDao(DBUtil.conn, memberId) == false) {
				return false;
			}
			
			result=true;
		}catch(Exception e){
			e.printStackTrace();
			try {
				DBUtil.conn.rollback();
			}catch(SQLException e1) {
				System.out.println("[Debug] MemberService memberIdCheckService - conn Exception");
				e1.printStackTrace();
			}
		}
		
		return result;
	}
	
	// 회원가입 실행
	public void addMember(String memberId, String memberPw) {
		System.out.println("MemberService addMember memberId : "+ memberId);
		System.out.println("MemberService addMember memberPw : "+ memberPw);
		
		try {
			memberDao = new MemberDao();
			memberDao.insertMember(DBUtil.conn, memberId, memberPw);
		}catch(Exception e) {
			System.out.println("[Debug] MemberService addMember - conn Exception");
			e.printStackTrace();
		}
		
		return;
	}
	
	// 회원탈퇴 실행
	public boolean removeMember(String memberId, String memberPw) {
		System.out.println("MemberService removeMember memberId : "+ memberId);
		System.out.println("MemberService removeMember memberPw : "+ memberPw);
		
		boolean result = false;
		try {
			DBUtil.conn.setAutoCommit(false);
			todoDao = new TodoDao();
			memberDao = new MemberDao();
			
			todoDao.deleteTodo(DBUtil.conn, memberId);
			
			// 비밀번호가 틀릴 시 에러 생성
			if(memberDao.deleteMember(DBUtil.conn, memberId, memberPw) == false) {
				throw new Exception();
			}
			
			DBUtil.conn.commit();
			result=true;
		}catch(Exception e){
			e.printStackTrace();
			try {
				DBUtil.conn.rollback();
			}catch(SQLException e1) {
				System.out.println("[Debug] MemberService removeMember - conn Exception");
				e1.printStackTrace();
			}
		}
		
		return result;
	}
	
	// 로그인 실행
	public Member login(Member member) {
		System.out.println("MemberService login "+member.toString());
		
		Member loginMember = null;
		try {
			memberDao = new MemberDao();
			loginMember = memberDao.login(DBUtil.conn, member);
		}catch(Exception e) {
			System.out.println("[Debug] MemberService login - conn Exception");
			e.printStackTrace();
		}
		
		return loginMember;
	}
}
