<%--
  Created by IntelliJ IDEA.
  User: edy
  Date: 2021/8/17
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
        <form action="fileupload" method="post" enctype="multipart/form-data">
            选择文件：<input type="file" name="myfile"><br>
            文件描述：<input type="text" name="description"><br>
            <input type="submit" value="提交">
        </form>
</body>
</html>
