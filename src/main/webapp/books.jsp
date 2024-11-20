<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://example.com/tags/bookformatter" prefix="custom" %>
<html>
<head>
    <title>Book Management</title>
</head>
<body>
<h1>Available Books</h1>

<c:if test="${not empty books}">
    <c:forEach var="book" items="${books}">
        <!-- Use the custom tag -->
        <custom:bookFormatter
                title="${book.title}"
                author="${book.author}"
                genre="${book.genre}"
                description="${book.description}" />
    </c:forEach>
</c:if>
<c:if test="${empty books}">
    <p>No books are currently available.</p>
</c:if>
</body>
</html>
