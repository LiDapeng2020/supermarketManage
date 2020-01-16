<%--
  Created by IntelliJ IDEA.
  User: 李大鹏
  Date: 2020/1/15
  Time: 20:58
  Description: 系统的404界面(功能已经完善，不需要在修改)2020-01-15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" isErrorPage="true" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>不好意思您访问的页面不存在</title>
    <link href="${pageContext.request.contextPath}/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/static/h-ui/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="page-404 text-c">
    <p class="error-title"><i class="Hui-iconfont">&#xe688;</i>404</p>
    <p class="error-description">不好意思，您访问的页面不存在~</p>
</div>
</body>
</html>
