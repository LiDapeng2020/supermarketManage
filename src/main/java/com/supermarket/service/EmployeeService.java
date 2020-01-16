package com.supermarket.service;

import com.supermarket.bean.Employee;
import com.supermarket.dto.CheckEmployeeDto;
import com.supermarket.dto.EmployeeQueryDto;

import java.util.List;

public interface EmployeeService {
    Employee checkEmployee(CheckEmployeeDto checkEmployeeDto);

    List<Employee> getEmployeeList(EmployeeQueryDto employeeQueryDto);

    boolean addEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(Integer id);
}
