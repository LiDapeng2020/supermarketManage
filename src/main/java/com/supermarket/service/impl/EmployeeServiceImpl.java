package com.supermarket.service.impl;

import com.supermarket.bean.Employee;
import com.supermarket.dto.CheckEmployeeDto;
import com.supermarket.dto.EmployeeQueryDto;
import com.supermarket.mapper.EmployeeMapper;
import com.supermarket.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public Employee checkEmployee(CheckEmployeeDto checkEmployeeDto) {
        return employeeMapper.checkEmployee(checkEmployeeDto);
    }

    @Override
    public List<Employee> getEmployeeList(EmployeeQueryDto employeeQueryDto) {
        return employeeMapper.getEmployeeList(employeeQueryDto);
    }

    @Override
    public boolean addEmployee(Employee employee) {
        try {
            return employeeMapper.addEmployee(employee);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        try {
            return employeeMapper.updateEmployee(employee);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(Integer id) {
        try {
            return employeeMapper.deleteEmployee(id);
        } catch (Exception e) {
            return false;
        }
    }
}
