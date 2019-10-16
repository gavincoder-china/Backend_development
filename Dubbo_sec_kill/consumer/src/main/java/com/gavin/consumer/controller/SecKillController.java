package com.gavin.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gavin.consumer.config.annotationCustom.AnnotationCurrentUser;
import com.gavin.consumer.config.annotationCustom.AnnotationLoginRequired;
import com.gavin.consumer.contants.ReturnResultContants;
import com.gavin.consumer.queue.activeMQ.ActiveMQUtils;
import com.gavin.consumer.result.ReturnResult;
import com.gavin.consumer.result.ReturnResultUtils;
import com.gavin.consumer.util.RedisUtil;
import com.gavin.consumer.vo.GoodsVo;
import com.gavin.consumer.vo.PageVo;
import com.gavin.consumer.vo.ResultSecGoodsVo;
import com.gavin.provider.contants.SecKillContants;
import com.gavin.provider.dto.Oauth;
import com.gavin.provider.dto.SeckillInfo;
import com.gavin.provider.service.SecKillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-11 14:26
 * @description:
 ************************************************************/
@Api(tags = "购物")
@RestController
@RequestMapping(value = "/shop")
public class SecKillController {
    @Reference
    private SecKillService secKillService;
    @Autowired
    private ActiveMQUtils activeMQUtils;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * @return
     * @throws
     * @description 展示全部商品
     * @author Gavin
     * @date 2019-10-11 14:27
     * @since
     */
    @ApiOperation(value = "展示所有商品")
    @GetMapping("/showAllProducts")
    public ReturnResult showAllProducts(@Valid PageVo pageVo) {

        List<SeckillInfo> lists = secKillService.selectAll(pageVo.getStart(), pageVo.getPageSize());

        ArrayList<GoodsVo> listTemp = new ArrayList<>();
        lists.forEach(list -> {
            GoodsVo goodsVo = new GoodsVo();
            BeanUtils.copyProperties(list, goodsVo);
            listTemp.add(goodsVo);
        });

        ResultSecGoodsVo resultSecGoodsVo = new ResultSecGoodsVo();
        resultSecGoodsVo.setList(listTemp);
        resultSecGoodsVo.setStartPage(pageVo.getStartPage());
        resultSecGoodsVo.setPageSize(pageVo.getPageSize());
        resultSecGoodsVo.setTotalSize(secKillService.countAll());

        return ReturnResultUtils.returnSuccess(resultSecGoodsVo);
    }


    /**
     * @return
     * @throws
     * @description 通过id查某一个商品
     * @author Gavin
     * @date 2019-10-11 14:27
     * @since
     */
    @ApiOperation(value = "查询单个商品的详细信息")
    @GetMapping("/showOneProduct")
    public ReturnResult showOneProduct(@ApiParam(value = "商品id", required = true)
                                       @RequestParam(value = "pID") Long pID) {

        GoodsVo goodsVo = new GoodsVo();
        //转换成vo
        BeanUtils.copyProperties(secKillService.selectById(pID), goodsVo);

        return ReturnResultUtils.returnSuccess(goodsVo);
    }


    /**
     * @return
     * @throws
     * @description 通过商品id购买, 从redis中拿取用户的id(需要登录)
     * @author Gavin
     * @date 2019-10-11 14:28
     * @since
     */

    @AnnotationLoginRequired
    @ApiOperation(value = "进入支付检验流程")
    @GetMapping("/buyProduct")
    public ReturnResult buyProduct(@ApiParam(value = "商品id", required = true)
                                   @RequestParam(value = "pID") Long pID, @AnnotationCurrentUser Oauth oauth) {

        String result = secKillService.buyProduct(pID, oauth.getId());

        if (null == result) {
            //返回无信息,直接返回,抢购失败,请重新尝试
            return ReturnResultUtils.returnFail(SecKillContants.MSG_SEC_FAIL, SecKillContants.SEC_FAIL);
        }
        return ReturnResultUtils.returnFail(SecKillContants.MSG_SECL, result);
    }


    /**
     * @return
     * @throws
     * @description 付款(需要登录)
     * @author Gavin
     * @date 2019-10-11 14:28
     * @since
     */

    @AnnotationLoginRequired
    @ApiOperation(value = "付款")
    @GetMapping("/pay")
    public ReturnResult pay(@AnnotationCurrentUser Oauth oauth) {

        String result = secKillService.payProduct(oauth.getId());
        return ReturnResultUtils.returnSuccess(result);
    }


    /**
     * @return
     * @throws
     * @description 通过商品id购买, 从redis中拿取用户的id(需要登录)  这边做消息队列操作,返回数据给支付逻辑
     * @author Gavin
     * @date 2019-10-11 14:28
     * @since
     */

    @AnnotationLoginRequired
    @ApiOperation(value = "选择商品,使用消息队列完成订单生成操作")
    @GetMapping("/buyProductByQueue")
    public ReturnResult buyProductByQueue(@ApiParam(value = "商品id", required = true)
                                          @RequestParam(value = "pID") Long pID, @AnnotationCurrentUser Oauth oauth) {

        //加锁,检验锁
        boolean lockResult = redisUtil.lock(ReturnResultContants.HOT_LOCK + pID, 1, 600);

        while (lockResult) {
            //查用户是否购买过?
            boolean haveBuy = secKillService.haveBuy(pID, oauth.getId());

            if (!haveBuy) {

                //查该商品库存
                Long inventory = secKillService.goodsInventory(pID);

                if (inventory >= 1) {

                    //发送信息到消息队列,让生成订单的方法消费
                    activeMQUtils.sendQueueMesage("seckill", pID + "@" + oauth.getId());

                    return ReturnResultUtils.returnSuccess(ReturnResultContants.CODE_SECKILL_CREATE_ORDER, ReturnResultContants.MSG_SECKILL_CREATE_ORDER);

                }
            }
            //如果进来后不满足需求,则解锁
            redisUtil.delLock(ReturnResultContants.HOT_LOCK + pID);
        }

        return ReturnResultUtils.returnFail(SecKillContants.MSG_SEC_FAIL, SecKillContants.SEC_FAIL);

    }


}
