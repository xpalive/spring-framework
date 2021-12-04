package com.xiongping.factorybean;

import com.xiongping.model.Xiongping;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class XiongpingFactoryBean implements FactoryBean<Xiongping> {
	@Override
	public Xiongping getObject() throws Exception {
		return new Xiongping();
	}

	@Override
	public Class<?> getObjectType() {
		return Xiongping.class;
	}
}
