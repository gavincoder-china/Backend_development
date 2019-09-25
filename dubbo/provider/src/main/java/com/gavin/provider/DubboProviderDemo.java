package com.gavin.provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.concurrent.CountDownLatch;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-25 11:10
 * @description:
 ************************************************************/
@EnableCaching
@SpringBootApplication
@EnableDubboConfiguration
public class DubboProviderDemo {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(DubboProviderDemo.class, args).registerShutdownHook();
        countDownLatch.await();;
    }
}
