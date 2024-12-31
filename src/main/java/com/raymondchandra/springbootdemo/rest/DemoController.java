package com.raymondchandra.springbootdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raymondchandra.springbootdemo.common.Coach;

@RestController
@RequestMapping("/workout")
public class DemoController {
	private Coach coach;
	private Coach anotherCoach;
	
	// Constructor Injection - using @Qualifier
	@Autowired
	public DemoController(@Qualifier("aquatic") Coach coach) {
		this.coach = coach;
	}
	
//	@Autowired
//	public DemoController(
//			@Qualifier("tennisCoach") Coach coach,
//			@Qualifier("tennisCoach") Coach anotherCoach) {
//		this.coach = coach;
//		this.anotherCoach = anotherCoach;
//	}

	// Setter Injection - using @Primary which is attached to the CricketCoach component
//	@Autowired
//	public void setCoach(Coach coach) {
//		this.coach = coach;
//	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return coach.getDailyWorkout();
	}

	@GetMapping("/coachcheck")
	public String getCoachCheck() {
		return "Comparing coach is the same as anotherCoach? " + (coach == anotherCoach);
	}
}
