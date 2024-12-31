package com.raymondchandra.springbootdemo.common;

public class SwimCoach implements Coach  {
	
	public SwimCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice SWIMMING for 15 mins";
	}
}
