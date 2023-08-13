package com.xiongping.classconfigurationtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig1 {

	@Bean
	public UserService userService(){
		return new UserService();
	}
}
