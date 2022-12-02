package com.guney.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advice for logging

	// start with @Before advice

	// @Before("execution(public void addAccount())")
	// @Before("execution(public void
	// com.guney.aopdemo.dao.AccountDAO.addAccount())")
	// @Before("execution(public void add*())")
	// @Before("execution(void add*())")
	// @Before("execution(* add*(..))")
	@Before("execution(* com.guney.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("=====>>> Executing @Before advice on addAccount()");
	}
}
