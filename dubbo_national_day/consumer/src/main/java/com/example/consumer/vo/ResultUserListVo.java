package com.example.consumer.vo;

import com.example.provider.dto.User;
import lombok.Data;

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
 * @Date : 2019-10-02 21:13
 * @description:
 ************************************************************/
@Data
public class ResultUserListVo implements Serializable {

    private static final long serialVersionUID = -2477648516891785005L;

    private int totalSize;

    private List<ResultUserVo> list;

}
