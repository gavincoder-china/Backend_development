package com.gavin.consumer.data;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gavin.consumer.contants.ReturnResultContants;
import com.gavin.consumer.util.RedisUtil;
import com.gavin.provider.dto.SeckillInfo;
import com.gavin.provider.service.SecKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-14 11:10
 * @description:
 ************************************************************/
@Component
public class DataToCache {

    @Reference
    private SecKillService secKillService;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * @return
     * @throws
     * @description 在服务启动时查询数据库数据将库存信息存到缓存中
     * @author Gavin
     * @date 2019-10-14 11:12
     * @since
     */

    @PostConstruct
    public void getGoodsToRedis() {

        List<SeckillInfo> lists = secKillService.selectAll();

        lists.stream().forEach(list -> {
            //存入redis
            redisUtil.set(ReturnResultContants.HOT_CACHE + list.getId(), list.getInventory());
        });


    }



}
