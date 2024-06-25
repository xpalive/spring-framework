package com.xiongping.beanlifecircle.springbean;

import org.springframework.stereotype.Component;

/**
 * @author xiongping
 * @date 2024-06-25
 */
@Component
public class CommunityBean {

	public CommunityBean() {
		System.out.println(this);
	}

	private int i;

	public CommunityBean(int i) {
		this.i = i;
		System.out.println(1 + "--" + this.toString());
	}
}
