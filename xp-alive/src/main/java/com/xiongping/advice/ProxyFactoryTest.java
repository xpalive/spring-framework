package com.xiongping.advice;

import org.springframework.aop.framework.ProxyFactory;

public class ProxyFactoryTest {
    
    public static void main(String[] args) {
        ProxyFactoryTest test = new ProxyFactoryTest();
        
        test.advisor();
    }
    
    private void advisor(){
	    SpeakerService speakerService = new SpeakerService();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(speakerService);
        proxyFactory.addAdvisor(new XiongpingAdvisor());
        SpeakerService proxy = (SpeakerService)proxyFactory.getProxy();
        proxy.language();
    }
	
    private void advice() {
        SpeakerService speakerService = new SpeakerService();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(speakerService);
        proxyFactory.addAdvice(new XiongpingBeforeAdvice());
        proxyFactory.addAdvice(new XiongpingAfterReturning());
        proxyFactory.addAdvice(new XiongpingAroundAdvice());
        SpeakerService proxy = (SpeakerService) proxyFactory.getProxy();
        proxy.language();
    }
}
