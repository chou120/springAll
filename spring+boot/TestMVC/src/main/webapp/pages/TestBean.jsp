<%--
  Created by IntelliJ IDEA.
  User: edy
  Date: 2021/8/13
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC支持对多种类型的请求参数进行封装</title>
</head>
<body>
        <%--<h2>基本类型参数封装</h2>
        <form action="param" method="get">
            用户名：<input type="text" name="username"><br>
            年龄：<input type="text" name="age"><br>
            <input type="submit" value="提交">
        </form>--%>


      <%--  <h2>Pojo类型参数封装</h2>
        <form action="paramPojo" method="post">
            用户名：<input type="text" name="username"><br>
            年龄：<input type="text" name="age"><br>
            出生日期：<input type="datetime-local" name="birthday"><br>
            <input type="submit" value="提交">
        </form>--%>

       <%-- <h2>包装Pojo类型参数封装</h2>
        <form action="paramPojoAndOtherPojo" method="post">
            用户名：<input type="text" name="username"><br>
            年龄：<input type="text" name="age"><br>
            省份：<input type="text" name="address.province"><br>
            城市：<input type="text" name="address.city"><br>
            <input type="submit" value="提交">
        </form>--%>

        <%--<h2>List集合类型参数封装</h2>
        <form action="paramList" method="post">
            用户名：<input type="text" name="username"><br>
            年龄：<input type="text" name="age"><br>
            省份1：<input type="text" name="address[0].province"><br>
            城市1：<input type="text" name="address[0].city"><br>
            省份2：<input type="text" name="address[1].province"><br>
            城市2：<input type="text" name="address[1].city"><br>
            <input type="submit" value="提交">
        </form>--%>


       <%-- <form action="paramDate" method="post">
            用户名：<input type="text" name="username"><br>
            年龄：<input type="text" name="age"><br>

            生日:<input type="datetime-local"  name="birthday"><br>

            <input type="submit" value="提交">
        </form>

--%>

        <%--<form action="paramServletAPI" method="post">
           <label id="username">用户名:</label>
            <input type="text" value="" placeholder="用户名" name="username"><br>
            <label id="password">密码:</label>
            <input type="password" value="" placeholder="密码" name="password"><br>
            <input type="submit" value="登录">
        </form>--%>
        <a href="model">Model</a>
        <a href="modelMap">ModelMap</a>
        <br>
        <a href="session2">session2</a>

        <br>
        <a href="forward">转发字符串</a> <br>
        <a href="redirect">重定向字符串</a>
        <a href="mv">modelAndView对象</a>

        <a href="gologin">去登录</a>




</body>
</html>
