package com.xiongping.propertiestest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class TestProperties {

	@Value("xiongping")
	private Optional<String> Name;

	public Optional<String> getName() {
		return Name;
	}

	public void setName(Optional<String> name) {
		Name = name;
	}
}
