package com.xiongping;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
//        context.addBeanFactoryPostProcessor();
        context.registerShutdownHook();
        //		BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(
        //						UserService2.class)
        //				.getBeanDefinition();
        
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
        //		Object userServiceBean = context.getBean("userServiceBean");
        //		System.out.println(userServiceBean);
        //
        //		UserService2 userService2 = (UserService2) context.getBean("userService2");
        //		userService2.test();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(
                    "beanDefinitionName: " + beanDefinitionName + " class: " + context.getBean(beanDefinitionName).getClass());
            
        }
        
    }
}
