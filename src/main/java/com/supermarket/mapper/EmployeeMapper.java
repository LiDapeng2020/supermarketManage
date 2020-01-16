package com.supermarket.mapper;

import com.supermarket.bean.Employee;
import com.supermarket.dto.CheckEmployeeDto;
import com.supermarket.dto.EmployeeQueryDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EmployeeMapper {
    Employee checkEmployee(CheckEmployeeDto checkEmployeeDto);
    List<Employee> getEmployeeList(EmployeeQueryDto employeeQueryDto);
   @Insert("insert into tbl_employee(name,username,password,hiredDate,salary,phone,roleId) " +
            "values(#{name},#{username},#{password},#{hiredDate},#{salary},#{phone},#{role.id})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    boolean addEmployee(Employee employee);
    @Update("update tbl_employee set name=#{name},username=#{username},password=#{password}," +
            "hiredDate=#{hiredDate},salary=#{salary},phone=#{phone},roleId=#{role.id} " +
            "where id =#{id}")
    boolean updateEmployee(Employee employee);
    @Delete("delete from tbl_employee where id =#{id}")
    boolean deleteEmployee(Integer id);
    @Select("select id,name,username from tbl_employee where roleId = #{id}")
    List<Employee> findAllEmployeeByRole(Integer id);
}
