package com.supermarket.utils;

import com.supermarket.bean.Employee;

import javax.servlet.http.HttpSession;

public class SessionUtil {
    public static Integer getEmployeeRoleId(HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        return employee.getRole().getId();
    }
    public static String noAuthorization() {
        return "page/noAuthorization";
    }
}
