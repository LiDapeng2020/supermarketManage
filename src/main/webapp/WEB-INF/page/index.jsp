<%--
  Created by IntelliJ IDEA.
  User: 李大鹏
  Date: 2020/1/15
  Time: 11:00
  Description: 系统的主界面(功能已经完善，不需要在修改)2020-01-15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>理工超市管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout">
    <!-- 系统顶部布局 -->
    <div data-options="region:'north',href:'${pageContext.request.contextPath}/layout/top'" style="height:100px;"></div>
    <!-- 系统底部布局 -->
    <div data-options="region:'south',href:'${pageContext.request.contextPath}/layout/south',split:false" style="height:50px;"></div>
    <!-- 系统左边布局 -->
    <div data-options="region:'west',href:'${pageContext.request.contextPath}/layout/nav',title:'菜单导航',split:false" style="width:162px;"></div>
    <!-- 系统右边布局 -->
    <div data-options="region:'east',href:'${pageContext.request.contextPath}/layout/east',title:'我的信息'" style="width:255px;"></div>
    <!-- 系统中央布局 -->
    <div data-options="region:'center'" style="padding:0px;background:#eee;">
        <!-- 中央布局标签页 -->
        <div class="easyui-tabs" id="tabs1" style="width:700px;height:250px" data-options="fit:true">
            <div title="首页" style="padding:0px" data-options="href:'${pageContext.request.contextPath}/layout/head'"></div>
            <div title="Help" data-options="iconCls:'icon-help',closable:true" style="padding:0px">
                This is the help content.
            </div>
        </div>
    </div>
</body>
</html>