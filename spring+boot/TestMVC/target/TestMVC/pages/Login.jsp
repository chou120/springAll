<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js" type="text/javascript"></script>
    <script>
        function testJson() {
            let name=$('#username').val();
            alert("----"+name);
            let newAge=$("#age").val();
            let newProvince=$("#province").val();
            let newCity=$("#city").val();
            let newBirthday=$("#birthday").val();
            let strJson={
                username:name,
                age:newAge,
                address:{
                    province:newProvince,
                    city:newCity},
                birthday:newBirthday
            };

            $.ajax({
                url:"${pageContext.servletContext.contextPath}/user/json",
                data:JSON.stringify(strJson),//JSON.stringify()必须有,否则只会当做表单的格式提交
                dataType:"json",
                type:"post",
                contentType:"application/json;charset=utf-8",//如果想以json格式把数据提交到后台的话，这个必须有，否则只会当做表单提交
                success:function (data) {
                    console.log("----"+data);
                }
            });
        };
    </script>
</head>
<body>

            用户名：<input type="text" name="username" id="username"><br>
            年龄：<input type="text" name="age" id="age"><br>
            省份：<input type="text" name="address.province" id="province"><br>
            城市：<input type="text" name="address.city" id="city"><br>
            出生日期：<input type="datetime-local" name="birthday" id="birthday"><br>
            <input type="submit" value="提交" onclick="testJson()">


</body>
</html>