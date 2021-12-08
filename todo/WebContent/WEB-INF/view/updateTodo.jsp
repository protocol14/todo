<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<title>일정 업데이트</title>
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
</style>
</head>
<body>
<div class="container-fluid" style="background-color:lightgray">
	<div class="container" style="background-color:white">
		<!-- 네비게이션 바 -->
		<jsp:include page="/WEB-INF/view/partial/nav.jsp"></jsp:include>
		
		<c:forEach var="t" items="${todoList}">
			<h1>${t.todoDate} - 일정 업데이트</h1>
			
			<form method="post" action="${pageContext.request.contextPath}/member/updateTodo">
				<input type="hidden" name="todoDate" value="${t.todoDate}">	
				<input type="hidden" name="todoNo" value="${t.todoNo}">	
				<input type="hidden" name="memberId" value="${loginMember.memberId}">
				<!-- AddTodoController.doPost() -->
				<table>
					<tr>
						<td>
							todoContent : &nbsp;
						</td>
						<td>
							<textarea rows="3" cols="50" name="todoContent">${t.todoContent}</textarea>
						</td>
						<td style="text-align: left;vertical-align: bottom">
							
								<input type="color" value="${t.fontColor}" name="fontColor">
							
							
						</td>
					</tr>
				</table>
				<button type="submit" class="btn btn-primary">수정</button>
			</form>
		</c:forEach>
	</div>
</div>
</body>
</html>