package com.quibar.test.prices.infra.config;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApiLog {

	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	private void inController() {
		// Do nothing because it is a point
	}

	@Before("inController()")
	public void apiRequestLog(JoinPoint point) {
		var log = point.getSignature().getName()
					.concat(" request:");
		for (Object obj : point.getArgs()) {
			log =log.concat(" {},");
		}
		LogManager.getLogger(point.getSignature().getDeclaringTypeName()).info(log, point.getArgs());
	}
	
	@AfterReturning(pointcut = "inController()", returning = "result")
	public void apiResponseLog(JoinPoint point, Object result) {
		var log = "Return -> ".concat(point.getSignature().getName()).concat(" response: {}");
		LogManager.getLogger(point.getSignature().getDeclaringTypeName()).info(log, result);
	}
	
	@AfterThrowing(pointcut = "inController()", throwing = "exception")
	public void apiThrowExceptionLog(JoinPoint point, Exception exception) {
		var log = "Throw exception -> ".concat(point.getSignature().getName()).concat(" exception: {}");
		LogManager.getLogger(point.getSignature().getDeclaringTypeName()).info(log, exception.getClass().getSimpleName());
	}
	
}
