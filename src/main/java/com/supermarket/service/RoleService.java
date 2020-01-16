package com.supermarket.service;

import com.supermarket.bean.Employee;
import com.supermarket.bean.Role;
import com.supermarket.dto.EmployeeQueryDto;
import com.supermarket.dto.NameDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoleService {
    List<Role> getRoleList(NameDto nameDto);
    List<Role> findAllRole();
    boolean addRole(Role role);
    boolean updateRole(Role role);
    boolean deleteRole(Integer id);
    List<Employee> getEmployeeListByRole(EmployeeQueryDto employeeQueryDto);
}
