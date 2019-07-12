package com.springlearning.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve the bean from spring container
		BaseBallCoach thecoach = context.getBean("myCoach", BaseBallCoach.class);
		// call the methods
		System.out.println(thecoach.getDailyWorkout());
		System.out.println(thecoach.getDailyFortune());
		System.out.println(thecoach.getName());
		System.out.println(thecoach.getEmailid());

		//Close the context
		context.close();
	}

}
