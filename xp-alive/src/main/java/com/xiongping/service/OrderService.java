package com.xiongping.service;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class OrderService {


	@PreDestroy
	public void des() {
		System.out.println("preDestroy");
	}

}
