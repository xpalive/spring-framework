package com.xiongping.postProcessSequenceTest;

import com.xiongping.postProcessSequenceTest.bean.TestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
		final TestBean testBean = (TestBean) context.getBean("testBean");
		testBean.getDefValue().test();
		context.getBean("testBean2");
	}
}
