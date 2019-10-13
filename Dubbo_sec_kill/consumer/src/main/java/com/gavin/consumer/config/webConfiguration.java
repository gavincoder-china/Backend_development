package com.gavin.consumer.config;

import com.gavin.consumer.config.annotationCustom.AnnotationCurrentComplete;
import com.gavin.consumer.config.annotationCustom.AnnotationLoginReqComplete;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;


import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-12 11:04
 * @description:
 ************************************************************/
@Configuration
public class webConfiguration implements WebMvcConfigurer {

  //注入容器
  @Bean
  public AnnotationLoginReqComplete loginReqComplete() {

    return new AnnotationLoginReqComplete();
  }

  @Bean
  public AnnotationCurrentComplete currentComplete() {

    return new AnnotationCurrentComplete();
  }

  @Override
  public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

  }

  @Override
  public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

  }

  @Override
  public void addFormatters(FormatterRegistry formatterRegistry) {

  }

  //    拦截器
  @Override
  public void addInterceptors(InterceptorRegistry interceptorRegistry) {
    interceptorRegistry.addInterceptor(loginReqComplete())
                       .excludePathPatterns("/wx/**");

  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

  }

  @Override
  //配置跨域
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedOrigins("*")
            .allowCredentials(true)
            .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
            .maxAge(3600);

  }

  @Override
  public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {

  }

  @Override
  public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

  }

  //参数拦截器(解析器)
  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

    list.add(currentComplete());
  }

  @Override
  public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

  }

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

  }

  @Override
  public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

  }

  @Override
  public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

  }

  @Override
  public Validator getValidator() {
    return null;
  }

  @Override
  public MessageCodesResolver getMessageCodesResolver() {
    return null;
  }
}
