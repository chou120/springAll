<%--
  Created by IntelliJ IDEA.
  User: edy
  Date: 2021/8/17
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>

<form action="validate" method="post">
    用户名：<input type="text" name="name" id="name"/>${ERROR_name}
    <br>
    邮箱：<input type="text" name="email" id="email"/>${ERROR_email}
    <br>
    年龄：<input type="text" name="age" id="age"/>${ERROR_age}
    <br>
    <input type="submit" value="提交" />
</form>
<%--注意:引入的第三方js,需要在body里面去写,不然没法加载出来--%>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js" type="text/javascript"></script>
<script type="text/javascript">
    function validatePerson(){
        let username=$('#name').val();



    }
</script>
</body>
</html>
