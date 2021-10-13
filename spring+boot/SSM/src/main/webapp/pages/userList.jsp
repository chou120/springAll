<%--
  Created by IntelliJ IDEA.
  User: edy
  Date: 2021/8/17
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示用户</title>
</head>
<body>
<h3>userTable</h3>
<table border="1">
    <tr>
        <td>id</td>
        <td>username</td>
        <td>birthday</td>
        <td>sex</td>
        <td>address</td>
    </tr>
    <!--
    items: 需要需要遍历的集合
    var： 每个对象的变量名称
    -->
    <c:forEach items="${list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.birthday}</td>
            <td>${user.sex}</td>
            <td>${user.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
