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
				<td><h5 id="result">${post.title }</h5></td>
				<td><h5 id="password-check-result">${post.contents}</h5></td>
				<td><h5 id="result">${post.write_date}</h5></td>

			</tr>
			<c:if test="${post.writer_seq eq userSeq}">
				<tr>
					<td>
						<button onclick="location.href='/board/updatePage'">수정</button>
						<button onclick="location.href='/board/delete?seq=${post.seq}'">삭제</button>
					</td>
				</tr>
			</c:if>
			<tr>
				<td>
					<form action="/reply/insert">
						<input type="hidden" name="postSeq" value="${post.seq}"> <input
							type="hidden" name="userSeq" value="${loginResult.id}"> <input
							type="text" id="reply-contents" name="contents">
						<button type="submit">등록</button>
					</form>
				</td>
			</tr>
			<c:forEach var="reply" items="${replyList}">
				<tr>
					<td><input id="reply-contents-${reply.seq}" name="contents"
						value="${reply.contents}" readonly></td>
					<td><h5 id="password-check-result">${reply.writer_seq}</h5></td>
					<td><h5>${reply.write_date}</h5></td>
				</tr>
				<c:if test="${reply.writer_seq eq userSeq}">
					<tr>
						<td>
							<button id="reply-update-btn-${reply.seq}"
								onclick="updateReply(${reply.seq})">수정</button>
							<button
								onclick="location.href='/reply/delete?replySeq=${reply.seq}'">삭제</button>
						</td>
					</tr>
				</c:if>
			</c:forEach>
			<c:forEach var="fileList" items="${fileList }">
				<tr>
					<td><a onclick="downloadFile(this)">${fileList.oriname}</a> <input
						type="hidden" id="sysname" value="${fileList.sysname }"></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<script>
function updateReply(seq) {
    var contentsInput = $("#reply-contents-" + seq);
    var updateBtn = $("#reply-update-btn-" + seq);

    // 댓글 내용 수정 가능하도록 입력 필드 활성화
    contentsInput.prop("readonly", false);

    // 수정 버튼을 '수정 완료'로 변경
    updateBtn.text("수정 완료").attr("onclick", "submitUpdate(" + seq + ")");
}
function submitUpdate(seq) {
    var contentsInput = $("#reply-contents-" + seq);
    var updatedContents = contentsInput.val();

    // 서버로 수정된 댓글 내용을 전송 (Ajax 사용 예시)
    $.ajax({
        type: "POST",
        url: "/reply/update",
        data: {
            seq: seq,
            contents: updatedContents
        },
        success: function(response) {
            // 수정 성공 시 처리
            alert("댓글이 수정되었습니다.");
            // 페이지 리로드 또는 필요한 처리
            location.reload();
        },
        error: function(xhr, status, error) {
            // 오류 발생 시 처리
            alert("댓글 수정 중 오류가 발생하였습니다.");
            console.error(xhr.responseText);
        }
    });
}


function downloadFile(e){
	console.log(e.text)
$.ajax({
		url:'/file/download',
		data:{oriname:e.text,
			sysname:$("#sysname").val()},
		done: function(resp){
			console.log(resp);
		}
	})
}

</script>
</html>