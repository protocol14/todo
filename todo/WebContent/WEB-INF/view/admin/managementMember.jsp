<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<title>회원 관리</title>
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
	
		<h1>회원 관리</h1>
		<table style="border: 1px solid #000080;" class="table">
			<tr>
				<th style="width : 20%;"></th>
				<th style="width : 20%;">member_id</th>
				<th style="width : 20%;">createDate</th>
				<th style="width : 20%;">updateDate</th>
				<th style="width : 20%;">탈퇴</th>
				<th style="width : 20%;"></th>
			</tr>
			<c:forEach var="m" items="${memberList}">
				<tr>
					<td></td>
					<td>${m.memberId}</td>
					<td>${m.createDate}</td>
					<td>${m.updateDate}</td>
					<td><a href="${pageContext.request.contextPath}/admin/adminRemoveMember?memberId=${m.memberId}" class="btn btn-outline-danger">탈퇴</a></td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>