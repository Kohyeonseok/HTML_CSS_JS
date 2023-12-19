<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form name="replyForm" action="contentReplyOK.do">
			<input type="hidden" name="groupNum" id="groupNum" value="${dto.groupNum}">
			<input type="hidden" name="stepNum" id="stepNum" value="${dto.stepNum}">
			<input type="hidden" name="indentNum" id="indentNum" value="${dto.indentNum}">
			<input type="hidden" name="id" id="id"  value="${sDto.id}">
			
			<table border="1">
				<tr>
					<td>닉네임</td>
					<td>${sDto.nickName}</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>${sDto.phoneNum}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${sDto.name}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" id="title" value="${dto.title}"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="contents" id="contents">&#10&#13re : ${dto.contents}</textarea></td>
				</tr>
				<tr>

					<td><input type="submit" value="답변"></td>
					<td>
					<a href="list.do?no=1">목록</a> 
					</td>
				</tr>
			</table>
		</form>
</body>
</html>