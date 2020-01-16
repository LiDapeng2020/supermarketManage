'use strict'
$(function () {
    $("#table").datagrid({
        singleSelect:true,
        collapsible:true,
        url:'getEmployeeList',
        method:'post',
        rownumbers:true,
        sortName:"id",
        sortOrder:"asc",
        pagination:true,
        pageSize: 2,//初始记录条数
        pageNumber:1,//初始页码
        pageList:[2,4,5,10],
        fitColumns:true,
        fit:true,
        toolbar:'#toolbar',
        striped:true,
        columns:[[
            {field:'id',title:'员工编号',width:80,sortable:true},
            {field:'name',title:'姓名',width:80,sortable:true},
            {field:'username',title:'用户名',width:80,sortable:true},
            {field:'password',title:'密码',width:80,sortable:true},
            {field:'hiredDate',title:'入职日期',width:80,sortable:true},
            {field:'salary',title:'工资',width:80,sortable:true},
            {field:'role',title:'角色名称',width:80,sortable:true,
                formatter : function(role){
                    if (role!=null)
                        return role.name;
                    else
                        return "";
                }
            },
            {field:'phone',title:'手机号',width:80,sortable:true}
        ]]
    });

    $.extend($.fn.validatebox.defaults.rules, {
        phone: {
            validator: function(value){
                let reg = /^1[3,4,5,6,7,8,9][0-9]{9}$/;
                return reg.test(value);
            },
            message: '请输入正确的手机号!'
        }
    });
});
function otherQuery() {
    let name = $('#queryName').val();
    let username = $('#queryUserName').val();
    let minHiredDate = $('#queryMinHiredDate').val();
    let maxHiredDate = $('#queryMaxHiredDate').val();
    let minSalary = $('#queryMinSalary').val();
    let maxSalary = $('#queryMaxSalary').val();
    let roleId = $('#queryRoleId').val();
    let phone = $('#queryPhone').val();
    /*console.log('name:' + name);
    console.log('username:' + username);
    console.log('minHiredDate:' + minHiredDateString);
    console.log('maxHiredDate:' + maxHiredDateString);
    console.log('minSalary:' + minSalary);
    console.log('maxSalary:' + maxSalary);
    console.log('roleId:' + roleId);
    console.log('phone:' + phone);*/
    $('#table').datagrid({
        //添加额外参数
        queryParams: {
            "name":name,
            "username":username,
            "minHiredDate":minHiredDate,
            "maxHiredDate":maxHiredDate,
            "minSalary":minSalary,
            "maxSalary":maxSalary,
            "roleId":roleId,
            "phone":phone
        }
    });
}
let url;
function toAddEmployee() {
    $("#dlg").dialog("open");
    $("#fm").form("clear");
    $("#dlg").dialog("setTitle", "添加员工信息");
    url = "addEmployee";
}
function saveOrUpdateEmployee() {
    $("#fm").form("submit",{
        url:url,
        success:function (result) {
            // $.messager.alert("提示",result);
            /*console.log("result == 'true'");
            console.log(result == 'true');

            console.log("result === 'true'");
            console.log(result === 'true');*/

            if (result == 'true'){
                $("#dlg").dialog("close");
                $.messager.show({
                    title:'提示信息',
                    msg:'操作成功',
                    showType:'show',
                    timeout:2000
                });
                $("#table").datagrid("reload");
            }else {
                $.messager.show({
                    title:'提示信息',
                    msg:'操作失败,用户名重复了',
                    showType:'show',
                    timeout:2000
                });
            }
        }
    });

}
function toUpdateEmployee() {
    let row= $("#table").datagrid("getSelected");
    console.log(row);
    if (row){
        let role = row.role;
        let roleId,roleName;
        if (role == null){
            roleId = 0;
            roleName = "";
        }else {
            roleId = role.id;
            roleName = role.name;
        }
        $("input[name='roleId']").val(roleId);
        $("#_easyui_textbox_input8").attr("disabled", "disabled");
        $("#_easyui_textbox_input8").val(roleName);
        $("#dlg").dialog("open");
        $("#fm").form("load", row);
        console.log(row);
        console.log(roleId);
        $("#dlg").dialog("setTitle","修改员工信息");
        url = "updateEmployee?id=" + row.id;
    }else {
        $.messager.show({
            title:'提示信息',
            msg:'你不选中，我知道你修改谁啊',
            showType:'show',
            timeout:3000
        });
    }
}
function deleteEmployee(){
    let row = $("#table").datagrid("getSelected");
    if (row){
        $.messager.confirm('确认删除','您确认删除么',function (flag) {
            if (flag){
                $.ajax({
                    url:"deleteEmployee",
                    data:{id:row.id},
                    success:function (result) {
                        if (result == 'true'){
                            $.messager.show({
                                title:'提示信息',
                                msg:'删除成功',
                                showType:'show',
                                timeout:2000
                            });
                        }else {
                            $.messager.show({
                                title:'提示信息',
                                msg:'你手慢了，该数据已被其他人删除',
                                showType:'show',
                                timeout:2000
                            });
                        }
                        $("#table").datagrid("reload");
                    }
                })
            }
        })
    }else {
        $.messager.show({
            title:'提示信息',
            msg:'你不选中，我知道你删谁啊',
            showType:'show',
            timeout:3000
        });
    }
}
function toBatchAddEmployee() {
    $("#userBatchAdd").dialog("open");
    $("#userFileForm").form("clear");
    $("#userBatchAdd").dialog("setTitle", "批量添加员工");
    // url = "batchAddEmployee";
}