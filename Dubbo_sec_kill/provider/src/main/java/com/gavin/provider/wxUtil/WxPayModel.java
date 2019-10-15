package com.gavin.provider.wxUtil;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-15 13:49
 * @description:
 ************************************************************/
@Component
@ConfigurationProperties(prefix = "wxPayConfig")
@Data
public class WxPayModel {


    private String appid;
    private String mchid;
    private String key;
    private String unified;
    private String notifyurl;
    private String type;

}
