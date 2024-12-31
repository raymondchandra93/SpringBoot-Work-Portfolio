package com.raymondchandra.springbootdemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)		// To make it NOT SINGLETON, by default bean is SINGLETON
public class TennisCoach implements Coach  {

	public TennisCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice TENNIS for 15 mins";
	}

}
