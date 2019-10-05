package com.gavin.consumer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value = "provider")
public interface ProClient {


    @GetMapping(value = "/pro/hello")
    public String hello();



}
