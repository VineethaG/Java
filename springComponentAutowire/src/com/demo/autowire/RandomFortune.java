package com.demo.autowire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortune implements FortuneService {

	   ArrayList<String> array = new ArrayList<String>( 
	            Arrays.asList("fortune 1", 
	                          "fortue 2", 
	                          "fortune 3")); 
      Random randomNo = new Random();
      int randomNumber=randomNo.nextInt(array.size());

	  	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return array.get(randomNumber);
	  	}

}
