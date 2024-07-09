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
	<form action="/board/update">
		<div>
		<input type="hidden" id="seq" name="seq" required value="${post.seq }"> 
			<input type="text" id="title" name="title" required value="${post.title }"> 
			<input type="text" id="contents" name="contents" required  value="${post.contents}">
			<button type="submit">글쓰기</button>
		</div>
	</form>
</body>
</html>