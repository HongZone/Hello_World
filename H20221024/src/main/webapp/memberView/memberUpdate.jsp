<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정 페이지</title>
</head>
<body>
	<h3>회원정보수정</h3>
	<form action="./memberModify.do" method="post">
		ID:<input type="text" name="id"><br>
		PW:<input type="password" name="passwd"><br>
		Name:<input type="text" name="name"><br>
		Mail:<input type="email" name="email"><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>