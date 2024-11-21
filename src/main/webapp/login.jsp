<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <style>
        .button {
            padding: 10px 20px;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            display: inline-block;
            background-color: #007bff;
            margin-top: 10px;
        }
        .button-start {
            background-color: #6c757d; /* Gray button for the Start Page */
        }
    </style>
</head>
<body>
<h1>Login</h1>
<form action="login" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required /><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required /><br><br>

    <button type="submit">Login</button>
</form>

<!-- Display error message if present -->
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

<!-- Button to go to Start Page -->
<a href="index.jsp" class="button button-start">Go to Start Page</a>

</body>
</html>
