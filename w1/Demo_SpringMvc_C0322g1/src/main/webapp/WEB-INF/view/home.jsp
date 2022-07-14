<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 13/07/2022
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <style>
        tr,td,table{
            border: 4px dotted red;
            border-radius: 10px;
            border-collapse: collapse;
        }
        table{
            width: 1000px;

            height: auto;
            margin: auto;

        }
        body{
            padding-top: 100px;
        }
        img{
            width: 300px;
            height: auto;
        }
    </style>
</head>
<body>
<table>
    <tr><a href="/home-create"> <button>Tạo</button></a>
    </tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td><img src="${p.img}" width="300" height="250"></td>
            <td><a href="/product-edit?id=${p.id}"> <button>Edit</button></a></td>
            <td><a href="/product-delete?id=${p.id}" class="delete"> <button>Delete</button></a></td>
        </tr>
    </c:forEach>
</table>
</body>
<script>
    let link=document.querySelectorAll('.delete')

    for (let i=0;i<link.length;i++){
        link[i].addEventListener('click',function (evt){
            evt.preventDefault()
            let cf=confirm("Bạn chắc chắn xóa")
            if (cf){
                window.location.href=this.getAttribute('href')
            }

        })
    }


</script>
</html>
