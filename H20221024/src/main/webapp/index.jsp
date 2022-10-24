<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.getRequestDispatcher("main.do").forward(request, response); //main.do 라는 페이지를 재요청 froward로
%>