package com.xiongping.utiltest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class TestBeanFactory implements FactoryBean<Object> {
    
    @Override
    public Object getObject() throws Exception {
        return null;
    }
    
    @Override
    public Class<?> getObjectType() {
        return null;
    }
    
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
