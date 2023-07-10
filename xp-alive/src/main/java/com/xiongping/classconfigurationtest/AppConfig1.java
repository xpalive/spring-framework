package com.xiongping.classconfigurationtest;

import org.springframework.context.annotation.Bean;

public class AppConfig1 {

	@Bean
	public UserService userService(){
		return new UserService();
	}
}
