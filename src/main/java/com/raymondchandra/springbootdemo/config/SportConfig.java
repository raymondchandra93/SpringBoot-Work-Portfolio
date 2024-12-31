package com.raymondchandra.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.raymondchandra.springbootdemo.common.Coach;
import com.raymondchandra.springbootdemo.common.SwimCoach;

@Configuration
public class SportConfig {
	
//	@Bean							// will use swimCoach as the component name
	@Bean("aquatic")				// will use aquatic as the component name
	public Coach swimCoach() {
		return new SwimCoach();
	}
}
