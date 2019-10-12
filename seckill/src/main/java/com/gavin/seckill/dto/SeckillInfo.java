package com.gavin.seckill.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class SeckillInfo implements Serializable {
    private Long id;

    private String title;

    /**
    * 折扣率
    */
    private Double discountRatio;

    /**
    * 折扣价
    */
    private BigDecimal discount;

    /**
    * 销量
    */
    private Long sales;

    /**
    * 库存
    */
    private Long inventory;

    /**
    * 原价
    */
    private BigDecimal originalPrice;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}