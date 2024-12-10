<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Club Page</title>
    <link rel="stylesheet" href="club.css">
</head>
<body>
<%@include file="adminnav.jsp" %>
    <div class="club-abmin">
        <a href="clubs">
            <div class="card club-entry">
                <img src="https://i.ibb.co/stN9Ghb/icons8-basketball-96.png" alt="Image One">
                <div class="description-club-main">
                    <a href="clubs">Clubs</a>
                    <p>Connect with me professionally</p>
                </div>
            </div>
        </a>

        <a href="clubregistration">
            <div class="card club-events">
            <a href="clubregistration">
                <img src="https://i.ibb.co/518L3fz/icons8-web-100.png" alt="Image Two">
                <div class="description-club-main">
                    <a href="clubregistration">Club Registration</a>
                    <p>Follow me for updates</p>
                </div>
            </div>
        </a>
    </div>
</body>
</html>