package com.practise.spingBoot.aop.firstspringbootaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@AfterReturning(value="execution(* com.practise.spingBoot.aop.firstspringbootaop.business .*.*(..))",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result) {
		logger.info("{} returned with value {}",joinPoint,result);
	}

	@After(value="execution(* com.practise.spingBoot.aop.firstspringbootaop.business .*.*(..))")
	public void after(JoinPoint joinPointt) {
		logger.info("after execution of  {}",joinPointt);
	}
}
