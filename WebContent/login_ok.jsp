<%@page import="com.gg.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberVO vo = (MemberVO)session.getAttribute("loginok");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
<% if (vo == null) { %>
	alert("로그인 실패");
	location.href = "login.gg";
<% }  else { %>
	alert("로그인 성공");
	location.href = "main.gg";
<% }   %>
</script>

</body>
</html>