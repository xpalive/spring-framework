package com.xiongping.factorybean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xiongping
 * @version 1.0
 * @since 2024/7/18
 **/
public class FactoryBeanTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		BeanDefinition injectBeanDefinition = BeanDefinitionBuilder.genericBeanDefinition(InjectBean.class).getBeanDefinition();
		context.registerBeanDefinition("injectBean", injectBeanDefinition);

		BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(TestFactoryBean.class).getBeanDefinition();
		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("java.lang.Object");
		context.registerBeanDefinition("testFactoryBean", beanDefinition);
		context.refresh();
		System.out.println(context.getBean("testFactoryBean"));
	}
}
