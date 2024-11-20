<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Add New Book</title>
</head>
<body>
<h1>Add a New Book</h1>
<form action="addBook" method="post">
  <label for="title">Title:</label>
  <input type="text" id="title" name="title" required /><br><br>

  <label for="author">Author:</label>
  <input type="text" id="author" name="author" required /><br><br>

  <label for="genre">Genre:</label>
  <input type="text" id="genre" name="genre" /><br><br>

  <label for="description">Description:</label>
  <textarea id="description" name="description"></textarea><br><br>

  <button type="submit">Add Book</button>
</form>
<br>
<a href="books">Back to Book List</a>
</body>
</html>
