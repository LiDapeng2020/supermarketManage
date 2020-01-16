<%--
  Created by IntelliJ IDEA.
  User: 李大鹏
  Date: 2020/1/15
  Time: 21:56
  Description: 系统的凭证过期界面(功能已经完善，不需要在修改)2020-01-15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<script>
    $(function () {
        $.messager.confirm('您的凭证已过期','重新登录?',function (flag) {
            if (flag) {
                parent.location.href = '${pageContext.request.contextPath}';
            }else {
                $.messager.progress('close');
            }
        });
    })
</script>
</body>
</html>
