package com.springmvc.demo;

import java.util.LinkedHashMap;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {

	private String firstName;

	@NotNull(message = "Required")
	@Size(min = 2,max = 10, message = "minimum 2 characters and max 10 characters")
	
	private String lastName;
	private String country;
	private LinkedHashMap<String, String> countryOptions;
	private String favLanguage;
	private String operatingSystems;
	private LinkedHashMap<String, String> OSOptions;

	public Student() {
		countryOptions = new LinkedHashMap<String, String>();
		countryOptions.put("IN", "India");
		countryOptions.put("BR", "Brazil");
		countryOptions.put("DE", "Germany");
		countryOptions.put("FR", "France");
		countryOptions.put("USA", "United States of America");
		OSOptions = new LinkedHashMap<String, String>();
		OSOptions.put("LINUX", "LINUX");
		OSOptions.put("Windows", "Windows");
		OSOptions.put("MAC OS", "MAC OS");

	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFavLanguage() {
		return favLanguage;
	}

	public void setFavLanguage(String favLanguage) {
		this.favLanguage = favLanguage;
	}

	public String getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public LinkedHashMap<String, String> getOSOptions() {
		return OSOptions;
	}

}
