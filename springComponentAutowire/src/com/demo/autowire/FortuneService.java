package com.demo.autowire;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FortuneService {
	public String getFortune() throws FileNotFoundException;
}
