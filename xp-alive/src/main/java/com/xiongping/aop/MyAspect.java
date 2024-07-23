package com.xiongping.aop;

//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
//import org.aspectj.lang.reflect.Pointcut;


@Aspect
@Component
@EnableAspectJAutoProxy
public class MyAspect {

    // 定义切入点表达式
    @Pointcut("execution(* com.xiongping.aop.*.*(..))")
    public void myPointcut() {}

    // 在切入点之前执行的通知
    @Before("myPointcut()")
    public void beforeAdvice() {
        System.out.println("Before advice executed!");
    }
}