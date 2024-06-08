package com.xiongping.utiltest;

import javax.annotation.PostConstruct;

public class InitMethodBeanTest {
    
    void init() {
        System.out.println("InitMethod init");
    }
    
    @PostConstruct
    void postConstruct(){
        System.out.println("InitMethod postConstruct");
    }
}
