package com.gavin.provider.service;


import com.gavin.provider.model.OrderInfo;

import java.util.Map;

public interface WxService {

    String wxPay(OrderInfo orderInfo) throws Exception;
    boolean wxPayNotify(Map<String, String> resultMap) ;
}
