package com.xiongping;

import com.xiongping.service.UserService2;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.transaction.support.TransactionSynchronizationUtils;

import java.util.ServiceLoader;


public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
		context.registerShutdownHook();
		BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(
						UserService2.class)
				.getBeanDefinition();

		context.publishEvent("123");
//		context.register(AppConfig.class);
//		context.refresh();
//		OrderService orderService = context.getBean("orderService", OrderService.class);
//		System.out.println(orderService.getUserService());
//		System.out.println(orderService.getUserService1());
//		System.out.println(orderService.getLottery().strategyName());
//		UserServiceFacade userService = context.getBean("userService", UserServiceFacade.class);
//		UserServiceFacade userService1 = context.getBean("userService1", UserServiceFacade.class);
//		UserServiceFacade userService2 = context.getBean("userService2", UserServiceFacade.class);
//		System.out.println(userService1);
//		System.out.println(userService2);
//		UserService userService = context.getBean("userService", UserService.class);
//		XiongpingFactoryBean xiongpingFactoryBean = context.getBean("&xiongpingFactoryBean", XiongpingFactoryBean.class);
//		System.out.println(xiongpingFactoryBean);
		Object userServiceBean = context.getBean("userServiceBean");
		System.out.println(userServiceBean);

		UserService2 userService2 = (UserService2) context.getBean("userService2");
		userService2.test();


	}
}
