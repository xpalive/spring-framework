package com.xiongping.utiltest;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
class Company implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("first");
	}


	public void postConstruct(){
		System.out.println("second");
	}

	//	@Import(Member.class)
	public class Department{


	}

//	@Import(Department.class)
	public class Member{

	}

}
