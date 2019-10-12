package com.gavin.consumer.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-12 12:23
 * @description:
 ************************************************************/
@Data
public class PageVo implements Serializable {
    private static final long serialVersionUID = -3100127038228210025L;

    private int startPage;

    private int pageSize;


    public int getStart() {

        if (startPage >= 1) {
            return (startPage - 1) * pageSize;
        }

        return 0;
    }
}
