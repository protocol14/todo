package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CalendarService;
import service.TodoService;
import vo.Member;
import vo.Todo;

@WebServlet("/member/calendar")
public class CalendarController extends HttpServlet {
	private CalendarService calendarService;
	private TodoService todoService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentYear = request.getParameter("currentYear");
		String currentMonth = request.getParameter("currentMonth");
		String option = request.getParameter("option");
		// 디버그
		System.out.println("CalendarController - currentYear : "+ currentYear);
		System.out.println("CalendarController - currentMonth : "+ currentMonth);
		System.out.println("CalendarController - option : "+ option);
		

		// 위에서 받아온 세 매개변수로 달력 받아오기
		calendarService = new CalendarService();
		Map<String, Object> map = calendarService.getTargetCalendar(currentYear,currentMonth,option);
		
		// memberId
		String memberId = ((Member)(request.getSession().getAttribute("loginMember"))).getMemberId();
		System.out.println("CalendarController - memberId : "+ memberId);
		
		todoService = new TodoService();
		
		Object m = map.get("targetMonth");
		if(m.toString().length()<2) {
			m = "0"+m;
		}
		
		String ym = map.get("targetYear")+"-"+m;
		
		List<Todo> todoList = todoService.getTodoListByMonth(memberId, ym);
		
		// 모델
		request.setAttribute("nowYear", map.get("nowYear"));
		request.setAttribute("nowMonth", map.get("nowMonth"));
		request.setAttribute("targetYear", map.get("targetYear"));
		request.setAttribute("targetMonth", map.get("targetMonth"));
		request.setAttribute("targetDate", map.get("targetDate"));
		request.setAttribute("endDay", map.get("endDay"));
		request.setAttribute("startBlank", map.get("startBlank"));
		request.setAttribute("endBlank", map.get("endBlank"));
		request.setAttribute("yearMonth", map.get("yearMonth"));
		request.setAttribute("todoList", todoList);
		
		request.getRequestDispatcher("/WEB-INF/view/calendar.jsp").forward(request, response);
	}

}
