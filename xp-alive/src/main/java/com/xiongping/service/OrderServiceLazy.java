package com.xiongping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class OrderServiceLazy {

	@Autowired
	@Lazy
	private UserServiceFacade userService;

	@PreDestroy
	public void des() {
		System.out.println("preDestroy");
	}

}
