package com.gavin.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.gavin.provider.service.ProviderService;
import org.springframework.stereotype.Component;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-25 15:23
 * @description:
 ************************************************************/

@Service(interfaceClass = ProviderService.class)
@Component
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String sayHello() {
        return "hello dubbo";
    }
}
