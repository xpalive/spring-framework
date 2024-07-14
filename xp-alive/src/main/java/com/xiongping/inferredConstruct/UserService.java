package com.xiongping.inferredConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 构造方法的顺序特意这样写，为了测试推断构造方法的逻辑
// 只有存在多个Autowired为false的情况下才会需要推断构造方法
@Service
public class UserService extends BaseService {

	private OrderService orderService;

	private DepartmentService departmentService;

	@Autowired(required = false)
	public UserService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Autowired(required = false)
	public UserService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Autowired(required = false)
	public UserService(OrderService orderService, DepartmentService departmentService) {
		this.orderService = orderService;
		this.departmentService = departmentService;
	}

//	public UserService() {
//	}


	public OrderService getOrderService() {
		return orderService;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}
}
