package com.practise.spingBoot.aop.firstspringbootaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AroundAspect {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Around("com.practise.spingBoot.aop.firstspringbootaop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime=System.currentTimeMillis();
		joinPoint.proceed();
		long timetaken=System.currentTimeMillis()-startTime;
		
		logger.info("Time taken by {} is {}",joinPoint,timetaken);
		
		
	}

}
