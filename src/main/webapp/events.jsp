<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Booking Page</title>
    <link rel="stylesheet" href="events.css">
    <%@ include file="studentnav.jsp" %>
</head>
<body>

    <!-- Event Cards Section -->
    <section class="events">
        <c:forEach var="event" items="${eventlist}">
            <div class="event-card" style="background-image: url('concert.jpg');" data-event-id="${event.id}">
                <div class="event-content">
                    <h2>${event.name}</h2>
                    <p>${event.venue}</p>

                    <c:choose>
                        <c:when test="${bookedEventIds.contains(event.id)}">
                            <button class="booked-button" disabled>Booked</button>
                        </c:when>
                        <c:otherwise>
                            <button class="book-button" onclick="openModal('${event.id}', '${event.name}')">Book Now</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </c:forEach>
    </section>

    <!-- Modal for Booking Confirmation -->
    <div id="confirmationModal" class="modal">
        <div class="modal-content">
            <h2 id="modal-title"></h2>
            <p id="modal-message"></p>
            <form id="bookForm" method="post" action="bookevent">
                <input type="hidden" name="eventId" id="eventId">
                <button type="submit" class="confirm-button">Confirm Booking</button>
                <span class="cancel-button" onclick="closeModal()">&times;</span>
            </form>
        </div>
    </div>

    <!-- Success Notification Popup -->
    <div id="successPopup" class="success-popup" style="display:none;">
        <p>Booking Confirmed Successfully!</p>
    </div>

    <script src="events.js"></script>
</body>
</html>
