<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="seventlist.css">
    <%@ include file="clubnav.jsp" %>
</head>
<body>
	<div class="event-list-container">
        <h1 class="list-page-title">My Registered Events</h1>
        <c:forEach var="event" items="${events}">
        <form method="POST" action="students">
        <div class="event-list">
          <!-- Event Cards -->
          <div class="event-list-card">
            <div class="event-list--info">
              <h2 class="event-list-title">${event.name}</h2>
              <p class="event-list-date">${event.date}</p>
              <p class="event-list-location">${event.venue}</p>
              <!-- Hidden input for Event ID -->
              <input type="hidden" name="eventId" value="${event.id}">
              <button class="list-details-btn" type="submit">View Details</button>
            </div>
          </div>
        </div>
        </form>
        </c:forEach>
      </div>
</body>
</html>
