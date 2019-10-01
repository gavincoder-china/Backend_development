package com.gavin.consumer.vo;

import java.io.Serializable;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-29 12:11
 * @description:
 ************************************************************/

public class PageVo implements Serializable {

    private int pSize;
    private int sPage;
    private int tSize;

    public int gettSize() {
        return tSize;
    }

    public void settSize(int tSize) {
        this.tSize = tSize;
    }

    public int getpSize() {
        return pSize;
    }

    public void setpSize(int pSize) {
        this.pSize = pSize;
    }

    public int getsPage() {

        if (sPage >= 1) {
            sPage = (sPage - 1) * pSize;
        }

        return sPage;
    }

    public void setsPage(int sPage) {
        this.sPage = sPage;
    }

    @Override
    public String toString() {
        return "PageVo{" +
               "pSize=" + pSize +
               ", sPage=" + sPage +
               '}';
    }
}
