package com.xiongping.inferredConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService {
    
    @Bean
    public DepartmentService departmentService() {
        DepartmentService departmentService = new DepartmentService();
        departmentService.setA("bbbb");
        return departmentService;
    }
}
