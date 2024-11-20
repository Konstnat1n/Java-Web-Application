<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://example.com/tags/bookformatter" prefix="custom" %>
<html>
<head>
    <title>Book Management</title>
    <style>
        .add-button {
            float: right;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            display: inline-block;
            text-align: center;
        }
        .logout {
            color: red;
            text-decoration: none;
            margin-bottom: 20px;
            display: inline-block;
        }
        .book-container {
            border: 1px solid #ddd;
            padding: 10px;
            margin: 10px 0;
        }
    </style>
</head>
<body>
<h1>Available Books</h1>

<!-- Logout Button -->
<a href="logout" class="logout">Logout</a>

<!-- Add Book Button -->
<a href="addBook.jsp" class="add-button">Add a New Book</a>
<br><br><br>

<!-- Book List -->
<c:if test="${not empty books}">
    <c:forEach var="book" items="${books}">
        <div class="book-container">
            <!-- Book Details -->
            <custom:bookFormatter
                    title="${book.title}"
                    author="${book.author}"
                    genre="${book.genre}"
                    description="${book.description}" />

            <!-- Update and Delete Buttons -->
            <form action="update" method="get" style="display: inline;">
                <input type="hidden" name="id" value="${book.id}" />
                <button type="submit" style="padding: 10px 20px; background-color: #007bff; color: white; border: none; border-radius: 5px; cursor: pointer; margin-right: 10px;">
                    Edit
                </button>
            </form>

            <form action="delete" method="post" style="display: inline;">
                <input type="hidden" name="id" value="${book.id}" />
                <button type="submit" style="padding: 10px 20px; background-color: #dc3545; color: white; border: none; border-radius: 5px; cursor: pointer;">
                    Delete
                </button>
            </form>
        </div>
    </c:forEach>
</c:if>
<c:if test="${empty books}">
    <p>No books are currently available.</p>
</c:if>
</body>
</html>
