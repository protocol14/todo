<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<title>일정 조회/추가</title>
<style>
	* {
		text-align: center;
	}
	table {
		margin: auto;
		border-collapse: collapse;
	}
	td {
		vertical-align: middle;
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
<div class="container-fluid" style="background-color:lightgray">
	<div class="container" style="background-color:white">
		<!-- 네비게이션 바 -->
		<jsp:include page="/WEB-INF/view/partial/nav.jsp"></jsp:include>
	
		<h1>${todoDate} - 일정</h1>
		<table style="border: 1px solid #000080;" class="table">
			<tr>
				<th style="width : 10%;">todoDate</th>
				<th style="width : 50%;">todoContent</th>
				<th style="width : 10%;">createDate</th>
				<th style="width : 10%;">updateDate</th>
				<th style="width : 10%;">수정</th>
				<th style="width : 10%;">삭제</th>
			</tr>
			<c:forEach var="t" items="${todoList}">
				<tr>
					<td>${todoDate}</td>
					<td style="color:${t.fontColor}">${t.todoContent}</td>
					<td>${t.createDate}</td>
					<td>${t.updateDate}</td>
					<td><a href="${pageContext.request.contextPath}/member/updateTodo?todoNo=${t.todoNo}" class="btn btn-outline-success">수정</a></td>
					<td><a href="${pageContext.request.contextPath}/member/removeTodo?todoNo=${t.todoNo}&todoDate=${todoDate}" class="btn btn-outline-danger">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<br>
		<br>
		
		<form method="post" action="${pageContext.request.contextPath}/member/addTodo">
			<input type="hidden" name="memberId" value="${loginMember.memberId}">
			<!-- AddTodoController.doPost() -->
			<table>
				<tr>
					<td>
						todoDate : 
					</td>
					<td>
						<input type="text" size="48" name="todoDate" value="${todoDate}" readOnly="readonly">
					</td>
				</tr>
				<tr>
					<td>
						todoContent : &nbsp;
					</td>
					<td>
						<textarea rows="3" cols="50" name="todoContent"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						색상 : 
					</td>
					<td style="text-align: left;">
						<input type="color" name="fontColor">
					</td>
				</tr>
			</table>
			<button type="submit" class="btn btn-primary">추가</button>
		</form>
	</div>
</div>
</body>
</html>