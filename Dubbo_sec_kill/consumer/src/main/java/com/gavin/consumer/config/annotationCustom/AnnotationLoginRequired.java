package com.gavin.consumer.config.annotationCustom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by boot on 2019/9/29.
 */
@Target(ElementType.METHOD)//代表了这个自定义注解必须要加载方法上
@Retention(RetentionPolicy.RUNTIME)//运行时候有效
public @interface AnnotationLoginRequired {

}
