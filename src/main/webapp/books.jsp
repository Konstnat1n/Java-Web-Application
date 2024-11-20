<%@ taglib uri="/WEB-INF/tags/bookformatter" prefix="custom" %>
<html>
<body>
<h1>Available Books</h1>
<c:forEach var="book" items="${books}">
    <custom:bookFormatter title="${book.title}" author="${book.author}" />
</c:forEach>
</body>
</html>
