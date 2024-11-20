<html>
<head>
  <title>Update Book</title>
</head>
<body>
<h1>Update Book</h1>
<form action="update" method="post">
  <input type="hidden" name="id" value="${id}" />
  <label>Title: <input type="text" name="title" value="${title}" /></label><br>
  <label>Author: <input type="text" name="author" value="${author}" /></label><br>
  <label>Genre: <input type="text" name="genre" value="${genre}" /></label><br>
  <label>Description: <textarea name="description">${description}</textarea></label><br>
  <button type="submit">Update</button>
</form>
</body>
</html>
