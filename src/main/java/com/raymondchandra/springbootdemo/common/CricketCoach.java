package com.raymondchandra.springbootdemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Primary
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CricketCoach implements Coach  {

	public CricketCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "Practice CRICKET for 15 mins";
	}
	
	// Hooks - like BEFORE method
	@PostConstruct
	public void init() {
		System.out.println("Doing my BEFORE method");
	}
	
	// Hooks - like AFTER method
	@PreDestroy
	public void cleanUp() {		
		System.out.println("Doing my AFTER method");
	}
}
