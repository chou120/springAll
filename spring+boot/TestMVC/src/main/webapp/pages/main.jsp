<%--
  Created by IntelliJ IDEA.
  User: edy
  Date: 2021/8/17
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>主界面</title>
</head>
<body>
欢迎 ${user.username }，登录一窝宝！<br />
<a href="${pageContext.request.contextPath }/logout">退出</a>
</body>
</html>
