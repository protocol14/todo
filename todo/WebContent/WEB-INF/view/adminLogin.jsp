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
<title>admin 로그인</title>
</head>
<body>
<div class="container">
	<h1 class="display-3">admin 로그인</h1>
	<br>
	<form method="post" action="${pageContext.request.contextPath}/adminLogin">
		<table class="table">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="adminId"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="adminPw"></td>
			</tr>
		</table>
		<button type="submit" class="btn btn-outline-success">로그인</button>
	</form>
	<br>
	<a href="${pageContext.request.contextPath}/login" class="btn btn-outline-secondary">되돌아가기</a>
</div>
</body>
</html>