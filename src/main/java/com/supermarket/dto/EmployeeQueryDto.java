package com.supermarket.dto;

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
public class EmployeeQueryDto {
    private String name;//员工姓名
    private String username;//用户名
    @DateTimeFormat(pattern = "yyyy-MM-dd")//从前端返回的数据接受格式
    private Date minHiredDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")//从前端返回的数据接受格式
    private Date maxHiredDate;
    @NumberFormat(pattern = "##########.##")
    private Double minSalary;
    @NumberFormat(pattern = "##########.##")
    private Double maxSalary;
    private String phone;
    private Integer roleId;
}
