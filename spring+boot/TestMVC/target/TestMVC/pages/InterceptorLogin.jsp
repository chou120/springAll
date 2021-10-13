<%--
  Created by IntelliJ IDEA.
  User: edy
  Date: 2021/8/17
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>测试拦截器</title>
</head>
<body>
    ${msg}
    <form action="login" method="post">
        用户名：<input type="text" name="username" /><br>
        密码：<input type="password" name="password" /><br>
        <input type="submit" value="登录" />
    </form>
</body>
</html>
