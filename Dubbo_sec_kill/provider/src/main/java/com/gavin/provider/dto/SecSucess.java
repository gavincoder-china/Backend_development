package com.gavin.provider.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class SecSucess implements Serializable {
    private Long id;

    private Long userId;

    private Long proId;

    /**
     * 支付状态  0取消  1待支付  2付款成功 3付款失败
     */
    private Byte state;

    private BigDecimal pay;

    private Date createTime;

    private String payPlatform;

    private static final long serialVersionUID = 1L;
}