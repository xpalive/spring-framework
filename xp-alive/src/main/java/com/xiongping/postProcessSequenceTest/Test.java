package com.xiongping.postProcessSequenceTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
		context.getBean("testBeanFactory");
	}
}
