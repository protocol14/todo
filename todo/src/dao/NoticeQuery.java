package dao;

public class NoticeQuery {
	public static final String SELECT_NOTICE_LIST;
	public static final String SELECT_NOTICE_LIST5;
	public static final String SELECT_NOTICE;
	static {
		SELECT_NOTICE_LIST = "SELECT notice_no noticeNo, notice_title noticeTitle, notice_content noticeContent, create_date createDate, update_date updateDate FROM notice ORDER BY create_date DESC";
		SELECT_NOTICE_LIST5 = "SELECT notice_no noticeNo, notice_title noticeTitle, create_date createDate FROM notice ORDER BY create_date DESC LIMIT 0,5";
		SELECT_NOTICE = "SELECT notice_no noticeNo, notice_title noticeTitle, notice_content noticeContent, create_date createDate, update_date updateDate FROM notice WHERE notice_no=?";
	}
}
