package com.example.consumer.config.annotation;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.example.consumer.contants.UserContants;
import com.example.consumer.exception.LoginException;
import com.example.consumer.exception.LoginExceptionEnum;
import com.example.consumer.util.RedisUtils;
import com.example.consumer.util.result.ReturnResultContants;
import com.example.consumer.util.result.ReturnResultUtils;
import com.example.consumer.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * Created by boot on 2019/9/29.
 */
public class AnnotationLoginReqComplete implements HandlerInterceptor {
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
        AnnotationLoginRequired methodAnnotation = method.getAnnotation(AnnotationLoginRequired.class);


        if (methodAnnotation != null) {

            // 从 http 请求头中取出 token
            String token = request.getHeader("token");

            if (!StringUtils.isBlank(token)) {

              String jsonStr = (String) redisUtils.get(UserContants.LOGIN_NAME_SPACE+token);

                if (!StringUtils.isBlank(jsonStr)) {

                    UserVo userVo = JSONObject.parseObject(jsonStr, UserVo.class);

                    request.setAttribute("userToken", userVo);

                    return true;
                }

            }

            throw  new LoginException(LoginExceptionEnum.LOGIN_FAIL_ECPTION,"请先登录");

      /*      response.setCharacterEncoding("UTF-8");
            PrintWriter pw = response.getWriter();

            pw.write(JSONObject.toJSONString(
                    ReturnResultUtils.returnFail(
                            ReturnResultContants.INTERCPTOR_LOGIN_ERROR,
                            ReturnResultContants.MSG_INTERCPTOR_LOGIN_ERROR)));

            pw.flush();
            pw.close();
            return false;*/

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
