package gavin.code.wx;

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
 * @Date : 2019-10-09 10:28
 * @description:
 ************************************************************/
@Component
@ConfigurationProperties(prefix = "wx")
@Data
public class WxLoginModel {
    //请求code的地址

    private String codeUrl;

    private String appId;

    //微信回调地址
    private String redirectUrl;

    //秘钥
    private String secret;

    //请求toekn的地址

    private String tokenUrl;

    //请求用户信息的地址

    private String userInfoUrl;


    /**
     * @return java.lang.String
     * @throws
     * @description 拼接生成请求code完整链接
     * @author Gavin
     * @date 2019-10-09 20:47
     * @since
     */
    public String getRealUrl() {
        //new stringBuffer对象的时候就把第一个需要拼接的字符串加进去(方便操作)
        StringBuffer buffer = new StringBuffer(getCodeUrl());


        String realUrl = buffer
                .append("appid=")
                .append(getAppId())
                .append("&redirect_uri=")
                .append(getRedirectUrl())
                .append("&response_type=code")
                .append("&scope=snsapi_userinfo")
                .append("&state=STATE")
                .append("#wechat_redirect")
                .toString();
        return realUrl;
    }


    /**
     * @return java.lang.String
     * @throws
     * @description 拼接生成请求accessToken/openid的完整链接,参数code由第一步方法返回
     * @author Gavin
     * @date 2019-10-09 20:48
     * @since
     */
    public String getAccessTokenUrl(String code) {


        StringBuffer buffer = new StringBuffer(getTokenUrl());
        String tokenUrl = buffer
                .append("appid=")
                .append(getAppId())
                .append("&secret=")
                .append(getSecret())
                .append("&code=")
                .append(code)
                .append("&grant_type=authorization_code").toString();
        return tokenUrl;
    }


    /**
     * @return java.lang.String
     * @throws
     * @description 拼接生成请求用户信息的完整链接, 参数accessToken/openid由第二步方法返回
     * @author Gavin
     * @date 2019-10-09 20:48
     * @since
     */
    public String getUserInfoUrl(String accessToken, String openid) {

        StringBuffer buffer = new StringBuffer(getUserInfoUrl());
        String UserInfoUrl = buffer
                .append("access_token=")
                .append(accessToken)
                .append("&openid=").append(openid)
                .append("&lang=zh_CN").toString();

        return UserInfoUrl;
    }


}
