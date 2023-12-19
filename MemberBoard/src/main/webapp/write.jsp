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
<form name="writeForm" action="WriteOk.do" onSubmit="return check()">
	<input type="hidden" name="id" id="id" value="${logId }">
	<table border="1">
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" id="title"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="contents" id="contents"></textarea></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="입력">
				<a href="list.do?no=1">목록</a>
			</td>
		</tr>
	</table>
</form>
</body>
<script>
	function check(){
		let title = document.getElementById("title").value;
		let contents = document.getElementById("contents").value;
		
		if(title == ""){
			alert("제목을 입력하세요.");
			document.getElementById("title").focus();
			return false;
		}else if(contents == ""){
			alert("내용을 입력하세요.");
			document.getElementById("contents").focus();
			return false;
		}else{
			return true;
		}
	}
</script>
</html>