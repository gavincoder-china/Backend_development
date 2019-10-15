package com.gavin.consumer.controller;


import com.gavin.consumer.queue.activeMQ.ActiveMQUtils;
import com.gavin.consumer.vo.TestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-10 11:41
 * @description:
 ************************************************************/
@Api(tags = "测试")
@RestController
@RequestMapping(value = "/v1")
public class TestController {

    @Autowired
    private ActiveMQUtils activeMQUtils;



}
