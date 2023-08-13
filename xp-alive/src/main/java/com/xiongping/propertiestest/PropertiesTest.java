package com.xiongping.propertiestest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class PropertiesTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(PropertiesTest.class);
		applicationContext.refresh();
		final TestProperties bean = applicationContext.getBean(TestProperties.class);
		System.out.println(bean.getName().get());
	}
}
