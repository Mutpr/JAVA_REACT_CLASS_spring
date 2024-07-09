<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table border="1">
			<tr>
			<c:if test="${empty loginResult}">
				<td><button onclick="location.href='/member/signupPage'">회원가입</button></td>
				<td><button onclick="location.href='/member/loginPage'">로그인</button></td>
			</c:if>
			<c:if  test="${not empty loginResult}">
				<td><button  onclick="location.href='/board/main'">게시판</button></td>
				<td><button>마이페이지</button></td>
			</c:if>
			</tr>
		</table>
	</div>
</body>
</html>