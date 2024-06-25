package com.xiongping.beanlifecircle.springbean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class NormalBean {
    
    @PostConstruct
    public void postConstruct() {
        System.out.println(this.getClass().getSimpleName() + "postConstruct");
    }
    
    @PreDestroy
    public void preDestroy() {
        System.out.println(this.getClass().getSimpleName() + "preDestroy");
    }
}
