package com.gavin.provider.service;


import com.gavin.provider.model.OrderInfo;

public interface WxService {

    String wxPay(OrderInfo orderInfo) throws Exception;
}
