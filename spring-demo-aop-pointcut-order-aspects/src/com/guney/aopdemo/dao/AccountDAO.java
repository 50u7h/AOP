package com.guney.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.guney.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public String getName() {
		System.out.println(getClass() + ": in getName()\n");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()\n");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()\n");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()\n");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account theAccount, boolean vip) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT\n");
	}

	public boolean doWork() {
		System.out.println(getClass() + ": doWork()\n");

		return false;
	}
}
