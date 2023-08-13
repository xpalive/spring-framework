package com.xiongping.circularRef;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
// 使用构造方法无法解决循环依赖
// 使用双方依赖的bean都是原型类无法解决循环依赖
@ComponentScan
public class CircularRefTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CircularRefTest.class);
//		final Aaaa aaaa = (Aaaa) context.getBean("aaaa");
//		final Bbbb bbbb = (Bbbb) context.getBean("bbbb");
//		aaaa.print();
//		bbbb.print();
	}
}
