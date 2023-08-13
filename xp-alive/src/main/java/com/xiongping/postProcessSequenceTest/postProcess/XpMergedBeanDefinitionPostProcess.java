package com.xiongping.postProcessSequenceTest.postProcess;

import com.xiongping.postProcessSequenceTest.bean.DefaultValue;
import com.xiongping.postProcessSequenceTest.bean.DefaultValueInterface;
import com.xiongping.postProcessSequenceTest.bean.TestBean;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class XpMergedBeanDefinitionPostProcess implements MergedBeanDefinitionPostProcessor {
	@Override
	public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
		System.out.println("postProcessMergedBeanDefinition:" + beanName);
		if (DefaultValueInterface.class.isAssignableFrom(beanType)) {
			beanDefinition.getPropertyValues().addPropertyValue("defValue", new DefaultValue());
		}
	}
}
