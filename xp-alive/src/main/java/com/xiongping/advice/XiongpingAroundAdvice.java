package com.xiongping.advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class XiongpingAroundAdvice implements MethodInterceptor {


	@Nullable
	@Override
	public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
		System.out.println("before");
		Object proceed = invocation.proceed();
		System.out.println("after");
		return proceed;
	}
}
