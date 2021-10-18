package com.xiongping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class OrderService {

	@Autowired
	private UserServiceFacade userService;

	@PreDestroy
	public void des() {
		System.out.println("preDestroy");
	}

}
