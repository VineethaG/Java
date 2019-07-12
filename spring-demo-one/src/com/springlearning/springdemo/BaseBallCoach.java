package com.springlearning.springdemo;

public class BaseBallCoach implements Coach {
	private FortuneService fortuneservice;
	private String emailid;
	private String name;

	//Constructor Injection of furtune service
	// public BaseBallCoach(FortuneService fortuneservice) {
	// this.fortuneservice = fortuneservice;
	// }

	// No Arg Constructor
	public BaseBallCoach() {
		System.out.println("No Arg Constructor");
	}

	// Injecting the fortune service(HappyFortune is the implementation
	// for the FortuneSerice interface) using setter injection
	public void setFortuneservice(FortuneService fortuneservice) {
		System.out.println("Inside Setter");
		this.fortuneservice = fortuneservice;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		System.out.println("Inside emailid setter");
		this.emailid = emailid;
	}

	public String getName() {
		System.out.println("Inside name Setter");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDailyWorkout() {
		return "Spend 30 min on batting practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneservice.getFortune();
	}

}
