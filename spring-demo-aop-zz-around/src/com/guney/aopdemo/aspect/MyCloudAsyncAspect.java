package com.guney.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudAsyncAspect {

	@Before("com.guney.aopdemo.aspect.GuneyAopExpressions.forDaoPackageNotGetterSetter()")
	public void logToCloudAsync() {
		System.out.println("=====>>> Logging to Cloud in async fashion");
	}

}
