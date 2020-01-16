package com.supermarket.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.supermarket.bean.Employee;
import com.supermarket.bean.Role;
import com.supermarket.dto.*;
import com.supermarket.service.RoleService;
import com.supermarket.utils.ComboboxUtil;
import com.supermarket.utils.SessionUtil;
import com.supermarket.utils.SortNameHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    //根据权限，判断能否跳转到角色管理页面
    @RequestMapping("/roleList")
    String roleList(HttpSession session) {
        Integer roleId = SessionUtil.getEmployeeRoleId(session);
        if (1 == roleId) {
            return "baseInfo/roleList";
        }else {
            return SessionUtil.noAuthorization();
        }
    }
    //返回角色信息的数据
    @RequestMapping("getRoleList")
    @ResponseBody
    DataPage<Role> getRoleList(Pagination pagination, NameDto nameDto) {
        Page<Object> page = PageHelper.startPage(pagination.getPage(), pagination.getRows(), pagination.getSort() + " " + pagination.getOrder());
        List<Role> roles = roleService.getRoleList(nameDto);
        return new DataPage<>((int)page.getTotal(),roles);
    }
    //返回角色下拉框数据
    @RequestMapping("findAllRole")
    @ResponseBody
    List<ComboboxData> findAllRole() {
        List<Role> roles = roleService.findAllRole();
        return ComboboxUtil.getComboboxDataList(roles);
    }
    //返回角色添加是否成功
    @RequestMapping("/addRole")
    @ResponseBody
    boolean addRole(Role role){
        return roleService.addRole(role);
    }
    //返回角色修改是否成功
    @RequestMapping("/updateRole")
    @ResponseBody
    boolean updateRole(Role role){
        return roleService.updateRole(role);
    }
    //返回角色删除是否成功
    @RequestMapping("/deleteRole")
    @ResponseBody
    boolean deleteRole(Integer id){
        return roleService.deleteRole(id);
    }

    //返回根据角色获得的员工列表数据
    @RequestMapping("/getEmployeeListByRole")
    @ResponseBody
    DataPage<Employee> getEmployeeListByRole(Pagination pagination,EmployeeQueryDto employeeQueryDto,Integer roleId) {
        Page<Object> page = PageHelper.startPage(pagination.getPage(), pagination.getRows(), SortNameHandler.getEmployeeSortName(pagination));
        List<Employee> employees = roleService.getEmployeeListByRole(employeeQueryDto);
        return new DataPage<>((int)page.getTotal(),employees);
    }
}