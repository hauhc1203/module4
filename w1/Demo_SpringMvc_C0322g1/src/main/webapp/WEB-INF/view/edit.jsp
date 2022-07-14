<%--
  Created by IntelliJ IDEA.
  User: hauhc1203
  Date: 02/07/2022
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Thêm Học Sinh</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <style>
    form{
      width: 500px;
      height:  auto;
      margin: auto;
      padding: 50px;
      border: 3px dotted red;
      position: relative;
    }
    select,input{
      width: 300px;
      height: auto;
    }
    h3   {
      text-align: center;
    }
    button{
      position: relative;
      left: 50%;
      transform: translateX(-50%);;
    }
    img{
      width: 300px;
      height: auto;
    }
  </style>
</head>
<body>
<form action="/product-edit?id=${product.id}" method="post" >
  <h3>Thêm Sản Phẩm mới</h3>
  <br>

  Name<br>
  <input type="text" placeholder="nhập vào tên" name="name" required value="${product.name}"><br><br>

  IMG Cũ <br>
  <img src="${product.img}"  alt="" ><br><br>
  <input name="oldIMG" value="${product.img}" hidden>
  New IMG URL <br>
  <input type="text" placeholder="nhập vào link anh" name="img"  value=""><br><br>
  Price <br>
  <input type="text" placeholder="nhập vào gia" name="price" required value="${product.price}"><br><br>

  <br><br>
  <button type="submit" class="btn btn-primary">Edit</button>

</form>
</body>
</html>