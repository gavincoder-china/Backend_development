package com.gavin.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gavin.consumer.config.annotationCustom.AnnotationCurrentUser;
import com.gavin.consumer.config.annotationCustom.AnnotationLoginRequired;
import com.gavin.consumer.result.ReturnResult;
import com.gavin.consumer.result.ReturnResultUtils;
import com.gavin.consumer.util.ActiveMQUtils;
import com.gavin.consumer.vo.GoodsVo;
import com.gavin.consumer.vo.PageVo;
import com.gavin.consumer.vo.ResultSecGoodsVo;
import com.gavin.consumer.vo.TestVo;
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
        lists.stream().forEach(list -> {
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
     * @description  测试消息队列
     * @author Gavin
     * @date 2019-10-12 17:13

     * @return
     * @throws
     * @since
    */

    @ApiOperation(value = "消息队列")
    @GetMapping(value = "/activeMq")
    public void activeMq() {
        TestVo testVo = new TestVo();
        testVo.setAge(18);
        testVo.setName("cengy");

        activeMQUtils.sendQueueMesage("test", testVo);
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
     * @description 通过用户id查订单(需要登录)
     * @author Gavin
     * @date 2019-10-11 14:39
     * @since
     */


    @ApiOperation(value = "测试静态代码块")
    @GetMapping(value = "/test")
    public int test() {

        return 0;

    }

}
