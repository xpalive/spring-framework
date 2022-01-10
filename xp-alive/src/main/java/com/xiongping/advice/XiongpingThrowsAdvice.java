package com.xiongping.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class XiongpingThrowsAdvice implements ThrowsAdvice {

	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {

	}
}
