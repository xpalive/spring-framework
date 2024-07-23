package com.xiongping.aop;

import org.springframework.stereotype.Service;

/**
 * @author xiongping
 * @version 1.0
 * @since 2024/7/23
 **/
@Service
public class UserServiceImpl implements UserService {
	@Override
	public String say() {
		String res = "hello";
		System.out.println(res);
		return res;
	}
}
