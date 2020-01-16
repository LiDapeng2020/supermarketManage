package com.supermarket.test;

import com.supermarket.bean.Employee;
import com.supermarket.bean.Role;
import com.supermarket.dto.CheckEmployeeDto;
import com.supermarket.dto.EmployeeQueryDto;
import com.supermarket.mapper.EmployeeMapper;
import com.supermarket.utils.PrintUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext-service.xml")
public class EmployeeMapperTest {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Test
    void testAddEmployee() {
        boolean result = false;
        try {
            result = employeeMapper.addEmployee(new Employee(null, "张三", "zhangsan", "zhangsan", new Date(), 99.8, "15964561231", new Role(2)));
        } catch (Exception e) {

        }
        PrintUtil.greenPrint(result);
    }
    @Test
    void testUpdateEmployee() {
        boolean result = false;
        try {
            result = employeeMapper.updateEmployee(new Employee(5, "张三", "zhangsan1", "zhangsan1", new Date(), 99.8, "15964561231", new Role(2)));
        } catch (Exception e) {

        }
        PrintUtil.greenPrint(result);
    }
    @Test
    void testDeleteEmployee() {
        boolean result = false;
        try {
            result = employeeMapper.deleteEmployee(5);
        } catch (Exception e) {

        }
        PrintUtil.greenPrint(result);
    }
    @Test
    void testFindAllEmployeeByRole() {
        List<Employee> employees = employeeMapper.findAllEmployeeByRole(1);
        PrintUtil.greenPrint(employees);
    }
    @Test
    void testCheckEmployee() {
        Employee employee = employeeMapper.checkEmployee(new CheckEmployeeDto("admin", "admin"));
        PrintUtil.greenPrint(employee);
        Employee employee1 = employeeMapper.checkEmployee(new CheckEmployeeDto("admin1", "admin1"));
        PrintUtil.greenPrint(employee1);
//        Assert.notNull(employee1,"用户名或密码有误");
    }
    @Test
    void testGetEmployeeList() {
        List<Employee> employees = employeeMapper.getEmployeeList(new EmployeeQueryDto("超级管理员1", "admin", null, new Date(), 2500.5, 9999.121,null, 1));
        List<Employee> employees1 = employeeMapper.getEmployeeList(new EmployeeQueryDto(null,null,null,null,null,null,null,null));
        PrintUtil.greenPrint(employees);
        PrintUtil.greenPrint(employees1);
    }
    @Test
    void testFindAllEmployees() {

    }
}
