package com.xiongping.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class XiongpingAfterReturning implements AfterReturningAdvice {


	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("after returning advice");
	}
}
