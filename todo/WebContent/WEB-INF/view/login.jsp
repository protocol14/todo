<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<title>로그인</title>
</head>
<body>
<div class="container">
	<h1 class="display-3">캘린더 로그인</h1>
	<br>
	<form method="post" action="${pageContext.request.contextPath}/login">
		<table class="table">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberId"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="memberPw"></td>
			</tr>
		</table>
		<button type="submit" class="btn btn-outline-secondary">로그인</button>
	</form>
	<br>
	<div>
		<a href="${pageContext.request.contextPath}/addMember" class="btn btn-outline-success">회원가입</a>
	</div>
	
	<br>
	<br>
	<br>
	
	<h2 class="display-5">공지사항<a href="${pageContext.request.contextPath}/noticeList">more</a></h2>
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
	<br>

	<div>
		<a href="${pageContext.request.contextPath}/adminLogin" class="btn btn-outline-success">관리자 로그인</a>
	</div>
</div>
</body>
</html>