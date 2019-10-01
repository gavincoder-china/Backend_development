package com.gavin.consumer.vo;

import com.gavin.provider.dto.UserInfo;

import java.io.Serializable;
import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-29 15:27
 * @description:
 ************************************************************/
public class ResultVo  implements Serializable {

    private int tSize;

    List<UserInfo> list;

    public List<UserInfo> getList() {
        return list;
    }

    public void setList(List<UserInfo> list) {
        this.list = list;
    }

    public int gettSize() {
        return tSize;
    }

    public void settSize(int tSize) {
        this.tSize = tSize;
    }


}
