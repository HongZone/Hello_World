<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버상세조회(memberSearchForm.do)</title>
</head>
<body>

	<%
		String result = (String) request.getAttribute("sid");
	%>
	<h3>멤버상세페이지</h3>
	<form action="./memberSearch.do" method="get">
	<input type="hidden" name="job" value="search">
	ID:<input type="text" name="id" value = "<%=result %>">
	<input type="submit" value="조회">
	</form>
</body>
</html>