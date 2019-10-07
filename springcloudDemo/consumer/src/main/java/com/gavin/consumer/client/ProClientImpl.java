package com.gavin.consumer.client;

import org.springframework.stereotype.Component;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-07 09:58
 * @description:
 ************************************************************/
@Component
public class ProClientImpl implements ProClient {
    @Override
    public String hello() {
        return "熔断成功";
    }
}
