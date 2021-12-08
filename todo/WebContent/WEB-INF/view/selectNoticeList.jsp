<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<title>공지사항 목록</title>
<style>
	*{
		text-align: center;
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
		<table class="table">
			<tr>
				<td>noticeTitle</td>
				<td>createDate</td>
			</tr>
			<c:forEach var="n" items="${noticeList}">
			<tr>
				<td><a href="${pageContext.request.contextPath}/noticeOne?noticeNo=${n.noticeNo}">${n.noticeTitle}</a></td>
				<td>${n.createDate}</td>
			</tr>
			</c:forEach>
		</table>
		<br>
		<a href="${pageContext.request.contextPath}/login" class="btn btn-outline-secondary">되돌아가기</a>
	</div>
</div>
</body>
</html>