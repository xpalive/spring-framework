package com.xiongping.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.xiongping.secondConfig")
public class OtherConfig {

}
