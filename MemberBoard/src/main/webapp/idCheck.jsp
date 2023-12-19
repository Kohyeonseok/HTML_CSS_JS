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
<form name="idCheckForm" action="idCheck.do" onSubmit="return inputId()">
	아이디 : <input type="text" name="id" id="id" value="${inputId }"><br>
	<input type="submit" value="확인"><br>
	<c:if test="${inputResult ne 0 && inputResult ne null}" var="result1">
	 이미 가입된 아이디 입니다.
	</c:if>
	<c:if test="${inputResult eq 0}" var="result2">
	 사용가능한 아이디 입니다.<input type="button" value="사용하기" onclick="assignIdValue()">
	</c:if>
</form>




</body>
<script>
	function inputId(){
		
		let input = document.getElementById("id").value;
		
		if(input == ""){
			alert("아이디를 입력하세요.");
			document.getElementById("id").focus();
			return false;
		}else{
			return true;
		}
		
	}
	
	function assignIdValue() {

        let parentWindow = window.opener;
        let inputElement = parentWindow.document.getElementById('id');
        
        inputElement.value = '${inputId}';

        window.close();
    }
</script>
</html>