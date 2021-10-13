
<%--
  Created by IntelliJ IDEA.
  User: edy
  Date: 2021/8/12
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title></title>
</head>
<body>
    访问成功啦...
    yiwobao:${requestScope.request}<br>
    IsYiwobao:${sessionScope.session}<br>
    用户名和密码为:${sessionScope.msg}<br>


    获取Model数据-${requestScope.model}
    <hr/>
    获取ModelMap数据-${requestScope.modelMap}
    <br>

    request:${requestScope.name}<br/>
    session:${sessionScope.name}<br/>


    <br>
    session2:${sessionScope.yiwobao}
    request:${requestScope.yiwobao}


        
    <img src="${pageContext.request.contextPath}/images/girl.jpg" height="200px" width="300px">

</body>
</html>
