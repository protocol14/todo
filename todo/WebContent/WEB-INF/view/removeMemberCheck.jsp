<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<title>회원탈퇴</title>
<style>
	* {
		text-align: center;
	}
</style>
</head>
<body>
<div class="container-fluid" style="background-color:lightgray">
	<div class="container" style="background-color:white">
		<!-- 네비게이션 바 -->
		<jsp:include page="/WEB-INF/view/partial/nav.jsp"></jsp:include>
		
		<h1>회원탈퇴</h1>
		<br>
		<form method="post" action="${pageContext.request.contextPath}/member/removeMember">
			패스워드 확인&nbsp;<input type="password" name="memberPw">
			<br>
			<br>
			<button type="submit" class="btn btn-outline-danger">탈퇴</button>
		</form>
	</div>
</div>
</body>
</html>