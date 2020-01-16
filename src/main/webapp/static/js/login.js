'use strict'
$(function () {
    //登录页面加载完初始化登录信息提示为空格
    let loginError = $("#loginError");
    $("#_easyui_textbox_input1,#_easyui_textbox_input2").focus(function () {
        loginError.html("&nbsp;");
    })
})
function submitForm() {
    let username = $("input[name='username']").val();
    let password = $("input[name='password']").val();
    let loginError = $("#loginError");
    // console.log(username + password);
    //提交表单，并根据返回的结果决定跳转到主页面还是显示错误信息
    $.post(ctp + "/employee/checkEmployee", {username: username,password: password}, function (employee) {
        if (!employee){
            loginError.css("color","red");
            loginError.text("用户名或密码错误，请重新输入");
        }else {
            $(window).attr('location',ctp + '/employee/login');
        }
    });
}

function clearForm() {
    $('#loginForm').form('clear');
}