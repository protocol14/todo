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
<title>공지사항</title>
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
<div class="container-fluid" style="background-color:SlateGray">
	<div class="container" style="background-color:white">
		<c:forEach var="n" items="${noticeElement}">
			<br>
			<h1>${n.noticeTitle} - 상세</h1>
			<div>추가일 : ${n.createDate}</div>
			<div>마지막 수정일 : ${n.updateDate}</div>
			<br>
			<br>
			<div style="background-color:WhiteSmoke;">${n.noticeContent}</div>
		
		</c:forEach>
		<br>
		<a href="javascript:history.back();" class="btn btn-outline-secondary">되돌아가기</a>
	</div>
</div>
</body>
</html>