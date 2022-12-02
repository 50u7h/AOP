package com.guney.aopdemo.service;

import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {

		// simulate a delay

		try {
			TimeUnit.SECONDS.sleep(5);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// return a fortune
		return "Expect heavy trafic this morning";

	}

	public String getFortune(boolean tripWire) {

		if (tripWire) {
			throw new RuntimeException("Maajor accident! Highway is closed!");
		}

		return getFortune();
	}
}
