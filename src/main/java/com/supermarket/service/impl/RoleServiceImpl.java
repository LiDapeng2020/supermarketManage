package com.supermarket.service.impl;

import com.supermarket.bean.Employee;
import com.supermarket.bean.Role;
import com.supermarket.dto.EmployeeQueryDto;
import com.supermarket.dto.NameDto;
import com.supermarket.mapper.RoleMapper;
import com.supermarket.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> getRoleList(NameDto nameDto) {
        return roleMapper.getRoleList(nameDto);
    }

    @Override
    public List<Role> findAllRole() {
        return roleMapper.findAllRole();
    }

    @Override
    public boolean addRole(Role role) {
        try {
            return roleMapper.addRole(role);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateRole(Role role) {
        try {
            return roleMapper.updateRole(role);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteRole(Integer id) {
        try {
            return roleMapper.deleteRole(id);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Employee> getEmployeeListByRole(EmployeeQueryDto employeeQueryDto) {
        return roleMapper.getEmployeeListByRole(employeeQueryDto);
    }
}
