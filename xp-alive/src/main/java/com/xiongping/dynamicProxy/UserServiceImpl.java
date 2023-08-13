package com.xiongping.dynamicProxy;

public class UserServiceImpl implements UserService {
	@Override
	public String test() {
		return (this.getClass().getName() + ":test");
	}

	@Override
	public void testVoid() {
		System.out.println((this.getClass().getName() + ":testVoid"));
	}
}
