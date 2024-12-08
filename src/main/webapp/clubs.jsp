<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="clubs.css">
<%@include file="adminnav.jsp" %>
</head>
<body>
	<div class="container">
        <c:forEach var="club" items="${clublist}">
            <a href="#">
                <div class="card" style="background-color: ${club.color};">
                    <img src="https://i.ibb.co/stN9Ghb/icons8-basketball-96.png" alt="Image One">
                    <div class="description">
                        <a href="#">${club.name}</a>
                        <p>${club.description}</p>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
</body>
</html>