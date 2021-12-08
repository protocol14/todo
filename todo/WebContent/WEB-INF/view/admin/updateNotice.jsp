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
<title>공지 업데이트</title>
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
	
	
		<c:forEach var="n" items="${noticeList}">
			<h1>공지사항 수정</h1>
			
			<form method="post" action="${pageContext.request.contextPath}/admin/adminUpdateNotice">
				<input type="hidden" name="noticeNo" value="${n.noticeNo}">	
				<!-- AddTodoController.doPost() -->
				<table>
					<tr>
						<td>
							noticeTitle : &nbsp;
						</td>
						<td>
							<input type="text" name="noticeTitle" value="${n.noticeTitle}">
						</td>
					</tr>
					<tr>
						<td>
							noticeContent : &nbsp;
						</td>
						<td>
							<textarea rows="3" cols="50" name="noticeContent">${n.noticeContent}</textarea>
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