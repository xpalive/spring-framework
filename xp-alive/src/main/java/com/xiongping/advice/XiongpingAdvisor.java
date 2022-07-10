package com.xiongping.advice;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Method;

public class XiongpingAdvisor implements PointcutAdvisor {
    
    @Override
    public Advice getAdvice() {
        return new MethodInterceptor() {
            @Nullable
            @Override
            public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
                System.out.println("before");
                Object proceed = invocation.proceed();
                System.out.println("after");
                return proceed;
            }
        };
    }
    
    @Override
    public boolean isPerInstance() {
        return false;
    }
    
    @Override
    public Pointcut getPointcut() {
        return new StaticMethodMatcherPointcut() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                return method.getName().matches("laugh");
            }
        };
    }
}
