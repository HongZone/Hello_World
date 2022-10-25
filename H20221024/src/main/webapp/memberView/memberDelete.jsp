<%@page import="co.edu.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원삭제(memberDelete.jsp)</title>
</head>
<body>
	<h3>회원조회</h3>
	
	<form action="./memberSearch.do" method="post">
		<input type="hidden" name="job" value="delete">
		ID:<input type="text" name="id">
		<input type="submit" value="조회">
	</form>
	

	

	<h3>회원삭제페이지</h3>
	<%
		MemberVO result = (MemberVO) request.getAttribute("memberInfo");
		String id = (String) session.getAttribute("id");
	%>
	<%if(result != null){%>
	<form action="./memberRemove.do" method="post">
		<input type="hidden" name="job" value="delete">
		ID: <input type="text" name="id" value="<%=result.getId()%>">
		<%if(id.equals(result.getId())) {%>
		<input type="submit" value="삭제">
		<%} %>
	</form>
	<%} else { %>
		<p>조회된 결과가 없습니다</p>
	<%} %>
</body>
</html>