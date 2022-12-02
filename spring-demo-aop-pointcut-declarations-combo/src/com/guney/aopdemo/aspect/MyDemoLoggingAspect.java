package com.guney.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.guney.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// create pointcut for getter methods
	@Pointcut("execution(* com.guney.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	// create pointcut for setter methods
	@Pointcut("execution(* com.guney.aopdemo.dao.*.set*(..))")
	private void setter() {
	}

	// combine pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNotGetterSetter() {
	}

	@Before("forDaoPackageNotGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("=====>>> Executing @Before advice on method");
	}

	@Before("forDaoPackageNotGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("=====>>> Perform API analytics");
	}

}
