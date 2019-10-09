package gavin.code.controller;


import com.alibaba.fastjson.JSONObject;
import gavin.code.util.UrlUtils;
import gavin.code.wx.WxLoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-09 10:27
 * @description:
 ************************************************************/

@Controller
@RequestMapping(value = "/wx")
public class WxController {

    @Autowired
    private WxLoginModel wxLoginModel;


    @GetMapping(value = "/getCode")
    public String getCode() {

        //将生成的链接返回到前端并重定向到链接地址
        // 为了使用redirect重定向方法,不可加上@restcontroller  @ResponseBody
        //这边你也可以使用二维码生成器生成二维码图像进行扫码
        return "redirect:" + wxLoginModel.getRealUrl();
    }


    @GetMapping(value = "/callBack")
    public String callBack(String code) {

        //1.使用回调传进来的code数据调用生成链接的方法,获取请求access_token&openid等参数的链接
        String accessTokenUrl = wxLoginModel.getAccessTokenUrl(code);

        //2.通过工具类发起http请求并接受返回值
        String accessTokenUrlJson = UrlUtils.loadURL(accessTokenUrl);

        //3.由于获取到的数据是json对象格式的,所以使用fastjson中的方法将其转成jsonObject
        JSONObject accessTokenJsonObject = JSONObject.parseObject(accessTokenUrlJson);

        //4.通过fastjson的getstring方法提取该json对象中的数据
        String accessToken = accessTokenJsonObject.getString("access_token");
        String openid = accessTokenJsonObject.getString("openid");

        //5.使用获取到的数据调用生成链接的方法,获取请求用户信息的链接
        String userInfoUrl = wxLoginModel.getUserInfoUrl(accessToken, openid);
        //6.通过工具类发起http请求并接受返回值
        String userInfoJson = UrlUtils.loadURL(userInfoUrl);
        //7.同上,解析数据,获取数据,至此,微信登录成功
        JSONObject userInfoJsonObject = JSONObject.parseObject(userInfoJson);


        //8.拿数据进行操作.这边随意了
        //..........

        return "随意写什么";

    }


    @GetMapping(value = "/happy")
    @ResponseBody
    public String happyBirthDay() {

        //彩蛋❤️
        return "2019-10-10,🐖我亲爱的平平生日快乐❤️";
    }


}
