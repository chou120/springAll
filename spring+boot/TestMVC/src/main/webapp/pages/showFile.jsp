<%--
  Created by IntelliJ IDEA.
  User: edy
  Date: 2021/8/17
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>上传成功</title>
</head>
<body>
        文件描述：${fileDomain.description }
        <br>
        <!-- fileDomain.getMyFile().getOriginalFilename()-->
        文件名称：${fileDomain.myfile.originalFilename }


</body>
</html>
