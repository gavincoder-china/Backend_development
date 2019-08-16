package main.SpringAOPXML;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-16 14:56
 * @description:将该类放进spring容器,声明成一个切面类
 ************************************************************/

public class CalculateAOP2 {



    //前置通知
    //@Before("execution(public int main.SpringAOP.Calculate.add(int,int))")
    //@Before("execution(* main.SpringAOP.*.*(..))")
    //@Before(value = "MyPointCut()")

    public void before(JoinPoint joinPoint) {
        //方法名
        String name = joinPoint.getSignature().getName();
        //参数
        Object[] args = joinPoint.getArgs();

        System.out.println(name + "方法开始执行了,参数为:" + Arrays.asList(args));
    }


    //后置通知,没有返回值,相当于finally,不管有无异常都执行
    //@After("execution(* main.SpringAOP.*.*(..))")
    public void after(JoinPoint joinPoint) {
        //方法名
        String name = joinPoint.getSignature().getName();
        //参数
        Object[] args = joinPoint.getArgs();

        System.out.println(name + "方法执行完毕,参数为:" + Arrays.asList(args));
    }


    //返回通知,带返回值 返回值名称要对应 returning与参数中Object中的名称要一致 如果方法发生异常,不执行
    //@AfterReturning(value = "execution(* main.SpringAOP.*.*(..))", returning = "rs")
    public void afterReturn(JoinPoint joinPoint, Object rs) {
        //方法名
        String name = joinPoint.getSignature().getName();


        System.out.println(name + "方法执行完毕,返回值为:" + rs);
    }

    //异常通知  当方法发生异常时执行
    //@AfterThrowing(value = "execution(* main.SpringAOP.*.*(..))", throwing = "ex")
    public void exception(JoinPoint joinPoint, Exception ex) {
        //方法名
        String name = joinPoint.getSignature().getName();


        System.out.println(name + "方法执行产生异常,异常为:" + ex);

    }

    //环绕通知 是上面四个通知的汇总
   //@Around("execution(* main.SpringAOP.*.*(..))")
 /*   public Object around(ProceedingJoinPoint joinPoint) {
        Object rs = null;
        try {
            System.out.println("环绕通知-前");

           rs= joinPoint.proceed();
            System.out.println("环绕通知-返回");


        }
        catch (Throwable throwable) {
            System.out.println("环绕通知-异常");

            throwable.printStackTrace();
        }
        finally {
            System.out.println("环绕通知-后");

        }
        return rs;
    }*/

}
