<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2022/2/13
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RESTful 测试</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js">
    </script>
    <script type="text/javascript">
        function search() {
            // 获取输入的查询编号
            var id = $("#number").val();
            $.ajax({
                url : "${pageContext.request.contextPath}/user/"+id,
                type : "GET",
                // 定义回调响应的数据格式为JSON字符串，该属性可以省略
                dataType : "json",
                // 成功响应的结果
                success : function (data) {
                    if(data.username != null) {
                        alert("您查询的用户是："+data.username);
                    }else{
                        alert("没有找到id为："+id+"的用户");
                    }
                }
            })
        }
    </script>
</head>
<body>
<form>
    编号：<input type="text" name="number" id="number">
    <input type="button" value="搜索" onclick="search()"/>
</form>
</body>
</html>
