package com.njc.practice.spring.boot.logging;

import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentLogging {
	Logger logger = LoggerFactory.getLogger(StudentLogging.class);

//	@Before("execution(* com.njc.practice.spring.boot.*.*.*(..))")
//	public void getStudentLog(JoinPoint joinPoint) {
//		logger.info(joinPoint.getSignature().getName() +  " " + " method is called");
//		
//	}
//	@Before("execution(* com.njc.practice.spring.boot.*.*.*(..))")
//	public void printLogs(JoinPoint joinPoint) {
//		logger.info(joinPoint.getSignature().getName() + " " + " method is called");
//		for(Object arg: joinPoint.getArgs()) {
//			logger.info(arg.toString());
//		}
//		
//	
//	}
//	@After("execution(* com.njc.practice.spring.boot.*.*.*(..))")
//	public void printLogsAfterMethodCalls(JoinPoint jp) {
//		logger.info(jp.getSignature().getName() + " execution ended" );
//		logger.info(jp.getSignature().getDeclaringTypeName() + " Parameter");
//	}
//	
//	@AfterThrowing(value = "execution(* com.njc.practice.spring.boot.*.*.*(..))", throwing = "ex")
//	public void printException(JoinPoint jp, Exception ex) {
//		logger.error(jp.getSignature().getName() + " Method has this exception " + ex.getMessage());
//	}
//
//	@AfterReturning(pointcut = "execution(* com.njc.practice.spring.boot.*.*.*(..))", returning = "result")
//	public void printAfterMethodExecution(JoinPoint jp, Object result) {
//		logger.info(jp.getSignature().getName() + " completed ");
//	}
//	@Around("execution(* com.njc.practice.spring.boot.*.*.*(..))")
//	public void aroundAdviceLoggs(JoinPoint jp) {
//		logger.info(jp.getSignature().getName() + "  around advice");
//	}
}
