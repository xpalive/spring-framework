package com.xiongping;

import com.xiongping.service.OrderService;
import com.xiongping.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
//		context.register(AppConfig.class);
//		context.refresh();
		OrderService orderService = context.getBean("orderService", OrderService.class);
		UserService userService = context.getBean("userService", UserService.class);
	}
}
