package com.xiongping.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author xiongping
 * @version 1.0
 * @since 2024/7/18
 **/
public class TestFactoryBean implements FactoryBean<Object> {

	private final Class<?> objectType;

	public TestFactoryBean(Class<?> objectType) {
		this.objectType = objectType;
	}

	@Override
	public Object getObject() throws Exception {
		return new Object();
	}

	@Override
	public Class<?> getObjectType() {
		return objectType;
	}
}
