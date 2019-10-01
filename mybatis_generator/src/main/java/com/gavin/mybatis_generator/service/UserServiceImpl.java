package com.gavin.mybatis_generator.service;

import com.gavin.mybatis_generator.dto.Products;
import com.gavin.mybatis_generator.dto.ProductsExample;
import com.gavin.mybatis_generator.mapper.ProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-23 10:45
 * @description:
 ************************************************************/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ProductsMapper productsMapper;


    public void select(){

        ProductsExample example = new ProductsExample();

        example.createCriteria().andPidEqualTo(1);

        List<Products> products = productsMapper.selectByExample(example);

        System.out.println(products);



    }

}
