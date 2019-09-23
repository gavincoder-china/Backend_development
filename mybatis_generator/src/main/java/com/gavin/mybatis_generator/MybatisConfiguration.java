package com.gavin.mybatis_generator;

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
 * @Date : 2019-09-23 10:33
 * @description:
 ************************************************************/
@Configuration
@MapperScan("com.gavin.mybatis_generator.mapper")
public class MybatisConfiguration {
}
