<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${logId == dto.id }" var="result">
		<form name="contentForm" action="contentModify.do">
		<input type="hidden" name="no" id="no" value="${dto.no }">
			<table border="1">
				<tr>
					<td>닉네임</td>
					<td>${dto.nickName}</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>${dto.phoneNum}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${dto.name}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" id="title" value="${dto.title}"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="contents" id="contents">${dto.contents}</textarea></td>
				</tr>
				<tr>

					<td><input type="submit" value="수정"></td>
					<td>
					<a href="delete.do?no=${dto.no}">삭제</a> 
					<a href="list.do?no=1">목록</a> 
					<a href="reply.do?no=${dto.no}">답변</a>
					</td>
				</tr>
			</table>
		</form>
	</c:if>
	
	<c:if test="${logId != dto.id }" var="result">
			<table border="1">
				<tr>
					<td>닉네임</td>
					<td>${dto.nickName}</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>${dto.phoneNum}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${dto.name}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>${dto.title}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea>${dto.contents}</textarea></td>
				</tr>
				<tr>
					<td>
					<a href="list.do?no=1">목록</a> 
					<a href="reply.do?no=${dto.no}">답변</a>
					</td>
				</tr>
			</table>
	</c:if>
</body>
</html>