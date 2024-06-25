package com.xiongping.utiltest;

import javax.annotation.PostConstruct;

public class InitMethodBeanTest {
    
    public void init() {
        System.out.println("InitMethod init");
    }
    
    @PostConstruct
    public void postConstruct(){
        System.out.println("InitMethod postConstruct");
    }
    
    public void close(){
        System.out.println("close InitMethodBeanTest");
    }
}
