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
<title>회원가입</title>
</head>
<body>
<div class="container">
	<h1 class="display-3">회원가입</h1>
	<br>
	<form name="MemberIdCheck" method="post" action="${pageContext.request.contextPath}/memberIdCheck">
		<div style="vertical-align: middle;">
			아이디 중복체크 <input type="text" class="memberIdCheck" name="memberIdCheck">
			<button type="button" class="btn btn-outline-success" onclick="memberIdCheckAction()">중복확인</button>
			&nbsp;
			
			<c:if test="${param.idCheck == true}">
				<p style="color:blue">사용할 수 있는 아이디입니다.</p>
			</c:if>
			<c:if test="${param.idCheck == false}">
				<p style="color:red">사용할 수 없는 아이디입니다.</p>
			</c:if>
			
		</div>
	</form>
	<br>
	<c:set var="memberId" value="${param.memberId}" />
	<form name="AddMember" method="post" action="${pageContext.request.contextPath}/addMember">
		<table class="table">
			<tr>
				<td>아이디</td>
				<td><input class="memberId" type="text" name="memberId" value="${memberId}" readonly></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input class="memberPw" type="password" name="memberPw"></td>
			</tr>
			<tr>
				<td>패스워드 확인</td>
				<td><input class="memberPw2" type="password" name="memberPw2"></td>
			</tr>
		</table>
		<button type="button" class="btn btn-outline-secondary" onclick="addMember()">회원가입</button>
	</form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	// 유효성 검사
	function addMember(){
		if($(".memberId").val() == ""){
			alert('ID 중복확인을 진행해주세요.');
			return;
		} else if($(".memberPw").val() == ""){
			alert('PW를 입력해주세요.');
			return;
		} else if($(".memberPw2").val() == ""){
			alert('비밀번호 확인절차가 필요합니다.');
			return;
		} else if(!($(".memberPw").val() == $(".memberPw2").val())){
			alert('PW 값이 동일하지 않습니다.');
			return;
		} else{
			AddMember.submit();
		}
	};
	
	function memberIdCheckAction(){
		if($(".memberIdCheck").val() == ""){
			alert('공백을 입력하지 말아주십시오.');
			return;
		}else{
			MemberIdCheck.submit();
		}
	};
</script>
</body>
</html>