package com.supermarket.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.supermarket.bean.Employee;
import com.supermarket.bean.Role;
import com.supermarket.dto.CheckEmployeeDto;
import com.supermarket.dto.DataPage;
import com.supermarket.dto.EmployeeQueryDto;
import com.supermarket.dto.Pagination;
import com.supermarket.service.EmployeeService;
import com.supermarket.utils.SessionUtil;
import com.supermarket.utils.SortNameHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/checkEmployee")
    @ResponseBody
    //查找是否存在符合条件的员工，符合就将员工信息放入到session中。最后返回
    Employee checkEmployee(CheckEmployeeDto checkEmployeeDto, HttpSession session){
        Employee result = employeeService.checkEmployee(checkEmployeeDto);
        if (result!=null){
            session.setAttribute("employee",result);
        }
        return result;
    }
    //跳转到系统主页面
    @RequestMapping("/login")
    public String login() {
        return "page/index";
    }
    //根据权限，决定能否可以跳转到员工管理页面
    @RequestMapping("/employeeList")
    String employeeList(HttpSession session) {
        Integer roleId = SessionUtil.getEmployeeRoleId(session);
        if (1 == roleId) {
            return "baseInfo/employeeList";
        }else {
            return SessionUtil.noAuthorization();
        }
    }
    //返回员工管理页面上的员工信息数据
    @RequestMapping("/getEmployeeList")
    @ResponseBody
    DataPage<Employee> getEmployeeList(Pagination pagination,EmployeeQueryDto employeeQueryDto) {
        Page<Object> page = PageHelper.startPage(pagination.getPage(), pagination.getRows(), SortNameHandler.getEmployeeSortName(pagination));
        List<Employee> employees = employeeService.getEmployeeList(employeeQueryDto);
        return  new DataPage<>((int) page.getTotal(),employees);
    }

    //返回添加员工是否成功
    @RequestMapping("/addEmployee")
    @ResponseBody
    boolean addEmployee(Employee employee,Integer roleId) {
        employee.setRole(new Role(roleId));
        return employeeService.addEmployee(employee);
    }
    //返回修改员工是否成功
    @RequestMapping("/updateEmployee")
    @ResponseBody
    boolean updateEmployee(Employee employee,Integer roleId) {
        employee.setRole(new Role(roleId));
        return employeeService.updateEmployee(employee);
    }
    //返回删除员工是否成功
    @RequestMapping("/deleteEmployee")
    @ResponseBody
    boolean deleteEmployee(Integer id) {
        return employeeService.deleteEmployee(id);
    }
}
