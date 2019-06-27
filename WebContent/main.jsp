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
메인 페이지<br>
<% if (vo == null) { %>
<a href="login.gg">로그인</a>
<% }  else { %>
<a href="logout.gg">로그아웃</a>
<% }   %>
<br>
<a href="start.gg"><img alt="게임 스타트" src="http://s.nx.com/s2/game/maplestory/maple2013/image/layout/start.png"></a>


</body>
</html>