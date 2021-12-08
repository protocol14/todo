<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<title>공지사항 관리</title>
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
<div class="container-fluid" style="background-color:SlateGray">
	<div class="container" style="background-color:white">
		<!-- 네비게이션 바 -->
		<jsp:include page="/WEB-INF/view/partial/adminNav.jsp"></jsp:include>
	
		<h1>공지사항 관리</h1>
		<table style="border: 1px solid #000080;" class="table">
			<tr>
				<th style="width : 10%;">notice_title</th>
				<th style="width : 50%;">notice_content</th>
				<th style="width : 10%;">createDate</th>
				<th style="width : 10%;">updateDate</th>
				<th style="width : 10%;">수정</th>
				<th style="width : 10%;">삭제</th>
			</tr>
			<c:forEach var="n" items="${noticeList}">
				<tr>
					<td>${n.noticeTitle}</td>
					<td>${n.noticeContent}</td>
					<td>${n.createDate}</td>
					<td>${n.updateDate}</td>
					<td><a href="${pageContext.request.contextPath}/admin/adminUpdateNotice?noticeNo=${n.noticeNo}" class="btn btn-outline-success">수정</a></td>
					<td><a href="${pageContext.request.contextPath}/admin/adminRemoveNotice?noticeNo=${n.noticeNo}" class="btn btn-outline-danger">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<br>
		<br>
		
		<form method="post" action="${pageContext.request.contextPath}/admin/adminAddNotice">
			<!-- AddTodoController.doPost() -->
			<table>
				<tr>
					<td>
						noticeTitle : 
					</td>
					<td>
						<input type="text" size="48" name="noticeTitle">
					</td>
				</tr>
				<tr>
					<td>
						noticeContent : &nbsp;
					</td>
					<td>
						<textarea rows="3" cols="50" name="noticeContent"></textarea>
					</td>
				</tr>
			</table>
			<button type="submit" class="btn btn-primary">추가</button>
		</form>
	</div>
</div>
</body>
</html>