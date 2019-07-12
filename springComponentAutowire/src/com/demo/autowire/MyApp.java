package com.demo.autowire;

import java.io.FileNotFoundException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) throws FileNotFoundException {

		// load the spring configuration file
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		// retrieve the bean from spring container
		Coach thecoach = context.getBean("tennisCoach", Coach.class);
		Coach thecoach2 = context.getBean("tennisCoach", Coach.class);
		if(thecoach == thecoach2) System.out.println("Singleton Scope: Same Object");
		else System.out.println("Prototye Scope: different Objects");
		System.out.println(thecoach);
		System.out.println(thecoach2);

		// call the methods
		System.out.println(thecoach.getDailyWorkout());
		System.out.println(thecoach.getDailyFortune());

		//Close the context
		context.close();
	}

}
