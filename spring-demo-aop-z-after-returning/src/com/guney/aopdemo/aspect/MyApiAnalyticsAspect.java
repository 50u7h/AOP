package com.guney.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {

	@Before("com.guney.aopdemo.aspect.GuneyAopExpressions.forDaoPackageNotGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("=====>>> Perform API analytics");
	}

}
