package com.xiongping.inferredConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.xiongping.inferredConstruct")
public class AppConfig {
    
    @Bean
    public UserService userServiceBean1() {
        return new UserService(null, null);
    }
}
