<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = (String) session.getAttribute("id");
		String auth = (String) session.getAttribute("auth");
		System.out.println(auth);
	%>
	<%if(id!=null) {%>
		<p>아이디: <%=id %></p>
	<%} else {%>
		<p>손님</p>
	<%} %>
	
	<h2>Member 첫페이지.</h2>
	<% if(auth.equals("admin")){ %>
	    <a href = "./memberAddForm.do">회원정보생성페이지.</a><br>
	<% } %>
	<a href = "./memberModifyForm.do">회원정보수정페이지.</a><br>
	<a href = "./memberRemoveForm.do">회원정보삭제페이지.</a><br>
	<a href = "./memberSearchForm.do">회원정보상세페이지.</a><br>
	<a href = "./memberList.do">회원목록.</a><br>
	<% if(id==null) {%>
		<a href ="./loginFrom.do">로그인 화면</a>

	<%}else{ %>
		<a href="./loginOut.do">로그아웃</a>
	<%} %>
</body>
</html>