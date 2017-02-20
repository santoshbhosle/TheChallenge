package com.challenge.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:challenge.properties")
public class PropertyManager {

	@Autowired
	private Environment env;

	private static Environment environment;
	
	@PostConstruct
	public void init(){
		environment = env;
	}

	public static String getPopertyValue(String property){
		return environment.getProperty(property);
	}
	
}
