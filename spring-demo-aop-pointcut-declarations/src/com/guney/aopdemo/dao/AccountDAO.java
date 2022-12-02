package com.guney.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.guney.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vip) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT\n");
	}

	public boolean doWork() {
		System.out.println(getClass() + ": doWork()\n");
		
		return false;
	}
}
