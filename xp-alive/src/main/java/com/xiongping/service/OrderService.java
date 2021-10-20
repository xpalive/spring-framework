package com.xiongping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class OrderService {


	private UserServiceFacade userService1;
	private UserServiceFacade userService;

	@Autowired
	public void setUserService(UserServiceFacade userService1,UserServiceFacade userService) {
		this.userService1 = userService1;
		this.userService = userService;
	}

	@PreDestroy
	public void des() {
		System.out.println("preDestroy");
	}

	public UserServiceFacade getUserService1() {
		return userService1;
	}
	public UserServiceFacade getUserService() {
		return userService;
	}
}
