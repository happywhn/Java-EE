<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2022/2/15
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>系统主页</title>
</head>
<body>
    当前用户：${USER_SESSION.username}
    <a href="${pageContext.request.contextPath}/logout">退出</a>
</body>
</html>
