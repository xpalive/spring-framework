package com.xiongping.dynamicProxy;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author xiongping
 * @date 2024-07-24
 */
public class ProxyFactoryTest {

	public static void main(String[] args) {
		ProxyFactory proxyFactory = new ProxyFactory();
		final UserServiceImpl userService = new UserServiceImpl();
		proxyFactory.setOptimize(true);
		proxyFactory.setTarget(userService);
		proxyFactory.setInterfaces(UserService.class);
//		proxyFactory.addAdvisor();
//		proxyFactory.addAdvice();

		final UserService proxy = (UserService) proxyFactory.getProxy();
		proxy.testVoid();
	}
}
