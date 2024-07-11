package com.xiongping.inferredConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    
    @Bean
    public UserService userServiceBean1() {
        return new UserService(null, null);
    }
}
