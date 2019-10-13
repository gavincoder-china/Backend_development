package com.gavin.provider.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.gavin.provider.contants.RedisUserContants;
import com.gavin.provider.contants.SecKillContants;
import com.gavin.provider.dto.SecSucess;
import com.gavin.provider.dto.SeckillInfo;
import com.gavin.provider.mapper.SecSucessMapper;
import com.gavin.provider.mapper.SeckillInfoMapper;
import com.gavin.provider.service.SecKillService;
import com.gavin.provider.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-11 14:41
 * @description:
 ************************************************************/
@Service
@Transactional
public class SecKillServiceImpl implements SecKillService {

    @Autowired
    private SeckillInfoMapper seckillInfoMapper;
    @Autowired
    private SecSucessMapper secSucessMapper;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public List<SeckillInfo> selectAll(int start, int offset) {

        return seckillInfoMapper.selectAll(start, offset);
    }

    @Override
    public SeckillInfo selectById(Long id) {

        return seckillInfoMapper.selectById(id);
    }

    @Override
    public String buyProduct(Long pID, Long uID) {

        //判断用户是否买过,查redis
        if (redisUtils.hasKey(RedisUserContants.SECKILL_IS + pID + uID)) {

            return SecKillContants.HAVE_BUY;
        } else {

            //判断库存,如果库存小于1,就告诉用户库存不足
            if (seckillInfoMapper.selectInventoryById(pID) < 1) {

                return SecKillContants.NO_GOODS;
            } else {
                //库存充足
                //生成订单,支付成功后再把订单表的状态修改为支付成功
                SecSucess secSucess = new SecSucess();

                secSucess.setCreateTime(new Date());
                secSucess.setProId(pID);
                secSucess.setUserId(uID);
                secSucess.setState(SecKillContants.STATE_TO_PAY);

                //成功创建支付表
                int result = secSucessMapper.insertSelective(secSucess);
                if (result == 1) {
                    return SecKillContants.PAY;
                }
            }
        }
        return null;
    }


    @Override
    public String payProduct(Long uID) {

        //修改sec_success表的支付状态
        Long id = secSucessMapper.selectidByUserIdAndState(uID, SecKillContants.STATE_TO_PAY);

        //支付操作
        int result = secSucessMapper.updateStatebyid(SecKillContants.STATE_HAVE_PAY, id);

        if (result == 1) {
            //支付成功,减库存,把用户存到redis中
            //去秒杀订单表中取一下pid
            Long pID = secSucessMapper.selectProIdById(id);
            //减库存
            seckillInfoMapper.updateInventoryById(pID);

            //Todo  用redis做库存热点数据缓存
            redisUtils.set(RedisUserContants.SECKILL_IS + pID + uID, 1,300);

            return SecKillContants.PAY_SUCCESS;
        }
        return SecKillContants.PAY_FAILURE;
    }


    @Override
    public Long countAll() {

        return seckillInfoMapper.countAll();
    }

}
