<%@page import="co.edu.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정 페이지</title>
</head>
<body>
	<h3>회원조회</h3>
	
	<form action="./memberSearch.do" method="post">
		<input type="hidden" name="job" value="update">
		ID:<input type="text" name="id">
		<input type="submit" value="조회">
	</form>
	
	<h3>회원정보수정</h3>
	<%
		MemberVO result = (MemberVO) request.getAttribute("memberInfo");
		String id = (String) session.getAttribute("id"); 
	%>
	<%if(result != null){%>
	
	<form action="./memberModify.do" method="post">
		ID:<input type="text" name="id" value="<%=result.getId() %>" readonly><br>
		PW:<input type="password" name="passwd" value="<%=result.getPasswd() %>"><br>
		Name:<input type="text" name="name" value="<%=result.getName() %>"><br>
		Mail:<input type="email" name="email" value="<%=result.getEmail()%>"><br>
		<%if(id.equals(result.getId())){ %>
		<input type="submit" value="수정">
		<%} %>
	</form>
	<%} else {%>
		<p>조회된 결과가 없습니다
	<%} %>
</body>
</html>