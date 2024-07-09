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
	<form action="/board/writeBoard"  method="post" enctype="multipart/form-data" id="upload">
		<div id="fileList">
			<input type="text" id="title" name="title" required> <input
				type="text" id="title" name="contents" required>
			<div id="fileList">
				<input type="file" id="file" name="file" multiple><br>
			</div>
		</div>
		<button type="submit">업로드</button>
	</form>
	<button id="addButton">추가</button><br>
	
	
</body>

<script>
$("#addButton").on("click", function(e){
	$("#fileList").append('<input type="file" id="file" name="file" multiple><br>')
})
</script>
</html>