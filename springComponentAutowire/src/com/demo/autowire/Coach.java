package com.demo.autowire;

import java.io.FileNotFoundException;

public interface Coach {
	
	public String getDailyWorkout();

	public String getDailyFortune() throws FileNotFoundException;

}
