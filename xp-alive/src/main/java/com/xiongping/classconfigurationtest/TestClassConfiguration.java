package com.xiongping.classconfigurationtest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

public class TestClassConfiguration {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig1.class);
		context.refresh();
		context.getBean("userService");
	}
}
