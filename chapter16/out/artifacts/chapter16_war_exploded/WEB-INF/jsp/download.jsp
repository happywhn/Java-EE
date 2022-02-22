<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2022/2/16
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件下载</title>
</head>
<body>
<%--    <a href="${pageContext.request.contextPath}/Download?filename=壁纸.jpg">--%>
<%--        文件下载--%>
<%--    </a>--%>
<a href="${pageContext.request.contextPath}/Download?filename=<%=URLEncoder.encode("壁纸.jpg","UTF-8")%>">
    文件下载
</a>
</body>
</html>
