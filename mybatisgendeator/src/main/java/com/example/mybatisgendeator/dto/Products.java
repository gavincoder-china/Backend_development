package com.example.mybatisgendeator.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Products {
    private Integer pid;

    private String pname;

    private BigDecimal price;

    private String description;
}