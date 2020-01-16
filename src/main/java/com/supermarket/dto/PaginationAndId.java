package com.supermarket.dto;

import lombok.Data;

@Data
public class PaginationAndId {
    private Integer role_id;
    private Integer page;
    private Integer rows;
    private String sort;
    private String order;
}
