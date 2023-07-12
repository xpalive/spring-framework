package com.xiongping.circularRef;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Aaaa {
	@Autowired
	private Bbbb bbbb;

	public void print() {
		System.out.println("aaa:bbb->mem addr:" + bbbb);
		System.out.println("self mem addr:" + this);
	}
}
