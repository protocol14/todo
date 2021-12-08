package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import commons.DBUtil;
import dao.NoticeDao;
import vo.Notice;

public class NoticeService {
	private NoticeDao notcieDao;
	
	// 공지 개별 출력
	public List<Notice> getNoticeOne(int noticeNo) {
		System.out.println("NoticeService getNoticeOne noticeNo : "+ noticeNo);
		List<Notice> list = null;

		try {
			notcieDao = new NoticeDao();
			list = notcieDao.selectNoticeOne(DBUtil.conn, noticeNo);
		} catch (SQLException e) {
			System.out.println("[Debug] NoticeService getNoticeOne - conn Exception");
			e.printStackTrace();
		}
		
		return list;
	}
	
	// 공지 로그인창에 5개만 출력
	public List<Notice> getNoticeList5() {
		List<Notice> list = new ArrayList<>();

		try {
			notcieDao = new NoticeDao();
			list = notcieDao.selectNoticeList5(DBUtil.conn);
		} catch (SQLException e) {
			System.out.println("[Debug] NoticeService getNoticeList5 - conn Exception");
			e.printStackTrace();
		}
		
		return list;
	}
	
	// 공지 전체 목록
	public List<Notice> getNoticeList() {
		List<Notice> list = new ArrayList<>();

		try {
			notcieDao = new NoticeDao();
			list = notcieDao.selectNoticeList(DBUtil.conn);
		} catch (SQLException e) {
			System.out.println("[Debug] NoticeService getNoticeList - conn Exception");
			e.printStackTrace();
		}
		
		return list;
	}
}
