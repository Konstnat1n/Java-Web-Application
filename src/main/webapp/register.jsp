<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register</title>
    <style>
        .button {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            display: inline-block;
            text-align: center;
            margin-top: 20px;
        }
        .button-back {
            background-color: #6c757d;
        }
    </style>
</head>
<body>
<h1>Register</h1>
<form action="register" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required /><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required /><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required /><br><br>

    <button type="submit" class="button">Register</button>
</form>

<!-- Back to Start Page Button -->
<a href="index.jsp" class="button button-back">Back to Start Page</a>

<!-- Display error message -->
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

<!-- Success message -->
<c:if test="${param.success == '1'}">
    <p style="color: green;">Registration successful. You can now <a href="login.jsp">log in</a>.</p>
</c:if>
</body>
</html>
