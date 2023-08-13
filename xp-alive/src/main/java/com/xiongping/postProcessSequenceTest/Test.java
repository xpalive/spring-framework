package com.xiongping.postProcessSequenceTest;

import com.xiongping.postProcessSequenceTest.bean.TestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Test {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
		final TestBean testBean = (TestBean) context.getBean("testBean");
		testBean.getDefValue().test();
		context.getBean("testBean2");
	}
}
