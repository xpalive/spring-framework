package com.xiongping.dynamicProxy;

import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

public class CglibTest {
	public static void main(String[] args) {
		UserServiceImpl target = new UserServiceImpl();

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserServiceImpl.class);
		enhancer.setCallbacks(new Callback[]{(MethodInterceptor) (o, method, objects, methodProxy) -> {
			System.out.println("before");
//				final Object result = methodProxy.invoke(target, objects);
//				final Object result = method.invoke(target, objects);
//				final Object result = method.invoke(o, objects); //报错，执行代理类的当前方法，会栈溢出
			final Object result = methodProxy.invokeSuper(o, objects);
			System.out.println("after");
			return result;
		}, NoOp.INSTANCE
		});

		enhancer.setCallbackFilter(new CallbackFilter() {
			@Override
			public int accept(Method method) {
				if (method.getName().equals("testVoid")) {
					return 0;
				}
				return 1;
			}
		});

		final UserServiceImpl userService = (UserServiceImpl) enhancer.create();
//		System.out.println(userService.test());
		userService.test();
	}
}
