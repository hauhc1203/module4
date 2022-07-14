<%--
  Created by IntelliJ IDEA.
  User: hauhc1203
  Date: 14/07/2022
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/tinh">
    Number1: <input type="number" name="num1" value="${num1}"><br><br>
    Number2: <input type="number" name="num2" value="${num2}"><br><br>
    <button type="submit" name="dau" value="cong">+</button>
    <button type="submit" name="dau" value="-">-</button>
    <button type="submit" name="dau" value="x">x</button>
    <button type="submit" name="dau" value="chia">/</button>
</form>
<div><h1>KQ:</h1>
    <h1>${kq}</h1>
</div>
</body>
</html>
