'use strict'
$(function () {
    $.extend($.fn.validatebox.defaults.rules, {
        validatePhone: {
            validator: function (value) {
                let reg = /^1[3,4,5,6,7,8,9][0-9]{9}$/;
                return reg.test(value);
            },
            message: '请输入正确的手机号!'
        }
    });
    $("#table").datagrid({
        singleSelect: true,
        collapsible: true,
        url: 'getRoleList',
        method: 'post',
        rownumbers: true,
        sortName: "id",
        sortOrder: "asc",
        pagination: true,
        pageSize: 2,//初始记录条数
        pageNumber: 1,//初始页码
        pageList: [2, 4, 5, 10],
        fitColumns: true,
        fit: true,
        toolbar: '#toolbar',
        striped: true,
        columns: [[
            {field: 'id', title: '角色编号', width: 80, sortable: true},
            {field: 'name', title: '角色名称', width: 80, sortable: true}
        ]]
    });
    $("#employee-table").edatagrid({
        singleSelect: false,
        collapsible: true,
        onSave: function (index, row) {
            console.log('onSave的index=' + index);
            console.log(row);
            console.log(row.id == null);
            if (row.id == null) {
                $.post({
                    url: '../employee/addEmployee?roleId=' + roleId,
                    data: row,
                    success: function (result) {
                        console.log(result);
                        console.log("result == 'true'");
                        console.log(result == 'true');
                        console.log("result === 'true'");
                        console.log(result === 'true');
                        console.log("result == true");
                        console.log(result == true);
                        console.log("result === true");
                        console.log(result === true);
                        if (result) {
                            $.messager.show({
                                title: '提示信息',
                                msg: '员工添加成功',
                                timeout: 2000
                            });
                            $("#employee-table").edatagrid('reload');
                        } else {
                            $.messager.show({
                                title: '提示信息',
                                msg: '员工添加失败',
                                timeout: 2000
                            });
                        }
                    }
                });
            } else {
                $.post({
                    url: '../employee/updateEmployee',
                    data: {
                        id: row.id,
                        name: row.name,
                        username: row.username,
                        password: row.password,
                        salary: row.salary,
                        hiredDate: row.hiredDate,
                        phone: row.phone,
                        roleId: roleId
                    },
                    success: function (result) {
                        if (result) {
                            $.messager.show({
                                title: '提示信息',
                                msg: '员工信息更改成功',
                                timeout: 2000
                            });
                            $("#employee-table").edatagrid('reload');
                        } else {
                            $.messager.show({
                                title: '提示信息',
                                msg: '员工信息更改失败',
                                timeout: 2000
                            });
                        }
                    }
                });
            }
        },
        onDestroy: function (index, row) {
            console.log('onDestroy的index=' + index);
            console.log(row);
            $.post({
                url: '../employee/deleteEmployee',
                data: {id: row.id},
                success: function (result) {
                    if (result) {
                        $.messager.show({
                            title: '提示信息',
                            msg: '删除员工成功',
                            timeout: 2000
                        });
                    } else {
                        $.messager.show({
                            title: '提示信息',
                            msg: '删除员工成功,但是别人删的',
                            timeout: 2000
                        });
                    }
                    $("#employee-table").edatagrid('reload');
                }
            })
        },
        url: 'getEmployeeListByRole',
        method: 'post',
        rownumbers: true,
        sortName: "id",
        sortOrder: "asc",
        pagination: true,
        pageSize: 2,//初始记录条数
        pageNumber: 1,//初始页码
        pageList: [2, 4, 5, 10],
        fitColumns: false,
        fit: true,
        toolbar: '#employee-toolbar',
        striped: true,
        columns: [[
            {field: 'id', title: '员工编号', width: 120, sortable: true},
            {
                field: 'name', title: '姓名', width: 120, sortable: true, editor: {
                    type: "textbox", options: {
                        required: true
                    }
                }
            },
            {
                field: 'username', title: '用户名', width: 120, sortable: true, editor: {
                    type: "textbox", options: {
                        required: true
                    }
                }
            },
            {
                field: 'password', title: '密码', width: 120, sortable: true, editor: {
                    type: "passwordbox", options: {
                        required: true
                    }
                }
            },
            {
                field: 'hiredDate', title: '入职日期', width: 120, sortable: true, editor: {
                    type: "datebox", options: {
                        required: true
                    }
                }
            },
            {
                field: 'salary', title: '工资', width: 120, sortable: true, editor: {
                    type: 'numberbox', options: {
                        min: 0.00, precision: 2, required: true
                    }
                }
            },
            {
                field: 'phone', title: '手机号', width: 120, sortable: true, editor: {
                    type: "validatebox", options: {
                        validType: 'validatePhone',
                        required: true
                    }
                }
            }
        ]]
    });
    $('#employee-table').edatagrid({
        destroyMsg: {
            norecord: {	// when no record is selected
                title: '警告框',
                msg: '你不选，我知道你删谁啊'
            },
            confirm: {	// when select a row
                title: '确认狂',
                msg: '你确定要删除?'
            }
        }
    });

});

function otherQuery() {
    let name = $('#queryName').val();
    $('#table').datagrid({
        //添加额外参数
        queryParams: {
            "name": name
        }
    });
}

let url;

function toAddRole() {
    $("#dlg").dialog("open");
    $("#fm").form("clear");
    $("#dlg").dialog("setTitle", "添加角色信息");
    url = "addRole";
}

function saveOrUpdateRole() {
    $("#fm").form("submit", {
        url: url,
        success: function (result) {
            // $.messager.alert("提示",result);
            /*console.log("result == 'true'");
            console.log(result == 'true');

            console.log("result === 'true'");
            console.log(result === 'true');*/

            if (result == 'true') {
                $("#dlg").dialog("close");
                $.messager.show({
                    title: '提示信息',
                    msg: '操作成功',
                    showType: 'show',
                    timeout: 2000
                });
                $("#table").datagrid("reload");
            } else {
                $.messager.show({
                    title: '提示信息',
                    msg: '操作失败,角色名称重复了',
                    showType: 'show',
                    timeout: 2000
                });
            }
        }
    });

}

function toUpdateRole() {
    let row = $("#table").datagrid("getSelected");
    console.log(row);
    if (row) {
        $("#dlg").dialog("open");
        $("#fm").form("load", row);
        $("#dlg").dialog("setTitle", "修改角色信息");
        url = "updateRole?id=" + row.id;
    } else {
        $.messager.show({
            title: '提示信息',
            msg: '你不选中，我知道你修改谁啊',
            showType: 'show',
            timeout: 3000
        });
    }
}

function deleteRole() {
    let row = $("#table").datagrid("getSelected");
    if (row) {
        $.messager.confirm('确认删除', '您确认删除么', function (flag) {
            if (flag) {
                $.ajax({
                    url: "deleteRole",
                    data: {id: row.id},
                    success: function (result) {
                        if (result == 'true') {
                            $.messager.show({
                                title: '提示信息',
                                msg: '删除成功',
                                showType: 'show',
                                timeout: 2000
                            });
                        } else {
                            $.messager.show({
                                title: '提示信息',
                                msg: '你手慢了，该数据已被其他人删除',
                                showType: 'show',
                                timeout: 2000
                            });
                        }
                        $("#table").datagrid("reload");
                    }
                })
            }
        })
    } else {
        $.messager.show({
            title: '提示信息',
            msg: '你不选中，我知道你删谁啊',
            showType: 'show',
            timeout: 3000
        });
    }
}

function toBatchAddRole() {
    $("#batchAddRole").dialog("open");
    $("#RoleFileForm").form("clear");
    $("#batchAddRole").dialog("setTitle", "批量添加员工");
}

let roleId, roleName;

function getEmployeeListByRole() {
    let row = $("#table").datagrid("getSelected");
    if (row == null) {
        $.messager.show({
            title: '提示信息',
            msg: '你不选中，我知道你查看啥啊',
            showType: 'show',
            timeout: 2000
        });
        return;
    }
    /*console.log(row);
    console.log(row.id);*/
    roleId = row.id;
    roleName = row.name;
    $("#employee-table").edatagrid({
        queryParams: {
            roleId:roleId,
        }
    });
    $("#employee-dialog").dialog("open");
}

function otherQueryEmployee() {
    let name = $('#queryEmployeeName').val();
    let username = $('#queryUserName').val();
    let minHiredDate = $('#queryMinHiredDate').val();
    let maxHiredDate = $('#queryMaxHiredDate').val();
    let minSalary = $('#queryMinSalary').val();
    let maxSalary = $('#queryMaxSalary').val();
    let phone = $('#queryPhone').val();
    $('#employee-table').datagrid({
        //添加额外参数
        queryParams: {
            "name": name,
            "username": username,
            "minHiredDate": minHiredDate,
            "maxHiredDate": maxHiredDate,
            "minSalary": minSalary,
            "maxSalary": maxSalary,
            "roleId": roleId,
            "phone": phone
        }
    });
}