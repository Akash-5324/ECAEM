<%@page import="com.klef.jfsd.springboot.entity.Club"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Club c = (Club)session.getAttribute("club");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Page</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="clubprofile.css" rel="stylesheet">
</head>
<body >
    
    <%@include file="clubnav.jsp" %>

<div class="profile-container">
    <div class="banner-container">
        <label for="banner-upload" class="banner-label">
            <input type="file" id="banner-upload" style="display: none;">
            <div class="banner-placeholder">Click to upload banner</div>
        </label>
        <label for="profile-upload" class="profile-pic-label">
            <input type="file" id="profile-upload" style="display: none;">
            <div class="profile-pic-placeholder"></div>
        </label>
    </div>
    <div class="profile-info">
        <div class="info-item">
            <label for="name"><strong>Name:</strong></label>
            <input type="text" id="name" value="<%=c.getName()%>" disabled>
        </div>
        <div class="info-item">
            <label for="email"><strong>Email:</strong></label>
            <input type="text" id="email" value="<%=c.getEmail()%>" disabled>
        </div>
        <div class="info-item">
            <label for="department"><strong>Description:</strong></label>
            <input type="text" id="department" value="<%=c.getDescription()%>" disabled>
        </div>
        <div class="info-item">
            <label for="department"><strong>No.of Events:</strong></label>
            <input type="text" id="department" value="${count}" disabled>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
