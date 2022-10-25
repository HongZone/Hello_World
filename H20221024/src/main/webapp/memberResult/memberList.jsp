<%@page import="java.util.List"%>
<%@page import="co.edu.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>

	<%
		List<MemberVO> list = (List<MemberVO>) request.getAttribute("memberList");
	%>
	<h3>회원정보리스트 보기</h3>
	<%if(list.size() >= 1) {%>
		<table border = '1'>
			<tr><th>회원아이디</th><th>이름</th><th>이메일</th><th>비밀번호</th></tr>
			<%for (MemberVO vo : list) {%>
				<tr>
				<th><a href="./memberSearch.do?id=<%=vo.getId() %>&job=search"><%=vo.getId()%></a></th>
				<th><a href="./memberModifyForm.do?id="<%=vo.getId() %>><%=vo.getName()%> </a></th>
				<th><%=vo.getEmail()%></th>
				<th><%=vo.getPasswd()%></th>
				</tr>
			<%} %>
		</table>
	<%}else{ %>
		<p>회원이 없습니다</p>
	<%} %>
	
</body>
</html>