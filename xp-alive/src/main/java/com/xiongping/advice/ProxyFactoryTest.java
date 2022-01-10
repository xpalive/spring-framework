package com.xiongping.advice;

import org.springframework.aop.framework.ProxyFactory;

public class ProxyFactoryTest {
	public static void main(String[] args) {
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
