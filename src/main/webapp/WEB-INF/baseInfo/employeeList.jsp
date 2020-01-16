<%--
  Created by IntelliJ IDEA.
  User: 李大鹏
  Date: 2020/1/15
  Time: 11:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/baseInfo/employee.js"></script>
</head>
<body>
    <!-- 数据网格上方工具栏 -->
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="toAddEmployee()">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="toUpdateEmployee()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteEmployee()">删除</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="toBatchAddEmployee()">批量导入</a>
        <br>
        <span style="margin-left: 30px">用户名</span><input id="queryUserName" class="easyui-textbox" style="width:150px">
        <span style="margin-left: 30px">姓名</span><input id="queryName" class="easyui-textbox" style="width:150px">
        <span style="margin-left: 30px">入职日期范围</span><input id="queryMinHiredDate" class="easyui-datebox" style="width:150px">-<input id="queryMaxHiredDate" class="easyui-datebox" style="width:150px">
        <br><span style="margin-left: 30px">薪资范围</span><input id="queryMinSalary" class="easyui-numberbox" data-options="min:0.00,precision:2" style="width:150px">-<input id="queryMaxSalary" class="easyui-numberbox" data-options="min:0.00,precision:2" style="width:150px">
        <span style="margin-left: 30px">角色名称</span><input id="queryRoleId" class="easyui-combobox" style="width:150px" data-options="url:'${pageContext.request.contextPath}/role/findAllRole',valueField:'id',textField:'text'">
        <span style="margin-left: 30px">手机号</span><input id="queryPhone" class="easyui-textbox" style="width:150px">
        <a id="btn" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="otherQuery()">查询</a>
    </div>
    <!-- 定义数据网格的table -->
    <table id="table"></table>
    <!-- 定义添加或修改的表单对话框 -->
    <div id="dlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
        <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            <h3>员工信息</h3>
            <div style="margin-bottom:10px">
                <label>姓名:</label>
                <input name="name" class="easyui-textbox" required="true" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <label>用户名:</label>
                <input name="username" class="easyui-textbox" required="true" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <label>密码:</label>
                <input name="password" class="easyui-passwordbox" required="true" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <label>入职时间:</label>
                <input name="hiredDate" class="easyui-datebox" required="true" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <label>工资:</label>
                <input name="salary" class="easyui-numberbox" required="true" style="width:100%" data-options="min:0.00,precision:2,decimalSeparator:'.',max:9999.00">
            </div>
            <div style="margin-bottom:10px">
                <label>手机号:</label>
                <input name="phone" class="easyui-validatebox" required="true" data-options="validType:'phone'"/>
            </div>
            <div style="margin-bottom:10px">
                <label>角色名称:</label>
                <input name="roleId" class="easyui-combobox" required="true" style="width:100%" data-options="url:'${pageContext.request.contextPath}/role/findAllRole',valueField:'id',textField:'text'">
            </div>
        </form>
    </div>
    <!-- 定义对话框底部的按钮 -->
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveOrUpdateEmployee()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
    <!-- 定义文件上传对话框 -->
    <div id="userBatchAdd" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#userBatchAdd-buttons'">
        <form id="userFileForm" method="post" enctype="multipart/form-data">
            <input type="file" name="userBatchAdd">
        </form>
    </div>
    <!-- 定义文件上传对话框底部的按钮 -->
    <div id="userBatchAdd-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="javascript:alert('hahah');" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#userBatchAdd').dialog('close')" style="width:90px">取消</a>
    </div>

</body>
</html>
