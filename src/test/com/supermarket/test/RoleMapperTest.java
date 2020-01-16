package com.supermarket.test;

import com.supermarket.bean.Employee;
import com.supermarket.bean.Role;
import com.supermarket.dto.ComboboxData;
import com.supermarket.dto.NameDto;
import com.supermarket.mapper.RoleMapper;
import com.supermarket.utils.ComboboxUtil;
import com.supermarket.utils.PrintUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext-service.xml")
public class RoleMapperTest {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    void testGetRoleList() {
        List<Role> roles1 = roleMapper.getRoleList(new NameDto("超级管理员"));
        List<Role> roles2 = roleMapper.getRoleList(new NameDto());
        PrintUtil.greenPrint(roles1);
        PrintUtil.greenPrint(roles2);
    }

    @Test
    void testFindAllRole() {
        List<Role> roles = roleMapper.findAllRole();
        PrintUtil.greenPrint(roles);
        List<ComboboxData> comboboxDataList = ComboboxUtil.getComboboxDataList(roles);
        PrintUtil.printSplitLine();
        PrintUtil.greenPrint(comboboxDataList);
    }

    @Test
    void testAddRole() {
        boolean result = false;
        try {
            result = roleMapper.addRole(new Role(null, "服务台", null));
        } catch (Exception e) {

        }
        PrintUtil.greenPrint(result);
    }
    @Test
    void testUpdateRole() {
        boolean result = false;
        try {
            result = roleMapper.updateRole(new Role(4, "服务台人员", null));
        } catch (Exception e) {

        }
        PrintUtil.greenPrint(result);
    }
    @Test
    void testDeleteRole() {
        boolean result = false;
        try {
            result = roleMapper.deleteRole(4);
        } catch (Exception e) {

        }
        PrintUtil.greenPrint(result);
    }
    @Test
    void testGetEmployeeListByRole(){
        List<Employee> employees = roleMapper.getEmployeeListByRole(null);
        PrintUtil.greenPrint(employees);
    }
}
