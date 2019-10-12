package com.gavin.seckill.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class SecSucess implements Serializable {
    private Long id;

    private Integer userId;

    private Integer proId;

    private Byte state;

    private BigDecimal pay;

    private Date createTime;

    private String payPlatform;

    private static final long serialVersionUID = 1L;
}