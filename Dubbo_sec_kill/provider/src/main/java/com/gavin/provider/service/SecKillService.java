package com.gavin.provider.service;


import com.gavin.provider.dto.SecSucess;
import com.gavin.provider.dto.SeckillInfo;

import java.util.List;

/**
 * @author gavincoder
 */
public interface SecKillService {

    /**
     * @description  查全部商品(带分页)
     * @author Gavin
     * @date 2019-10-12 13:42

     * @return java.util.List<com.gavin.provider.dto.SeckillInfo>
     * @throws
     * @since
    */
    List<SeckillInfo> selectAll(int start, int offset);

    /**
     * @description  查单个商品的详细信息
     * @author Gavin
     * @date 2019-10-12 13:42

     * @return com.gavin.provider.dto.SeckillInfo
     * @throws
     * @since
    */
    SeckillInfo selectById(Long id);


    /**
     * @return java.lang.String
     * @throws
     * @description 对付款前的用户&库存检测业务进行操作
     * @author Gavin
     * @date 2019-10-11 15:15
     * @since
     */
    String buyProduct(Long pID, Long uID);

    /**
     * @description  支付业务&减库存业务
     * @author Gavin
     * @date 2019-10-12 13:42

     * @return java.lang.String
     * @throws
     * @since
    */
    String payProduct(Long uID);

    /**
     * @description  查商品总条数(分页用)
     * @author Gavin
     * @date 2019-10-12 13:41

     * @return java.lang.Long
     * @throws
     * @since
    */
    Long countAll();

    /**
     * @description  判断用户是否购买过
     * @author Gavin
     * @date 2019-10-14 08:58

     * @return
     * @throws
     * @since
    */

    boolean haveBuy(Long pID,Long uID);

    /**
     * @description  查库存
     * @author Gavin
     * @date 2019-10-14 09:03

     * @return
     * @throws
     * @since
    */

    Long goodsInventory(Long pID);

    /**
     * @description  创建订单
     * @author Gavin
     * @date 2019-10-14 09:04

     * @return
     * @throws
     * @since
    */
    boolean createOrder(Long pID,Long uID);

    /**
     * @description  获取所有商品信息,不带分页,是为了做缓存操作
     * @author Gavin
     * @date 2019-10-14 11:29

     * @return
     * @throws
     * @since
    */
    List<SeckillInfo> selectAll();
}
