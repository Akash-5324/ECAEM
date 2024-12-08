<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>  

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="ClubAdminLogin.css">
    <title>Modern Login Page | AsmrProg</title>
</head>

<body>

    <div class="container" id="container">
        <div class="form-container sign-up">
            <h4 align="center" style="color:red">
                <c:out value="${message}"></c:out><br/>
            </h4>
            <form method="post" action="checkadminlogin">
                <h1>Admin Login</h1>
                <input type="text" name="auname" placeholder="Username" required />
                <input type="password" name="apwd" placeholder="Password" required />
                <button type="submit" value="Login" >Sign In</button>
            </form>
        </div>
        <div class="form-container sign-in">
            <h4 align="center" style="color:red">
                <c:out value="${message}"></c:out><br/>
            </h4>
            <form method="post" action="checkclublogin">
                <h1>Club Login</h1>
                <input type="text" name="cname" placeholder="Club Name" required />
                <input type="password" name="cpwd" placeholder="Password" required />
                <button type="submit" value="Login" >Sign In</button>
            </form>
        </div>
        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-left">
                    <h2>Club Login</h2>
                    <button class="hidden" id="login">Sign In</button>
                </div>
                <div class="toggle-panel toggle-right">
                    <h2>Admin Login</h2>
                    <p>Register with your personal details to use all of site features</p>
                    <button class="hidden" id="register">Sign In</button>
                </div>
            </div>
        </div>
    </div>

    <script src="ClubAdminLogin.js"></script>
</body>

</html>