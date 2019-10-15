package com.gavin.provider.util;

import java.util.UUID;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-15 10:23
 * @description:
 ************************************************************/
public class CommonUtil {

    public static String CreateUUID(int size) {

        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, size);
    }
}
