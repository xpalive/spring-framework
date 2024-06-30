package com.xiongping.inferredConstruct;

import org.springframework.beans.factory.annotation.Autowired;

// 构造方法的顺序特意这样写，为了测试推断构造方法的逻辑
public class UserService extends BaseService {
    
    private OrderService orderService;
    
    private DepartmentService departmentService;
    
    public UserService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    
    @Autowired()
    public UserService(OrderService orderService) {
        this.orderService = orderService;
    }
    
    @Autowired(required = false)
    public UserService(OrderService orderService, DepartmentService departmentService) {
        this.orderService = orderService;
        this.departmentService = departmentService;
    }
    
    public UserService() {
    }
    
    
    public OrderService getOrderService() {
        return orderService;
    }
    
    public DepartmentService getDepartmentService() {
        return departmentService;
    }
}
