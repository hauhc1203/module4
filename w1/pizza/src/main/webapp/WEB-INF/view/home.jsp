<%--
  Created by IntelliJ IDEA.
  User: hauhc1203
  Date: 14/07/2022
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/home/save" method="post">
    <input type="checkbox" id="vehicle1" name="giavi" value="mamtom">
    <label for="vehicle1"> Mắm tôm</label><br>
    <input type="checkbox" id="vehicle2" name="giavi" value="mamtep">
    <label for="vehicle2"> Mắm tép</label><br>
    <input type="checkbox" id="vehicle3" name="giavi" value="tuongot">
    <label for="vehicle3">Tương ớt</label><br>
    <button type="submit">Save</button>
</form>
<c:forEach var="gv" items="${giavi2}">
    <h1>${gv}</h1>
</c:forEach>

</body>
</html>
