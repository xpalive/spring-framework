package com.xiongping.service;

import com.xiongping.service.lottory.Lottery;
import com.xiongping.service.lottory.anno.TimeLottery;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OrderService {


	private UserServiceFacade userService1;
	private UserServiceFacade userService;
	private Lottery lottery;

	@Bean
	public UserServiceFacade userServiceFacadeAtBean(){
		return new UserService();
	}

	public UserServiceFacade getUserService1() {
		return userService1;
	}

	@Autowired
	public void setUserService1(UserServiceFacade userService1) {
		this.userService1 = userService1;
	}

	public UserServiceFacade getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceFacade userService) {
		this.userService = userService;
	}

	public Lottery getLottery() {
		return lottery;
	}

	@Autowired
	public void setLottery(
			@TimeLottery Lottery lottery) {
		this.lottery = lottery;
	}

	@PreDestroy
	public void des() {
		System.out.println("OrderService preDestroy");
	}

}
