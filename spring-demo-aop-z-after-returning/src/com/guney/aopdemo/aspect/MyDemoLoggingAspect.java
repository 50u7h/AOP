package com.guney.aopdemo.aspect;

import java.util.Iterator;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.guney.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut = "execution(* com.guney.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>>>> Executing @AfterResulting on method: " + method);

		// print out the results of the method call
		System.out.println("=====>>> Result is: " + result);

		// post-process the data
		// convert the account names to uppercase
		converAccountNamesToUppercase(result);
		System.out.println("=====>>> Result is: " + result);
	}

	private void converAccountNamesToUppercase(List<Account> result) {

		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
	}

	@Before("com.guney.aopdemo.aspect.GuneyAopExpressions.forDaoPackageNotGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinpoint) {

		System.out.println("=====>>> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSign = (MethodSignature) theJoinpoint.getSignature();
		System.out.println("Method: " + methodSign + "\n");

		// display method arguments
		// get args
		Object[] args = theJoinpoint.getArgs();

		// loop through args
		for (Object tempArg : args) {
			System.out.println(tempArg);

			if (tempArg instanceof Account) {

				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());

			}
		}

	}

}
