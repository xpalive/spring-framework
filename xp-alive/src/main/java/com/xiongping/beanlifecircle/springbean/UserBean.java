package com.xiongping.beanlifecircle.springbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xiongping
 * @date 2024-06-25
 */
@Component
public class UserBean {

	@Autowired
	private CommunityBean communityBean;

	public CommunityBean getCommunityBean() {
		return communityBean;
	}

	public void setCommunityBean(CommunityBean communityBean) {
		this.communityBean = communityBean;
	}
}
