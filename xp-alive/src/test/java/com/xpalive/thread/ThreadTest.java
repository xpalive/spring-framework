package com.xpalive.thread;

public class ThreadTest {


	public static void main(String[] args) {
//		ThreadLocal<String> threadLocal = new ThreadLocal<>();
//		// threadLocal 在set的时候会判断ThreadLocalMap是否为null，如果为null则创建
//		// 如果是null,则把当前线程传入，创建ThreadLocalMap,并赋值给当前线程的属性threadLocals
//		// 如果不能为null,则把当前ThreadLocal传入map作为key，获取值
//		threadLocal.set("xiongping");
		ThreadTest threadTest = new ThreadTest();
		final Object obj = threadTest;
		System.out.println((obj instanceof Class));
	}
}
