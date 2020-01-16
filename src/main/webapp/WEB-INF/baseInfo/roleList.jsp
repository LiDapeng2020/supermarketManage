<%--
  Created by IntelliJ IDEA.
  User: 李大鹏
  Date: 2020/1/15
  Time: 20:15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/baseInfo/role.js"></script>
</head>
<body>
<!-- 数据网格上方工具栏 -->
<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="toAddRole()">新增</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="toUpdateRole()">编辑</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteRole()">删除</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="toBatchAddRole()">批量导入</a>
    <br>
    <span style="margin-left: 30px">角色名称</span><input id="queryName" class="easyui-textbox" style="width:150px">
    <a id="btn" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="otherQuery()">查询</a>
    <a id="getEmployeeListByRole" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="getEmployeeListByRole()">查看该角色的所有员工</a>
</div>
<!-- 定义数据网格的table -->
<table id="table"></table>
<!-- 定义添加或修改的表单对话框 -->
<div id="dlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
    <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
        <h3>角色信息</h3>
        <div style="margin-bottom:10px">
            <label>角色名称:</label>
            <input name="name" class="easyui-textbox" required="true" style="width:100%">
        </div>
    </form>
</div>
<!-- 定义对话框底部的按钮 -->
<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveOrUpdateRole()" style="width:90px">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
</div>
<!-- 定义文件上传对话框 -->
<div id="batchAddRole" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#userBatchAdd-buttons'">
    <form id="RoleFileForm" method="post" enctype="multipart/form-data">
        <input type="file" name="batchAddRoleFile">
    </form>
</div>
<!-- 定义文件上传对话框底部的按钮 -->
<div id="userBatchAdd-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="javascript:alert('hahah');" style="width:90px">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#batchAddRole').dialog('close')" style="width:90px">取消</a>
</div>
<!-- 定义通过角色显示员工的数据网格的工具栏 -->
<div id="employee-toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
       onclick="javascript:$('#employee-table').edatagrid('addRow')">新增</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
       onclick="javascript:$('#employee-table').edatagrid('saveRow')">保存编辑行</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
       onclick="javascript:$('#employee-table').edatagrid('cancelRow')">取消编辑行</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
       onclick="javascript:$('#employee-table').edatagrid('destroyRow')">删除当前选中的行</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="toBatchAddEmployee()">批量导入</a>
    <br>
    <span style="margin-left: 30px">用户名</span><input id="queryUserName" class="easyui-textbox" style="width:100px">
    <span style="margin-left: 30px">姓名</span><input id="queryEmployeeName" class="easyui-textbox" style="width:100px">
    <span style="margin-left: 30px">入职日期范围</span>
    <input id="queryMinHiredDate" class="easyui-datebox" style="width:120px">-
    <input id="queryMaxHiredDate" class="easyui-datebox" style="width:120px">
    <br><span style="margin-left: 30px">薪资范围</span>
    <input id="queryMinSalary" class="easyui-numberbox" data-options="min:0.00,precision:2" style="width:100px">-
    <input id="queryMaxSalary" class="easyui-numberbox" data-options="min:0.00,precision:2" style="width:100px">
    <span style="margin-left: 30px">手机号</span><input id="queryPhone" class="easyui-textbox" style="width:100px">
    <a id="employee-btn" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="otherQueryEmployee()">查询</a>
</div>
<!-- 定义通过角色显示员工的数据网格的对话框-->
<div id="employee-dialog" class="easyui-dialog" style="width:900px;height:560px" title="该角色下所有的员工" data-options="closed:true,modal:true">
    <table id="employee-table" style="width:820px;height:400px"></table>
</div>
</body>
</html>
