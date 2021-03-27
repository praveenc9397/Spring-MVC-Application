package com.ps.springmvc.psbankapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;//Jboss
import org.springframework.stereotype.Component;



@Aspect
@Component
public class PSBankLoggingAspect {
	private Logger logger=Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.ps.springmvc.psbankapp.controllers.*.*(..))")
	private void forControllersPackage() {
		
	}
	
	@Pointcut("execution(* com.ps.springmvc.psbankapp.services.*.*(..))")
	private void forSrvicesPackage() {
		
	}
	
	@Pointcut("execution(* com.ps.springmvc.psbankapp.dao.*.*(..))")
	private void forDAOPackage() {
		
	}
	
	//Pointcut to refer All Above Packages
	@Pointcut("forControllersPackage() || forSrvicesPackage() || forDAOPackage()")
	private void forApplication() {}
	
	//Advise for pointcut
	@Before("forApplication()")
	public void before(JoinPoint joinPoint) {
		//This Statement will return name of method which is invoked
		String methodName=joinPoint.getSignature().toShortString();
		//To Log the Method name
		logger.info("Information: In @Before Advise: Calling the method :"+methodName);
	}
	
	@AfterReturning(pointcut="forApplication()",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result) {
				//This Statement will return name of method which is invoked
				String methodName=joinPoint.getSignature().toShortString();
				//To Log the Method name
				logger.info("Information: In @Before Advise: Calling the method :"+methodName);
				logger.info("Information: Data Returned by the method :"+result);;
	}
}
