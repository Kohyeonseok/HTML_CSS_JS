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
<form name="searchForm" action="searchPost.do" onSubmit="return check()">
	검색 : 
	<select name="select">
		<option value="title">제목</option>
		<option value="titleAndContents">제목+내용</option>
		<option value="writer">작성자</option>
	</select>
	<input type="text" name="search" id="search">
	<input type="submit" value="검색">
</form>


<form name="tableForm" action="Content_view">
<table border="1">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>제목</th>
		<th>조회수</th>
	</tr>
	<c:forEach var="post" items="${sList}">
	<tr>
		<td>${post.no }</td>
		<td>${post.id }</td>
		<td><a href="content_view.do?no=${post.no}">${post.title }</a></td>
		<td>${post.hit }</td>
	</tr>
	</c:forEach>
	<tr>
		<td><a href="write.do">글작성</a></td>
		<td><a href="list.do?no=1">처음으로</a></td>
		<td><a href="login.do">메인으로</a></td>
	</tr>
</table>
</form>
<script>
	function check(){
		let search = document.getElementById("search").value;
		
		if(search===""){
			alert("검색내용을 입력하세요.");
			document.getElementById("search").focus();
			return false;
		}
		return true;
	}
</script>

</body>
</html>