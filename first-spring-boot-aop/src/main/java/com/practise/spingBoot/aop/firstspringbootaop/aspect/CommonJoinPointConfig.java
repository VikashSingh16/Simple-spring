package com.practise.spingBoot.aop.firstspringbootaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
	
	@Pointcut("execution(* com.practise.spingBoot.aop.firstspringbootaop.data .*.*(..))")
	public void dataLayerExecution() {};
	
	@Pointcut("execution(* com.practise.spingBoot.aop.firstspringbootaop.business .*.*(..))")
	public void businessLayerExecution() {};
	
	
	@Pointcut("dataLayerExecution() &&  businessLayerExecution()")
	public void commonLayerExecution() {};
	
	@Pointcut("@annotation(com.practise.spingBoot.aop.firstspringbootaop.aspect.TrackTime)")
	public void trackTimeAnnotation() {};

}
