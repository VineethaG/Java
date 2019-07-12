package com.demo.autowire;

import java.io.FileNotFoundException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneReadingfromFile")
	private FortuneService fortuneservice;

	// @Value("${foo.emailid}")
	private String emailid;

	// @Value("${foo.name}")
	private String name;

	// constructor injection
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneservice = fortuneService;
//	}

	// default Constructor
	public TennisCoach() {
		System.out.println("Inside Default Constructor");
	}
//
//	// Setter Injection
//	@Autowired
//	public void setFortuneservice(FortuneService fortuneservice) {
//		System.out.println("Inside Setter Method");
//		this.fortuneservice = fortuneservice;
//	}

	// init method
	@PostConstruct
	public void initiateMethod() {
		System.out.println("Inside Intiate Method");
	}

	// Destroy Method
	@PreDestroy
	public void cleanupDestroyMethos() {
		System.out.println("Inside Destroy Method");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice Backhand";
	}

	public String getEmailid() {
		return emailid;
	}

	public String getName() {
		return name;
	}

	@Override
	public String getDailyFortune() throws FileNotFoundException {
		return fortuneservice.getFortune();
	}

}
