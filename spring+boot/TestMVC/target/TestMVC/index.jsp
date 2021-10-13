<html>
<body>
<h2>Hello World!</h2>
<%--<jsp:forward page="pages/TestBean.jsp"></jsp:forward>--%>
<%--<jsp:forward page="pages/InterceptorLogin.jsp"></jsp:forward>--%>
<jsp:forward page="pages/fileUpload.jsp"></jsp:forward>
</body>
</html>


<%--为了测试rest风格--%>
<%--
<%@ page language="java" contentType="text/html; charset=UTF-8"
                           pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>REST风格</title>
</head>
<body>

<h4>发送GET请求</h4>
<a href="user/1">GET</a>

<h4>发送POST请求</h4>
<form action="user/1" method="post">
    <input type="submit" value="POST" />
</form>

<!-- 发送PUT和DELETE请求时，需要添加一个隐藏域 -->
<h4>发送PUT请求</h4>
<form action="user/1" method="post">
    <input type="hidden" name="_method" value="PUT" /> <input
        type="submit" value="PUT" />
</form>

<h4>发送DELETE请求</h4>
<input type="hidden" name="_method" value="DELETE" />
<form action="user/1" method="post">
    <input type="hidden" name="_method" value="DELETE" /> <input
        type="submit" value="DELETE" />
</form>
</body>
</html>--%>
