package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {
	// Pointcut declaration for dao package
	@Pointcut("execution(* com.luv2code.aopdemo.*.*.*(..))")
	private void forDaoPackage() {
	}
	// Create Pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.*.*.get*(..))")
	private void getter() {
	}
	// Create Pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.*.*.set*(..))")
	private void setter() {
	}
	
	// Create Pointcut to include package.. exclude getters and setters
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDAOPackageNoGeterSetter() {
	}
	
	@Before("forDAOPackageNoGeterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n==========>>> Executing @Before Advice on addAccount()");
	}
	@Before("forDAOPackageNoGeterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n==========>>> Executing @Before Performing API Analytics()");
	}


}
