package com.guney.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.guney.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public void addAccount(Account theAccount, boolean vip) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT\n");
	}

	public boolean doWork() {
		System.out.println(getClass() + ": doWork()\n");

		return false;
	}

	// add new method: findAccounts()
	public List<Account> findAccounts() {

		List<Account> myAccounts = new ArrayList<>();
		
		// create sample accounts
		Account tempAccount1 = new Account("samet","Gold");
		Account tempAccount2 = new Account("guney","Diamond");
		Account tempAccount3 = new Account("test","Bronze");
		
		// add them to our account list
		myAccounts.add(tempAccount1);
		myAccounts.add(tempAccount2);
		myAccounts.add(tempAccount3);

		return myAccounts;

	}
}
