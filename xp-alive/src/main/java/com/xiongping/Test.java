package com.xiongping;

import com.xiongping.service.OrderService;
import com.xiongping.service.UserService;
import com.xiongping.service.XiongpingFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
//		context.register(AppConfig.class);
//		context.refresh();
//		OrderService orderService = context.getBean("orderService", OrderService.class);
//		System.out.println(orderService);
//		UserService userService = context.getBean("userService", UserService.class);
		XiongpingFactoryBean xiongpingFactoryBean = context.getBean("xiongpingFactoryBean", XiongpingFactoryBean.class);
		System.out.println(xiongpingFactoryBean);
	}
}
