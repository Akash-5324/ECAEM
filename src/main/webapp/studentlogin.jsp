<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>  

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="studentlogin.css">
</head>

<body >

    <div class="container" id="container">
        <div class="form-container sign-up">
            <form method="post" action="insertstudent">
                <h1>Create Account</h1>
                <input type="text" placeholder="ID" name="sid" required>
                <input type="text" placeholder="Name" name="sname" required>
                <input type="email" placeholder="Email" name="semail" required>
                <input type="password" placeholder="Password" name="spwd">
                <input type="text" placeholder="Department" name="sdepartment" required />
                <select name="sgender" id="sgender" class="form-select" required>
                    <option value="" disabled selected>Select Gender</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Others">Others</option>
                </select>
                <input type="date" name="sdob" required />
                <input type="number" name="scontact" placeholder="Number" required />
                <button type="submit" value="Register" class="btn btn-success">Sign Up</button>
            </form>
        </div>
        <div class="form-container sign-in">
            <h4 align="center" style="color:red">
                <c:out value="${message}"></c:out><br/>
            </h4>
            <form method="post" action="checkstudentlogin">
                <h1>Sign In</h1>
                <input type="text" name="semail" placeholder="Email" required />
                <input type="password" name="spwd" placeholder="Password" required />
                <button type="submit" value="Login" >Sign In</button>
            </form>
        </div>
        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-left">
                    <h2>Welcome Back!</h2>
                    <p>Enter your personal details to use all of site features</p>
                    <button class="hidden" id="login">Sign In</button>
                </div>
                <div class="toggle-panel toggle-right">
                    <h2>Hello, Friend!</h2>
                    <p>Register with your personal details to use all of site features</p>
                    <button class="hidden" id="register">Sign Up</button>
                </div>
            </div>
        </div>
    </div>

    <script src="studentlogin.js"></script>
</body>

</html>