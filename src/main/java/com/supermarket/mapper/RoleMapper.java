package com.supermarket.mapper;

import com.supermarket.bean.Employee;
import com.supermarket.bean.Role;
import com.supermarket.dto.EmployeeQueryDto;
import com.supermarket.dto.NameDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMapper {
//    List<Role> getRoleList(NameDto nameDto);

    List<Role> getRoleList(NameDto nameDto);

    @Select("select id,name from tbl_role")
    List<Role> findAllRole();
    @Insert("insert into tbl_role(name) values(#{name})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    boolean addRole(Role role);
    @Update("update tbl_role set name = #{name} where id = #{id}")
    boolean updateRole(Role role);
    @Delete("delete from tbl_role where id = #{id}")
    boolean deleteRole(Integer id);
    List<Employee> getEmployeeListByRole(EmployeeQueryDto employeeQueryDto);
}
