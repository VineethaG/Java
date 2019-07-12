package com.demo.autowire;

import java.io.FileNotFoundException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp2 {

	public static void main(String[] args) throws FileNotFoundException {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve the bean from spring container
		TennisCoach thecoach = context.getBean("tennisCoach", TennisCoach.class);
		
		// call the methods
		System.out.println(thecoach.getDailyWorkout());
		System.out.println(thecoach.getDailyFortune());
		System.out.println(thecoach.getEmailid());
		System.out.println(thecoach.getName());

		//Close the context
		context.close();
	}

}
