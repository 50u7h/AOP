package com.guney.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.guney.aopdemo.dao.AccountDAO;
import com.guney.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read the config java files
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// get membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call the business method
		Account tempAccount = new Account();
		theAccountDAO.addAccount(tempAccount, true);
		theAccountDAO.doWork();

		// call the account getter/setter methods
		theAccountDAO.setName("TEST");
		theAccountDAO.setServiceCode("gold");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addTest();
		theMembershipDAO.goToSleep();

		// close the context
		context.close();

	}

}
