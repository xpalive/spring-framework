package com.xiongping.inferredConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class DepartmentService extends BaseService {
    
    private String a;
    
    public DepartmentService(){
        a = "aaa";
    }
    
    public void setA(String a) {
        this.a = a;
    }
    
    public String getA() {
        return this.a;
    }
}
