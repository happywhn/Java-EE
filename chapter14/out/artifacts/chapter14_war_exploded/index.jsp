<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2022/2/13
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试JSON交互</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js">
    </script>
    <script type="text/javascript">
        function testJson() {
            // 获取输入的用户名和密码
            var username = $("#username").val();
            var password = $("#password").val();
            $.ajax({
                url : "${pageContext.request.contextPath}/testJson",
                type : "post",
                // data 表示发送的数据
                data : JSON.stringify({username:username,password:password}),
                // 定义发送请求的数据格式为JSON字符串
                contentType : "application/json;charset=UTF-8",
                // 定义回调响应的数据格式为JSON字符串，该属性可以省略
                dataType : "json",
                // 成功响应的结果
                success : function (data) {
                    if (data != null) {
                        alert("您输入的用户名为："+data.username+
                        "密码为："+data.password);
                    }
                }
            })
        }
    </script>
</head>
<body>
<form>
    用户名：<input type="text" name="username" id="username"><br/>
    密&nbsp;&nbsp;&nbsp;码：
        <input type="password" name="password" id="password"><br/>
        <input type="button" value="测试JSON交互" onclick="testJson()"/>
</form>
</body>
</html>
