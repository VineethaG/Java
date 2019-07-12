package com.demo.autowire;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneReadingfromFile implements FortuneService {

	ArrayList<String> array;
	Random randomNo = new Random();

	public RandomFortuneReadingfromFile() {
		System.out.println("Fortune Constructor Called///");
		//File theFile = new File("src/ListOfFortunes.txt");
		array = new ArrayList<String>();
		//System.out.println(theFile.exists());
		try {
		    Scanner inFile1 = new Scanner(new File("src/ListOfFortunes.txt")).useDelimiter(",\\s*");
			//BufferedReader br = new BufferedReader(new FileReader(theFile));
			//String tempString;
			//while ((tempString = br.readLine()) != null) {
				//array.add(tempString);
		//	}
			
			while (inFile1.hasNext()) {
				String string = (String) inFile1.next();
				array.add(string);
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// init method
	@PostConstruct
	public void initiateMethod() {
		System.out.println("Inside Fortune Intiate Method");
	}

	// Destroy Method
	@PreDestroy
	public void cleanupDestroyMethos() {
		System.out.println("Inside Fortune Destroy Method");
	}
	
	@Override
	public String getFortune() {
		int randomNumber = randomNo.nextInt(array.size());
		return array.get(randomNumber);
	}

}
