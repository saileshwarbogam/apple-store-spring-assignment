package com.sailesh.springproject.applestore.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.logging.Logger;

public class LoggingAspect {
    private Logger myLogger = Logger.getLogger(getClass().getName());


    @Pointcut("execution(* com.sailesh.springproject.controller.*.*(..))")
    private  void forControllerPackage(){}

    @Before("forControllerPackage()")
    public void before(JoinPoint joinPoint){

        //display method we are callingforDaoPackage()
        String method = joinPoint.getSignature().toShortString();

        myLogger.info("==========>> @Before : calling method : "+method);

        Object[] args = joinPoint.getArgs();

        //display args
        for(Object tempArg: args){
            myLogger.info("====>> argument: "+tempArg);
        }

    }

    @AfterReturning(
            pointcut = "forControllerPackage()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result){

        //display method we are returning from
        String theMethod = joinPoint.getSignature().toShortString();
        myLogger.info("=======>> in @AfterReturning: from method: "+theMethod);


        //display data returned

        myLogger.info("=====>> result: "+result);

    }

}
