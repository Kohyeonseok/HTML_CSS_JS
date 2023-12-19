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

	<c:if test="${logId == null }" var="result">

		<form action="LogOK.do" method="post" onSubmit="return check()">
			아이디 : <input type="text" name="id" id="id"> <br> 비밀번호 :<input
				type="password" name="password" id="password"><br> <input
				type="submit" value="로그인"> <a href="join_view.do">회원가입</a><br>
			<c:if test="${logFail eq 2}" var="result1">
			아이디가 존재하지 않습니다.
		</c:if>
			<c:if test="${logFail eq 1}" var="result2">
			비밀번호가 일치하지 않습니다.
		</c:if>

		</form>
	</c:if>
	<c:if test="${logId != null}" var="result">
		${logId}님<br>
		<a href="logout.do">로그아웃</a>
		<br>
		<a href="modify.do?id=${logId }">회원정보 수정</a>
		<br>
		<!-- <a href="list.do">게시판</a> -->
		<a href="list.do?no=1">게시판</a>
	</c:if>

</body>

<script>
	function check() {
		let id = document.getElementById("id").value;
		let pw = document.getElementById("password").value;

		if (id === "") {
			alert("아이디를 입력하세요.");
			document.getElementById("id").focus();
			return false;
		} else if (pw === "") {
			alert("비밀번호를 입력하세요.");
			document.getElementById("password").focus();
			return false;
		} else {
			return true;
		}
	}
</script>
</html>