<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Students List</title>
    <link rel="stylesheet" type="text/css" href="students.css">
</head>
<body>
    <div class="content">
        <h1>Students List</h1>
        <table class="students-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.email}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="button-container">
            <button class="back-button" onclick="goBack()">Back</button>
        </div>
    </div>

    <script>
        // Redirect to the previous page
        function goBack() {
            history.back();
        }
    </script>
</body>
</html>
