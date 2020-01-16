package com.supermarket.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer id;//角色编号
    private String name;//角色名称
    private List<Employee> employees;

    public Role(Integer id) {
        this.id = id;
    }
}
