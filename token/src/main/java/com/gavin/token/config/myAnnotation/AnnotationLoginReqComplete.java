package com.gavin.token.config.myAnnotation;


import com.alibaba.fastjson.JSONObject;
import com.gavin.token.util.JwtUtil;
import com.gavin.token.util.result.ReturnResultContants;
import com.gavin.token.util.result.ReturnResultUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-03 16:41
 * @description:
 ************************************************************/
public class AnnotationLoginReqComplete implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 判断方法是否添加了这个注解
        AnnotationLoginRequired methodAnnotation = method.getAnnotation(AnnotationLoginRequired.class);
        if (null != methodAnnotation) {
            String token = request.getHeader("token");
            if (null != token && !"".equals(token)) {

                Claims claims = jwtUtil.parseJWT(token);

                if (null != claims) {

                    String userName = claims.getSubject();

                    request.setAttribute("userToken", userName);
                    return true;
                }

            }
            response.setCharacterEncoding("UTF-8");
            PrintWriter pw = response.getWriter();

            pw.write(JSONObject.toJSONString(
                    ReturnResultUtils.returnFail(
                            ReturnResultContants.INTERCPTOR_LOGIN_ERROR,
                            ReturnResultContants.MSG_INTERCPTOR_LOGIN_ERROR)));

            pw.flush();
            pw.close();
            return false;
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
