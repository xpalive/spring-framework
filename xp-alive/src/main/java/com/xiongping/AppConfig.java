package com.xiongping;

import com.xiongping.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan(value = "com.xiongping")
@Import(UserService.class)
public class AppConfig {

	@Bean
	public UserService userServiceBean(){
		return new UserService();
	}
}
