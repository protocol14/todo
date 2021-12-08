<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<title>내비게이션 바</title>
</head>
<body>
<div class="container">
	<nav class="navbar navbar-expand-sm bg-light navbar-light">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/admin/adminIndex">Index</a>
	      </li>
	     <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/admin/logout">로그아웃</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/admin/managementMember">회원관리</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/admin/adminNotice">공지사항 관리</a>
	      </li>
	    </ul>
	    <span class="nav-link active" style="text-align: right;vertical-align: middle">
	    	${loginAdmin.adminId}님 반갑습니다.
	    </span>
	    
	  </div>
	</nav>
</div>
</body>
</html>