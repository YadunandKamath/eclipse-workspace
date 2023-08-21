package com.luv2code.constructorinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LazyDemoApplication {

	public static void main(String[] args) {
		System.out.println("In main - before");
		SpringApplication.run(LazyDemoApplication.class, args);
		System.out.println("In main - after");
	}

}
