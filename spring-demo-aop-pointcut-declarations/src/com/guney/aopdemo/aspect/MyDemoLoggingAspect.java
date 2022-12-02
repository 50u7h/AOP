package com.guney.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

	@Pointcut("execution(* com.guney.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("=====>>> Executing @Before advice on method");
	}

	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("=====>>> Perform API analytics");
	}
}
