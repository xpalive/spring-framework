package com.xiongping.dynamicProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk的动态代理只能通过接口来实现
 * 通过传入被代理的类的实例来调用原始逻辑
 * 被代理的类需要实现接口才可以通过反射方式调用对应的方法，否则就需要主动调用
 */
public class JdkTest {
	public static void main(String[] args) {
		
		final UserServiceImpl userService = new UserServiceImpl();

		final UserService proxyInstance = (UserService) Proxy.newProxyInstance(JdkTest.class.getClassLoader(), new Class[]{UserService.class},
				(Object proxy, Method method, Object[] args1) -> {
					System.out.println("before");
//					userService.testVoid();
					return method.invoke(userService, args1);
				});
		proxyInstance.testVoid();
		System.out.println();
	}
}
