package com.supermarket.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;//员工编号
    private String name;//员工姓名
    private String username;//用户名
    private String password;//密码
    @DateTimeFormat(pattern = "yyyy-MM-dd")//从前端返回的数据接受格式
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")//后端向前端以json格式发送
    private Date hiredDate;//入职时间
    @NumberFormat(pattern = "##########.##")
    private Double salary;//工资
    private String phone;//手机号
    private Role role;
    public Employee(Integer id) {
        this.id = id;
    }
}