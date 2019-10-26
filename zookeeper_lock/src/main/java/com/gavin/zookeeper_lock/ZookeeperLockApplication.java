package com.gavin.zookeeper_lock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class ZookeeperLockApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperLockApplication.class, args);
    }

}
