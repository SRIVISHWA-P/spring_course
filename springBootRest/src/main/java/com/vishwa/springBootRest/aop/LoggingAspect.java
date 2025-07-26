package com.vishwa.springBootRest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // return-type full qualified class-name.method name(args)
//    @Before("execution(* *.*(..))")
    @Before("execution(* com.vishwa.springBootRest.service.JobService.getJob(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called"+" "+jp.getSignature().getName());
    }

    @After("execution(* com.vishwa.springBootRest.service.JobService.getJob(..)) || execution(* com.vishwa.springBootRest.service.JobService.updateJob(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed"+" "+jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.vishwa.springBootRest.service.JobService.getJob(..)) || execution(* com.vishwa.springBootRest.service.JobService.updateJob(..))")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method Has Some issues"+" "+jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.vishwa.springBootRest.service.JobService.getJob(..)) || execution(* com.vishwa.springBootRest.service.JobService.updateJob(..))")
    public void logMethodExecutedSuccess(JoinPoint jp){
        LOGGER.info("Method Successfully completed"+" "+jp.getSignature().getName());
    }
}
