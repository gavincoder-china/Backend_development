package com.gavin.consumer.util;


import org.junit.Test;

import java.util.UUID;


public class CommonUtilTest {


    @Test
    public void createUUID() {
        System.out.println(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32));

    }
}
