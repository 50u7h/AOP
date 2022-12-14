package com.guney.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.guney.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read the config java files
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMain Program: AroundDemoApp");
		System.out.println("Calling getFortune()");
		String data = theFortuneService.getFortune();
		System.out.println("My fortune is: " + data);
		System.out.println("Finished");

		// close the context
		context.close();

	}

}
