<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Club Registration</title>
    <link rel="stylesheet" href="eventclubregistration.css">
    <%@include file="studentnav.jsp" %>
</head>
<body>
    <div class="container">
        <c:forEach var="club" items="${clublist}">
            <div class="card" style="background-color: ${club.color};">
                <img src="https://i.ibb.co/stN9Ghb/icons8-basketball-96.png" alt="Image One">
                <div class="description">
                    <form id="clubForm${club.id}" action="events" method="post" style="display: inline;">
                        <input type="hidden" name="clubId" value="${club.id}">
                        <!-- Use a link styled to look like regular text -->
                        <a href="#" onclick="document.getElementById('clubForm${club.id}').submit(); return false;">
                            ${club.name}
                        </a>
                    </form>
                    <p>${club.description}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
