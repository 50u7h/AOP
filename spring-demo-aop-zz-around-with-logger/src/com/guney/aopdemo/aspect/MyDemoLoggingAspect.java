package com.guney.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.guney.aopdemo.Account;
import com.guney.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	private Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	@Around("execution(* com.guney.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>>> Executing @Around  on method: " + method);

		// get begin timestamp
		long begin = System.currentTimeMillis();

		// execute the method
		Object result = theProceedingJoinPoint.proceed();

		// get end timestamp
		long end = System.currentTimeMillis();

		// compute duration and display it
		myLogger.info("\nTotal duration: " + (end - begin) / 1000.0);

		return result;
	}

	@After("execution(* com.guney.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>>> Executing @After (finally) on method: " + method);
	}

	@AfterThrowing(pointcut = "execution(* com.guney.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theE")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theE) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>>> Executing @AfterThrowing on method: " + method);

		// log the exception
		myLogger.info("=====>>> The exception is: " + theE);
	}

	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut = "execution(* com.guney.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>>> Executing @AfterResulting on method: " + method);

		// print out the results of the method call
		myLogger.info("=====>>> Result is: " + result);

		// post-process the data
		// convert the account names to uppercase
		converAccountNamesToUppercase(result);
		myLogger.info("=====>>> Result is: " + result);
	}

	private void converAccountNamesToUppercase(List<Account> result) {

		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
	}

	@Before("com.guney.aopdemo.aspect.GuneyAopExpressions.forDaoPackageNotGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinpoint) {

		myLogger.info("=====>>> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSign = (MethodSignature) theJoinpoint.getSignature();
		myLogger.info("Method: " + methodSign + "\n");

		// display method arguments
		// get args
		Object[] args = theJoinpoint.getArgs();

		// loop through args
		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());

			if (tempArg instanceof Account) {

				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				myLogger.info("Account name: " + theAccount.getName());
				myLogger.info("Account level: " + theAccount.getLevel());

			}
		}

	}

}
