package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import commons.DBUtil;
import dao.AdminDao;
import vo.Admin;
import vo.Member;
import vo.Notice;

public class AdminService {
	private AdminDao adminDao;
	
	// 공지사항 삭제
	public void adminDeleteNoticeService(int noticeNo) {
		System.out.println("AdminService adminDeleteNoticeService noticeNo : "+ noticeNo);
		
		try {
			adminDao = new AdminDao();
			adminDao.adminDeleteNoticeDao(DBUtil.conn, noticeNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
		
	}
	
	// 공지사항 수정
	public void adminUpdateNoticeService(Notice notice) {
		System.out.println("AdminService adminUpdateNoticeService "+notice.toString());
		
		try {
			adminDao = new AdminDao();
			adminDao.adminUpdateNoticeDao(DBUtil.conn, notice);
		}catch(Exception e) {
			System.out.println("[Debug] AdminService adminUpdateNoticeService - conn Exception");
			e.printStackTrace();
		}
		
		return;
		
	}
	
	// 공지사항 추가
	public void adminInsertNoticeService(Notice notice) {
		System.out.println("AdminService adminInsertNoticeService "+notice.toString());

		try {
			adminDao = new AdminDao();
			adminDao.adminInsertNoticeDao(DBUtil.conn, notice);
		}catch(Exception e) {
			System.out.println("[Debug] AdminService adminInsertNoticeService - conn Exception");
			e.printStackTrace();
		}
		
		return;
	}
	
	// 회원 강제 탈퇴
	public void adminDeleteMemberService(String memberId) {
		System.out.println("AdminService adminDeleteMemberDao memberId : "+ memberId);
		
		try {
			adminDao = new AdminDao();
			adminDao.adminDeleteMemberDao(DBUtil.conn, memberId);
		}catch(Exception e) {
			System.out.println("[Debug] AdminService adminDeleteMemberDao - conn Exception");
			e.printStackTrace();
		}
		
		return;
	}
	
	// 회원 목록 뽑아내기
	public List<Member> adminSelectMemberService() {
		List<Member> memberList = new ArrayList<>();
		
		try {
			adminDao = new AdminDao();
			memberList = adminDao.adminSelectMemberDao(DBUtil.conn);
		}catch(Exception e) {
			System.out.println("[Debug] AdminService adminSelectMemberService - conn Exception");
			e.printStackTrace();
		}
		
		return memberList;
	}
	
	// 로그인 실행
	public Admin adminLoginService(Admin admin) {
		System.out.println("AdminService adminLoginService "+admin.toString());
		
		Admin loginAdmin = null;
		try {
			adminDao = new AdminDao();
			loginAdmin = adminDao.adminLoginDao(DBUtil.conn, admin);
		}catch(Exception e) {
			System.out.println("[Debug] AdminService adminLoginService - conn Exception");
			e.printStackTrace();
		}
		
		return loginAdmin;
	}
}
