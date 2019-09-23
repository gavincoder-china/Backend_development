package com.example.swagger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-23 15:53
 * @description:
 ************************************************************/
@Configuration
@MapperScan("com.example.swagger.mapper")
public class MybatisConfiguration {

}
