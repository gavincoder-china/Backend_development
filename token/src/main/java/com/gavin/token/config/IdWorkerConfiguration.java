package com.gavin.token.config;

import com.gavin.token.util.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-04 21:16
 * @description:
 ************************************************************/
@Configuration
public class IdWorkerConfiguration {

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
