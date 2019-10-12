package com.gavin.consumer.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-12 13:21
 * @description:
 ************************************************************/
public class GoodsVo implements Serializable {
    private static final long serialVersionUID = -8418090912655988571L;

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

    private Date startTime;

    private Date endTime;

}
