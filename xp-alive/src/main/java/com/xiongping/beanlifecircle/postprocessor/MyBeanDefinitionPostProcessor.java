package com.xiongping.beanlifecircle.postprocessor;

import com.xiongping.beanlifecircle.springbean.CommunityBean;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author xiongping
 * @date 2024-06-25
 */
@Component
public class MyBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {
	@Override
	public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
		if (beanName.equals("userBean")) {
			// 需要communityBean 有set方法
			beanDefinition.getPropertyValues().addPropertyValue("communityBean", new CommunityBean(1));
		}
	}

}
