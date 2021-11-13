package com.xiongping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Component
//@Priority(3)
public class UserService2 implements UserServiceFacade {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void test(){
		jdbcTemplate.execute("select * from ums_user");
		System.out.println("test");
//		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();// 强制回滚
	}
}
