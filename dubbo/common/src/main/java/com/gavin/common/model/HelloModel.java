package com.gavin.common.model;

import java.io.Serializable;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-26 14:22
 * @description:
 ************************************************************/
public class HelloModel implements Serializable {
    private static final long serialVersionUID = 1392165405018286312L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
