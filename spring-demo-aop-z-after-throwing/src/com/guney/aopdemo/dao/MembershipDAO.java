package com.guney.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addTest() {
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT\n");

		return true;
	}

	public void goToSleep() {
		System.out.println(getClass() + ": I'm going to sleep now...\n");
	}
}
