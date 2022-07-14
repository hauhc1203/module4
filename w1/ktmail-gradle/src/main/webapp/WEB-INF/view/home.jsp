<%--
  Created by IntelliJ IDEA.
  User: hauhc1203
  Date: 14/07/2022
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>Home</h1>
<h1>${kq}</h1>

<form action="/home/check">
  Email: <input type="email" name="email">
  <button type="submit">Check</button>
</form>

</body>
</html>