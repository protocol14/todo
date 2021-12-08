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
<title>관리자 메뉴</title>
<style>
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
		관리자 메뉴에 오신 것을 환영합니다.
	</div>
</div>
</body>
</html>