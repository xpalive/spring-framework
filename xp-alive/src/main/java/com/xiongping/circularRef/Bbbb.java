package com.xiongping.circularRef;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Bbbb {
	@Autowired
	Aaaa aaaa;

	public void print() {
		System.out.println("bbb:aaa->mem addr:" + aaaa);
		System.out.println("self mem addr:" + this);
	}
}
