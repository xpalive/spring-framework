package com.xiongping.beanlifecircle;

import com.xiongping.beanlifecircle.springbean.UserBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.xiongping.beanlifecircle")
public class BeanLifeCircleApp {
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanLifeCircleApp.class);
        context.registerShutdownHook();
		final UserBean bean = context.getBean(UserBean.class);
		System.out.println(bean.getCommunityBean());

	}
}
