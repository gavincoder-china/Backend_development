package com.gavin.consumer.config.annotationCustom;



import com.gavin.provider.dto.Oauth;
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
        return parameter.getParameterType().isAssignableFrom(Oauth.class)
               && parameter.hasParameterAnnotation(AnnotationCurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {

        Oauth oauth = (Oauth) webRequest.getAttribute("userToken", RequestAttributes.SCOPE_REQUEST);

        if (oauth != null) {

            return oauth;
        }

        return null;

    }
}
