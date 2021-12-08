package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Notice;

public class NoticeDao {
	
	// 해당 공지사항 출력
	public List<Notice> selectNoticeOne(Connection conn, int noticeNo) throws SQLException {
		System.out.println("selectNoticeOne - noticeNo : "+ noticeNo);
		
		List<Notice> list = new ArrayList<>();
		PreparedStatement stmt = conn.prepareStatement(NoticeQuery.SELECT_NOTICE);
		stmt.setInt(1, noticeNo);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Notice notice = new Notice();
			notice.setNoticeNo(rs.getInt("noticeNo"));
			notice.setNoticeTitle(rs.getString("noticeTitle"));
			notice.setNoticeContent(rs.getString("noticeContent"));
			notice.setCreateDate(rs.getString("createDate"));
			notice.setUpdateDate(rs.getString("updateDate"));
			list.add(notice);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	// 로그인 화면에 공지사항 5개 띄우기
	public List<Notice> selectNoticeList5(Connection conn) throws SQLException {
		List<Notice> list = new ArrayList<>();
		PreparedStatement stmt = conn.prepareStatement(NoticeQuery.SELECT_NOTICE_LIST5);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Notice notice = new Notice();
			notice.setNoticeNo(rs.getInt("noticeNo"));
			notice.setNoticeTitle(rs.getString("noticeTitle"));
			notice.setCreateDate(rs.getString("createDate"));
			list.add(notice);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	// 전체 공지사항 목록
	public List<Notice> selectNoticeList(Connection conn) throws SQLException {
		List<Notice> list = new ArrayList<>();
		PreparedStatement stmt = conn.prepareStatement(NoticeQuery.SELECT_NOTICE_LIST);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Notice notice = new Notice();
			notice.setNoticeNo(rs.getInt("noticeNo"));
			notice.setNoticeTitle(rs.getString("noticeTitle"));
			notice.setNoticeContent(rs.getString("noticeContent"));
			notice.setCreateDate(rs.getString("createDate"));
			notice.setUpdateDate(rs.getString("updateDate"));
			list.add(notice);
		}
		rs.close();
		stmt.close();
		return list;
	}
}
