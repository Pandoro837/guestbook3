<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/guestbook3/gbc/delete" method="post">
		<input type="hidden" name="no" value="${param.no }"> 
		비밀번호 <input type="password" name="pw" value="">
		<button type="submit">확인</button>
	</form>
</body>
</html>