package com.xiongping.postProcessSequenceTest.bean;

import org.springframework.stereotype.Component;

@Component
public class TestBean implements DefaultValueInterface {


	private DefaultValue defValue;

	public DefaultValue getDefValue() {
		return defValue;
	}

	public void setDefValue(DefaultValue defValue) {
		this.defValue = defValue;
	}
}
