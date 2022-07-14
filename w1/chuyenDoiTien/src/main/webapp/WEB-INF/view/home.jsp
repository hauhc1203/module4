<%--
  Created by IntelliJ IDEA.
  User: hauhc1203
  Date: 13/07/2022
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuyen doi tien te</title>
</head>
<body>
<form action="/chuyendoi" method="get">
    USD:
    <input type="number"  name="usd" value="${usd}"><br><br>
    VND:
    <input type="number" name="vnd" value="${vnd}" ><br><br>
    <button type="submit">Chuyen doi</button>
</form>
<h1>${test}</h1>
<a href="/tudien">Tu dien</a>
</body>
</html>
