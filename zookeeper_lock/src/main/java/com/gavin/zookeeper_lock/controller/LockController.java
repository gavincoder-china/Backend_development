package com.gavin.zookeeper_lock.controller;


import com.gavin.zookeeper_lock.util.DistributedLockByCurator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-26 10:56
 * @description:
 ************************************************************/
@RestController
@RequestMapping(value = "/zk")
@Slf4j
public class LockController {

    @Autowired
    private DistributedLockByCurator distributedLockByCurator;

    @GetMapping(value = "/lock")
    public String lock() throws InterruptedException {



        distributedLockByCurator.acquireDistributedLock("lock");
       // Thread.sleep(2000);
        distributedLockByCurator.releaseDistributedLock("lock");
        return "success";
    }

    @GetMapping(value = "/test")
    public void testLock(){

        ExecutorService executor = Executors.newCachedThreadPool();
        final int count = 10;
        final CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
           // DistributedLockByCurator distributedLockByCurator = new DistributedLockByCurator();

            executor.submit(() -> {
                try {
                    distributedLockByCurator.acquireDistributedLock("test"); // 阻塞获取锁
                    //让每个线程谁1秒，让更多的线程去尝试竞争锁资源
                    Thread.sleep(3000);


                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                    distributedLockByCurator.releaseDistributedLock("test");
                }

            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();

    }
}
