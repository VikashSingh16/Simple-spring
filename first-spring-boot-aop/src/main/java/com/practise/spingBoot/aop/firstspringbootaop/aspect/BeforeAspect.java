package com.practise.spingBoot.aop.firstspringbootaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


//AOP
//Configuration
@Aspect
@Configuration
public class BeforeAspect {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	//What kind of 	method calls i would intercept
	//execution(* PACKAGE.*.*(..))
	
	@Before("execution(* com.practise.spingBoot.aop.firstspringbootaop.business .*.*(..))")
	public void before(JoinPoint jointPoint) {
		
		logger.info("Intercept execution for {}",jointPoint);
	}

}
