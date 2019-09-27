package com.gavin.provider.config;

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
 * @Date : 2019-09-27 11:59
 * @description:
 ************************************************************/
@Configuration
@MapperScan("com.gavin.provider.mapper")
public class MybatisConfiguration {
}
