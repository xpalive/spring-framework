package com.xiongping.utiltest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    
    
    @Bean(initMethod = "init")
    public InitMethodBeanTest getInitMethodBeanTest() {
        return new InitMethodBeanTest();
    }
}
