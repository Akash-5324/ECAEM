<%@page import="com.klef.jfsd.springboot.entity.Club"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Club c = (Club)session.getAttribute("club");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="studenthome.css" rel="stylesheet">
</head>
<body>
<%@include file="clubnav.jsp" %>

<div class="home-text">
    <p>Welcome, <%=c.getName()%></p>
</div>

</body>
</html>