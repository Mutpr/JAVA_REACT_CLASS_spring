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
			<c:forEach var="post" items="${postList }">
				<tr onclick="location.href='/board/showOnePost?seq=${post.seq}'">
					<td>
						<h5 id="result">${post.seq }</h5>
					</td>
					<td><h5 id="result">${post.title }</h5></td>
					<td><h5 id="password-check-result">${post.contents}</h5></td>
					<td><h5 id="result">${post.write_date}</h5></td>

				</tr>
			</c:forEach>
			<tr>
				<td>
					<button onclick="location.href='/board/writePage'">글쓰기</button>
				</td>
			</tr>

		</table>
	</div>
</body>
</html>