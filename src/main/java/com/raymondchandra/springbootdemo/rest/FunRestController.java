package com.raymondchandra.springbootdemo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fun")
public class FunRestController {
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/")
	public String getHello() {
		return "Hello World Update!! :)";	
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5K!! :)";
	}

	@GetMapping("/fortune")
	public String getFortune() {
		return "<h1>Today is your lucky day!!</h1>";		
	}
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach: " + coachName + ", Team: " + teamName;	
	}
}
