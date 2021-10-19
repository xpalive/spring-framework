package com.xiongping.service;

import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class OrderService1 {

	@Autowired
	private UserServiceFacade userService;

	@PreDestroy
	public void des() {
		System.out.println("preDestroy");
	}

}
