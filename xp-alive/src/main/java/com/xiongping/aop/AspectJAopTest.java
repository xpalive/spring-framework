package com.xiongping.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * @author xiongping
 * @version 1.0
 * @since 2024/7/23
 **/
@Import(MyAspect.class)
@ComponentScan("com.xiongping.aop")
public class AspectJAopTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectJAopTest.class);
		UserService userService = (UserService) context.getBean("userServiceImpl");
		userService.say();
	}
}
