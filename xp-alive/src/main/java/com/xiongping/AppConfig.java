package com.xiongping;

import com.xiongping.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = "com.xiongping")
public class AppConfig {

	@Bean
	public UserService userServiceBean(){
		return new UserService();
	}
}
