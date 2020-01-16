<%--
  Created by IntelliJ IDEA.
  User: 李大鹏
  Date: 2020/01/14
  Time: 16:25
  Description: 系统的登陆界面(功能已经完善，不需要在修改)2020-01-15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>超市管理系统登录页面</title>
    <!-- -----------------------引入Jquery EasyUI所必须的资源--------------------------- -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/locale/easyui-lang-zh_CN.js"></script>
    <!-- ----------------------以上是Jquery EasyUI所必须的资源--------------------------- -->
    <!-- 引入登录页面的css和js文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/login.js"></script>
    <!-- 配置ctp为当前项目的全路径-->
    <script type="text/javascript">ctp = "${pageContext.request.contextPath}";</script>
</head>
<body>
<div align="center">
    <!-- 这是登录页面上面的文字图片 -->
    <div id="loginImage"><img src="${pageContext.request.contextPath}/static/images/title.gif" width="900px" height="100px"></div>
    <!-- 这是登录页面的登陆面板 -->
     <div id="loginPanel">
        <div class="easyui-panel" title="用户登录" style="background:orange;width:100%;max-width:400px;padding:30px 60px;">
            <form id="loginForm" method="post">
                <div align="center" id="loginError">&nbsp;</div>
                <div style="margin-bottom:20px">
                    <input class="easyui-textbox" name="username" style="width:100%"
                           data-options="label:'用户名:',required:true">
                </div>
                <div style="margin-bottom:20px">
                    <input class="easyui-passwordbox" name="password" style="width:100%"
                           data-options="label:'密码:',required:true">
                </div>
            </form>
            <div style="text-align:center;padding:5px 0">
                <button class="easyui-linkbutton" onclick="submitForm()" style="width:80px">登录</button>
                <button class="easyui-linkbutton" onclick="clearForm()" style="width:80px">清除</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>