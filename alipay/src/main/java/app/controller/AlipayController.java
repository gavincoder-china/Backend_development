package app.controller;

import app.utils.AlipayAttr;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-27 14:55
 * @description:
 ************************************************************/
@Controller
@ResponseBody
@RequestMapping("alipay")
public class AlipayController {


    @RequestMapping("pay")
    public void pay(HttpServletRequest request, HttpServletResponse response) throws IOException {



        /*获得初始化的AlipayClient
         * AlipayClient alipayClient = new DefaultAlipayClient(
         * "https://openapi.alipaydev.com/gateway.do",
         * "2016091700535499","请复制第1步中生成的密钥中的商户应用私钥,
         * "json","utf-8","沙箱环境RSA2支付宝公钥","RSA2");
         * */
        AlipayClient alipayClient = new DefaultAlipayClient(
                AlipayAttr.gatewayUrl, AlipayAttr.app_id,
                AlipayAttr.merchant_private_key, "json", AlipayAttr.charset,
                AlipayAttr.alipay_public_key, AlipayAttr.sign_type);

        // 取购买人名称
        //  String in_name = request.getParameter("in_name");
        String in_name = "hello";
        // 取手机号
        //  String in_phone = request.getParameter("in_phone");
        String in_phone = "12222222";
        // 创建唯一订单号
        int random = (int) (Math.random() * 10000);
        String dateStr = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // 订单号拼接规则：手机号后四位+当前时间后四位+随机数四位数
        String out_trade_no = in_phone.substring(7) + dateStr.substring(10)
                              + random;
        // 拼接订单名称
//		String subject = in_name + "大喵的订单";
        String subject = "大喵的订单";

        // 取付款金额
        // String total_amount = request.getParameter("in_money");
        String total_amount = "66";

        // 设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayAttr.return_url);//支付成功响应后跳转地址
        alipayRequest.setNotifyUrl(AlipayAttr.notify_url);//异步请求地址

        /*FAST_INSTANT_TRADE_PAY 二维码瞬时支付
         * out_trade_no 订单号 total_amount 订单金额  subject 订单名称
         */
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no
                                    + "\"," + "\"total_amount\":\"" + total_amount + "\","
                                    + "\"subject\":\"" + subject + "\"," + "\"body\":\""
                                    + "" + "\"," + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String result = "请求无响应";
        // 请求
        try {
            //通过阿里客户端，发送支付页面请求
            result = alipayClient.pageExecute(alipayRequest).getBody();
       /*     System.out.println("********************");
            System.out.println("--------------------");

            System.out.println(alipayClient.pageExecute(alipayRequest).getCode());
            System.out.println("-------------------");
            System.out.println(alipayClient.pageExecute(alipayRequest).getMsg());
            System.out.println("-------------------");

            System.out.println(alipayClient.pageExecute(alipayRequest).getSubCode());
            System.out.println("-------------------");

            System.out.println(alipayClient.pageExecute(alipayRequest).getSubMsg());


            System.out.println("--------------------");
            System.out.println("********************");*/

            System.out.println("这边是支付前----支付数据");
            System.out.println(result);
            response.getWriter().println(result);
            response.getWriter().flush();
        }
        catch (AlipayApiException | IOException e) {
            e.printStackTrace();
        }
        finally {
            response.getWriter().close();
        }


    }

    @RequestMapping("payResult")
    public void payResult(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 获取支付宝回调反馈的信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter
                .hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                                                    : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = false;
        try {// 调用SDK验证签名
            signVerified = AlipaySignature.rsaCheckV1(params,
                                                      AlipayAttr.alipay_public_key, AlipayAttr.charset,
                                                      AlipayAttr.sign_type);
        }
        catch (AlipayApiException e) {
            e.printStackTrace();
        }

        // 请在这里编写您的程序（以下代码仅作参考）
        if (signVerified) {//验签成功后执行的自定义业务代码
            // 商户订单号
            String out_trade_no = new String(request.getParameter(
                    "out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no")
                                                .getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter(
                    "total_amount").getBytes("ISO-8859-1"), "UTF-8");
            String msg = "支付宝交易号:" + trade_no + "<br/>商户订单号"
                         + out_trade_no + "<br/>付款金额:" + total_amount;
            System.out.println(msg);
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/success.html").forward(
                    request, response);

        } else {
            response.getWriter().println("验签/支付失败");
            response.getWriter().flush();
            response.getWriter().close();
        }


    }


    @RequestMapping("payNotify")
    public void payNotify(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter
                .hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                                                    : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = false;
        try {
            signVerified = AlipaySignature.rsaCheckV1(params,
                                                      AlipayAttr.alipay_public_key, AlipayAttr.charset,
                                                      AlipayAttr.sign_type);
        }
        catch (AlipayApiException e) {
            e.printStackTrace();
        } // 调用SDK验证签名

        // ——请在这里编写您的程序（以下代码仅作参考）——

        /*
         * 实际验证过程建议商户务必添加以下校验： 1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
         * 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
         * 3、校验通知中的seller_id（或者seller_email)
         * 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
         * 4、验证app_id是否为该商户本身。
         */
        if (signVerified) {// 验证成功
            // 商户订单号
            String out_trade_no = new String(request.getParameter(
                    "out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no")
                                                .getBytes("ISO-8859-1"), "UTF-8");

            // 交易状态
            String trade_status = new String(request.getParameter(
                    "trade_status").getBytes("ISO-8859-1"), "UTF-8");

            if (trade_status.equals("TRADE_FINISHED")) {
                // 判断该笔订单是否在商户网站中已经做过处理
                // 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                // 如果有做过处理，不执行商户的业务程序
                // 注意：
                // 退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
            } else if (trade_status.equals("TRADE_SUCCESS")) {
                // 判断该笔订单是否在商户网站中已经做过处理
                // 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                // 如果有做过处理，不执行商户的业务程序
                // 注意：
                // 付款完成后，支付宝系统发送该交易状态通知
            }

        } else {// 验证失败
            response.getWriter().println("验签/支付失败！");
            response.getWriter().flush();
            response.getWriter().close();

            // 调试用，写文本函数记录程序运行情况是否正常
            // String sWord = AlipaySignature.getSignCheckContentV1(params);
            // AlipayConfig.logResult(sWord);
        }

    }


}
