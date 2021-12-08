package service;


import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;



public class CalendarService {
	
	public Map<String, Object> getTargetCalendar(String currentYear, String currentMonth, String option){ // option : pre, next
		System.out.println("CalendarService getTargetCalendar currentYear : "+ currentYear);
		System.out.println("CalendarService getTargetCalendar currentMonth : "+ currentMonth);
		System.out.println("CalendarService getTargetCalendar option : "+ option);
		
		Map<String, Object> map = new HashMap<>();
		
		// 현재 년,월,일 초기화
		LocalDate localDate = LocalDate.now();
		
		// 년 = int y, 월 = Month m 현재 날짜에서 가져옴
		int y = localDate.getYear();
		Month m = localDate.getMonth();

		// 연도, 달이 선택이 되었다면
		if(currentYear != null && currentMonth != null) {
			// 년,월값을 해당값으로
			y = Year.of(Integer.parseInt(currentYear)).getValue();
			m = Month.of(Integer.parseInt(currentMonth));
			
			// pre = -1, next = +1
			// 달에 따라 년도 바뀌도록 설정
			if(option != null && option.equals("pre")) {
				if(m.getValue() != 1) {
					m = m.minus(1);
				} else {
					y = y-1;
					m = m.minus(1);
				}
			} else if(option != null & option.equals("next")) {
				if(m.getValue() != 12) {
					m = m.plus(1);
				} else {
					y = y+1;
					m = m.plus(1);
				}
			}
		}
		
		// 구한 년,월 String값으로 저장
		String yearMonth = YearMonth.of(y, m).toString()+"-";
		
		// 해당 월의 최대 날짜
		int endDay = LocalDate.of(y, m, 1).lengthOfMonth();
		
		//달력 앞, 뒤, 공백의 개수
		int startBlank = LocalDate.of(y, m, 1).getDayOfWeek().getValue(); // 월요일 1...일요일 7. -1해서 일요일을 0으로 만들면 나머지 요일들이 오류남
		if(startBlank == 7) { // 7이 나올 경우 월요일부터 시작 = 0
			startBlank = 0;
		}
		
		int endBlank = 0;
		endBlank = 7 - (startBlank + endDay)%7; // 전체의 <td>개수 = startBlank + endDay + endBlank 값이 7로 나누어 떨어지도록 함
		if(endBlank == 7) {
			endBlank = 0;
		}
		
		map.put("nowYear", localDate.getYear());
		map.put("nowMonth", localDate.getMonthValue());
		map.put("targetYear", y);
		map.put("targetMonth", m.getValue());
		map.put("targetDate", localDate.getDayOfMonth());
		map.put("endDay", endDay);
		map.put("startBlank", startBlank);
		map.put("endBlank", endBlank);
		map.put("yearMonth", yearMonth);

		
		return map;
	}
}