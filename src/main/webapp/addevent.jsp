<%@page import="com.klef.jfsd.springboot.entity.Club"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Club c = (Club)session.getAttribute("club");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ECAEM Club Management</title>
    <link rel="stylesheet" href="addevent.css">
</head>
<body>
	<%@include file="clubnav.jsp" %>
    <main class="event-main">
        <div class="event-abmin-container">
            <div class="event-abmin-heading"><h2>Event Entry</h2></div>
        <form class="event-form" method="post" action="insertevent">
            <div class="form-group">
                <label for="name">Club Id:</label>
                <input type="number" id="cid" name="cid" value="<%=c.getId()%>" readonly required>
            </div>
            <div class="form-group">
                <label for="name">Event Name:</label>
                <input type="text" id="ename" name="ename" required>
            </div>
            <div class="form-group">
                <label for="name">Event Date:</label>
                <input type="text" id="edate" name="edate" required>
            </div>  
            <div class="form-group">
                <label for="name">Event time:</label>
                <input type="text" id="etime" name="etime" required>
            </div>
            <div class="form-group">
                <label for="name">Event Venue:</label>
                <input type="text" id="evenue" name="evenue" required>
            </div>
            <div class="save">

            <button>Save</button> 
        </div>
        </form>
    </div>
        
    </main>
</body>
</html>