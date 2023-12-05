package com.xiongping.aop;

//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;

//@Aspect
public class MyAspect {

    // 定义切入点表达式
//    @Pointcut("execution(* com.example.service.*.*(..))")
    public void myPointcut() {}

    // 在切入点之前执行的通知
//    @Before("myPointcut()")
    public void beforeAdvice() {
        System.out.println("Before advice executed!");
    }
}