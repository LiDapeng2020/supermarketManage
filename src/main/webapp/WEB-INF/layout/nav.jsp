<%--
  Created by IntelliJ IDEA.
  User: 李大鹏
  Date: 2020/1/9
  Time: 13:54
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
</head>
<body>
    <!-- 引入点击菜单就会创建标签页的js -->
    <script src="${pageContext.request.contextPath}/static/js/nav.js"></script>
    <!-- 这是手风琴菜单 -->
    <div class="easyui-accordion" data-options="fit:true">
        <div title="基本信息管理" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
            <ul class="easyui-tree" id="tree1" data-options="animate:true">
                <li data-options="attributes:{'url':'${pageContext.request.contextPath}/employee/employeeList',icon:'icon-save'}">员工信息管理</li>
                <li data-options="attributes:{'url':'${pageContext.request.contextPath}/role/roleList',icon:'icon-save'}">角色信息管理</li>
                <li data-options="attributes:{'url':'${pageContext.request.contextPath}/supplier/list',icon:'icon-save'}">供应商信息管理</li>
                <li data-options="attributes:{'url':'${pageContext.request.contextPath}/customer/list',icon:'icon-save'}">客户信息管理</li>
            </ul>
        </div>
        <div title="商品信息管理" data-options="iconCls:'icon-help'" style="padding:10px;">
            <ul class="easyui-tree" id="tree3" data-options="animate:true">
                <li data-options="attributes:{'url':'${pageContext.request.contextPath}/product/typeList',icon:'icon-save'}">商品种类信息管理</li>
                <li data-options="attributes:{'url':'${pageContext.request.contextPath}/product/unitList',icon:'icon-save'}">商品单位信息管理</li>
                <li data-options="attributes:{'url':'${pageContext.request.contextPath}/product/list',icon:'icon-save'}">普通商品信息管理</li>
            </ul>
        </div>
        <div title="进货信息管理" data-options="iconCls:'icon-help'" style="padding:10px;">
            <ul class="easyui-tree" id="tree2" data-options="animate:true">
                <li data-options="attributes:{'url':'${pageContext.request.contextPath}/purchaseBase/list',icon:'icon-save'}">进货信息管理</li>
                <li data-options="attributes:{'url':'${pageContext.request.contextPath}/product/list',icon:'icon-save'}">商品种类信息管理</li>
                <li data-options="attributes:{'url':'${pageContext.request.contextPath}/product/list',icon:'icon-save'}">货架商品信息管理</li>
                <li data-options="attributes:{'url':'${pageContext.request.contextPath}/product/list',icon:'icon-save'}">货架下架商品信息管理</li>
                <li data-options="attributes:{'url':'${pageContext.request.contextPath}/product/list',icon:'icon-save'}">库存商品信息管理</li>
                <li data-options="attributes:{'url':'${pageContext.request.contextPath}/product/list',icon:'icon-save'}">库存退货商品信息管理</li>
                <li data-options="attributes:{'url':'${pageContext.request.contextPath}/product/list',icon:'icon-save'}">销售商品信息管理</li>
            </ul>
    </div>
        <div title="销售信息管理" data-options="iconCls:'icon-search'" style="padding:10px 0;">

        </div>
    </div>
</body>
</html>