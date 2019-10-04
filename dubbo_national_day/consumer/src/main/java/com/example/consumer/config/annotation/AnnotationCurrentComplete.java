package com.example.consumer.config.annotation;


import com.example.consumer.vo.UserVo;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by boot on 2019/9/29.
 */
public class AnnotationCurrentComplete implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(UserVo.class)
                && parameter.hasParameterAnnotation(AnnotationCurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest webRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {

        UserVo userVo = (UserVo) webRequest.getAttribute("userToken", RequestAttributes.SCOPE_REQUEST);

        if (userVo != null) {
            return userVo;
        }

        return null;

    }
}
