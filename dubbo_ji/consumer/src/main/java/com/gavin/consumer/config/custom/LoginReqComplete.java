package com.gavin.consumer.config.custom;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.gavin.consumer.util.RedisUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by boot on 2019/9/29.
 */
public class LoginReqComplete implements HandlerInterceptor {
    @Autowired
    private RedisUtils redisUtils;
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断方法是否添加了这个注解
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);
        if (methodAnnotation != null) {
            // 从 http 请求头中取出 token
            String token = request.getHeader("token");

            if (!StringUtils.isBlank(token)) {
              String userToken = (String) redisUtils.get(token);

                if (StringUtils.isBlank(userToken)) {
                    throw new RuntimeException("login error");
                } else {
                   // String tokenStr = JSONObject.parseObject(userToken, User.class);
                    request.setAttribute("userToken", userToken);
                }
            } else {
                //throw new BusinessException(BusinessEnum.TOKEN_IS_NULL,"token is blank");
            }
            return true;
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
