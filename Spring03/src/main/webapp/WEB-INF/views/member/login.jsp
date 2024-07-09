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
	<form action = "/member/login">
		<table border="1">
			<tr>
				<td><input type="text" name="username" id="id" placeholder="input your id" />
				<h5 id="result" style="display:none"></h5></td>
				
			</tr>
			<tr>
				<td><input type="password" name="password" id="password"
					placeholder="input your password" /></td>
			</tr>
			<tr>
				<td>
					<button type="submit">로그인</button>
				</td>
			</tr>

		</table>
		</form>
	</div>
</body>
</html>