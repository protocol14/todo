<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<title>캘린더</title>
<style>
	* {
		text-align: center;
	}
	table {
		width: 595px;
		border: 1px solid #444444;
		margin: auto;
		border-collapse: collapse;
	}
	td {
		width : 14.28%;

	}
	tr {
		height:85px;
	}
	
	html,
    body {
      height: 100%;
      margin : 0;
      paddin : 0;
    }
    .container-fluid {
      height: 100%;
    }
    .container {
      min-height: 100%;
    }
</style>
</head>
<body>
<div class="container-fluid" style="background-color:SlateGray">
	<div class="container" style="background-color:white">
		<!-- 네비게이션 바 -->
		<jsp:include page="/WEB-INF/view/partial/nav.jsp"></jsp:include>
	
		<!-- 달력 + todo -->
		<h1>${targetYear }년 ${targetMonth }월</h1>
		<span>
			<a href="${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth}&option=pre" class="btn btn-outline-info text-secondary">이전</a>
		</span>
		<span>
			<a href="${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth}&option=next" class="btn btn-outline-info text-secondary">다음</a>
		</span>
		<div class="table-responsive">
			<table class="table">
				<tr>
					<th style="color:red">일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th style="color:blue">토</th>
				</tr>
				<tr>
					<!-- JSTL for문 -->
					
					<!-- 일요일은 빨강색으로, 토요일은 파랑색으로 -->
					<!-- end = 총 td갯수 -->
					<c:forEach var="i" begin="1" end="${startBlank+endDay+endBlank }" step="1">
						<!-- 유사 break문을 위한 변수 -->
						<c:set var="loop_flag" value="false" />
						<!-- i-startBlank = 일의 시작. 한자리수일 때 앞에 0을 붙임 -->
						<c:if test="${(i-startBlank)<10}">
							<c:set var="setDay" value="${'0'+=(i-startBlank)}"/>
						</c:if>
						<c:if test="${(i-startBlank)>=10}">
							<c:set var="setDay" value="${i-startBlank}"/>
						</c:if>
						<!-- 실제 달력의 공백부분을 맞추기 위함 -->
						<c:if test="${i-startBlank >= 1 && i-startBlank<=endDay}">
							<!-- (targetDate=시스템 상 날짜의 일)과 값이 같다면 -->
							<c:if test="${i-startBlank == targetDate}">
								<!-- 년과 월 둘다 일치할 경우 날짜의 숫자색을 주황으로 -->
								<c:if test="${targetYear == nowYear && targetMonth == nowMonth }">
									<td style="color: orange" >&nbsp;${i-startBlank}&nbsp;
								</c:if>
								<!-- 둘 다 일치하지 않는다면 현재 날짜의 값이 존재할리 없으므로 다른 달력의 색상과 동일 -->
								<c:if test="${(targetYear != nowYear || targetMonth != nowMonth) && i%7 == 1 }">
									<td style="color: red" >&nbsp;${i-startBlank}&nbsp;
								</c:if>
								<c:if test="${(targetYear != nowYear || targetMonth != nowMonth) && i%7 == 0 }">
									<td style="color: blue" >&nbsp;${i-startBlank}&nbsp;
								</c:if>
								<c:if test="${(targetYear != nowYear || targetMonth != nowMonth) && i%7 != 1 && i%7 != 0 }">
									<td>&nbsp;${i-startBlank}&nbsp;
								</c:if>
								<br>
								<!-- date+setDay -->
								<c:set var="Date" value="${yearMonth+=setDay}"/>
								<c:forEach var="t" items="${todoList}" varStatus="status">
									<c:if test="${t.todoDate == Date && not loop_flag}">
										<a href="${pageContext.request.contextPath}/member/todoList?y=${targetYear}&m=${targetMonth}&d=${i-startBlank}">일정</a>
										<c:set var="loop_flag" value="true"/>
									</c:if>
								</c:forEach>
								<br>
								</td>
							</c:if>
							<c:if test="${!(i-startBlank == targetDate)}">
								<c:if test="${i%7 == 1 }">
									<td style="color: red">&nbsp;${i-startBlank}&nbsp;
								</c:if>
								<c:if test="${i%7 == 0 }">
									<td style="color: blue">&nbsp;${i-startBlank}&nbsp;
								</c:if>
								<c:if test="${i-startBlank != targetDate && i%7 != 1 && i%7 != 0}">
									<td>&nbsp;${i-startBlank}&nbsp;
								</c:if>
								<br>
								<c:set var="Date" value="${yearMonth+=setDay}"/>
								<c:forEach var="t" items="${todoList}" varStatus="status">
									<c:if test="${t.todoDate == Date && not loop_flag}">
										<a href="${pageContext.request.contextPath}/member/todoList?y=${targetYear}&m=${targetMonth}&d=${i-startBlank}">일정</a>
										<c:set var="loop_flag" value="true"/>
									</c:if>
								</c:forEach>
								<br>
								</td>
							</c:if>
						</c:if>
						<c:if test="${i-startBlank < 1 || i-startBlank>endDay}">
							<td></td>
						</c:if>
						
						<c:if test="${i%7 == 0}">
							</tr>
						</c:if>
					</c:forEach>
				</tr>
			</table>
		</div>
		<!-- 주소창에서 값 받아올땐 param. 잊지말자 -->
		<span>
			<c:set var="year" value="${param.selectYear}" />
			<c:if test="${param.selectYear == null}">
				<c:set var="year" value="${targetYear}" />
			</c:if>
			<select id="selectYear" name="selectYear" onchange="yearSelect()">
				<c:forEach var="i" begin="1" end="5000" step="1">
					<c:if test="${year == null}">
						<option value="${i}">${i}</option>
					</c:if>
					<c:if test="${i != year}">
						<option value="${i}">${i}</option>
					</c:if>
					<c:if test="${i == year}">
						<option value="${i}" selected="selected">${i}</option>
					</c:if>
				</c:forEach>
			</select>
			-
			<c:set var="month" value="${param.selectMonth}" />
			<c:if test="${param.selectMonth == null}">
				<c:set var="month" value="${targetMonth}" />
			</c:if>
			<select id="selectMonth" name="selectMonth" onchange="monthSelect()">
				<c:forEach var="i" begin="1" end="12" step="1">
					<c:if test="${month == null}">
						<option value="${i}">${i}</option>
					</c:if>
					<c:if test="${i != month}">
						<option value="${i}">${i}</option>
					</c:if>
					<c:if test="${i == month}">
						<option value="${i}" selected="selected">${i}</option>
					</c:if>
				</c:forEach>
			</select>
		-
		<c:set var="dayValue" value="${param.selectDay}" />
		<c:if test="${param.selectDay == null}">
			<c:set var="dayValue" value="1" />
		</c:if>
		<select id="selectDay" name="selectDay" onchange="daySelect()">
			<c:forEach var="i" begin="1" end="${endDay}" step="1">
				<c:if test="${dayValue == null}">
					<option value="${i}">${i}</option>
				</c:if>
				<c:if test="${i != dayValue}">
					<option value="${i}">${i}</option>
				</c:if>
				<c:if test="${i == dayValue}">
					<option value="${i}" selected="selected">${i}</option>
				</c:if>
			</c:forEach>
		</select>
		</span>
		&nbsp;
		<a href="${pageContext.request.contextPath}/member/todoList?y=${targetYear}&m=${targetMonth}&d=${dayValue}" class="btn btn-secondary">일정 추가</a>
		
		<br>
		<br>
		<div style="text-align: right">이 달의 일정 갯수: ${todoList.size()}</div>
	</div>
</div>
<script>
	function yearSelect(){ 
		let year = selectYear.options[selectYear.selectedIndex].value; 
		let month = parseInt(selectMonth.options[selectMonth.selectedIndex].value)+1; 
		
		if(month==13){
			year++;
			location.replace('${pageContext.request.contextPath}/member/calendar?currentYear='+year+'&currentMonth=1&option=pre');
			return;
		}
		location.replace('${pageContext.request.contextPath}/member/calendar?currentYear='+year+'&currentMonth=${targetMonth+1}&option=pre');
	};
	
	function monthSelect(){ 
		let month = parseInt(selectMonth.options[selectMonth.selectedIndex].value)+1; 
		
		if(month==13){
			location.replace('${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear+1}&currentMonth=1&option=pre');
			return;
		}
		location.replace('${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth='+month+'&option=pre');
	};
	
	function daySelect(){ 
		let year = selectYear.options[selectYear.selectedIndex].value; 
		let month = parseInt(selectMonth.options[selectMonth.selectedIndex].value)+1; 
		let dayValue = selectDay.options[selectDay.selectedIndex].value; 
		
		if(month==13){
			year++;
			location.replace('${pageContext.request.contextPath}/member/calendar?currentYear='+year+'&currentMonth=1&option=pre&selectDay='+dayValue);
			return;
		}
		location.replace('${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth+1}&option=pre&selectDay='+dayValue);
	}
</script>
</body>
</html>