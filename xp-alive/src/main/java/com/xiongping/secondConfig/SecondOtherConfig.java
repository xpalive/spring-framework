package com.xiongping.secondConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.xiongping.thirdConfig")
public class SecondOtherConfig {

}
