package com.training.model.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Around("@annotation(com.training.model.service.Loggable)")
	public Object logging(ProceedingJoinPoint pjp) throws Throwable {
		Object result = pjp.proceed();
		logger.info("The Deleted Book is " + pjp.getSignature());
		return result;
	}
}
