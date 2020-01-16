package com.supermarket.utils;

import com.supermarket.dto.Pagination;

public class SortNameHandler {
    public static String getEmployeeSortName(Pagination pagination) {
        if ("role".equals(pagination.getSort())) {
            pagination.setSort("roleId");
        } else if ("id".equals(pagination.getSort())) {
            pagination.setSort("employee_id");
        } else if ("name".equals(pagination.getSort())) {
            pagination.setSort("employee_name");
        }
        return pagination.getSort() + " " + pagination.getOrder();
    }
}
