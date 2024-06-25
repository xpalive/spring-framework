package com.xiongping.beanlifecircle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.xiongping.beanlifecircle")
public class BeanLifeCircleApp {
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanLifeCircleApp.class);
        context.registerShutdownHook();
    }
}
