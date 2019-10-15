package com.gavin.provider.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-15 14:00
 * @description:
 ************************************************************/
@Component
@Data
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 7284808068781665135L;

    private String id;
    private String body;
    private int price;
}
