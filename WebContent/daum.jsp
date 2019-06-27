<%@page import="com.gg.vo.MovieVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>
<%
String list =  (String)request.getAttribute("mvlist");
%>
<div class="container-fluid">
 다음 영화 리스트<br>
</div>

</body>
</html>