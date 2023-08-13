package com.xiongping.dynamicProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkTest {
	public static void main(String[] args) {
		final UserService userService = new UserServiceImpl();

		final UserService proxyInstance = (UserService) Proxy.newProxyInstance(JdkTest.class.getClassLoader(), new Class[]{UserService.class},
				(Object proxy, Method method, Object[] args1) -> {
					System.out.println("before");
					return method.invoke(userService, args1);
				});
		proxyInstance.testVoid();
		System.out.println();
	}
}
