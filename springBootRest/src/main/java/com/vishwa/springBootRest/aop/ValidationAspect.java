package com.vishwa.springBootRest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.vishwa.springBootRest.service.JobService.getJob(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {
        LOGGER.info("Entered around");
        if(postId < 0) {
            postId = -postId;
            LOGGER.info("Updated Post ID"+"for"+jp.getSignature().getName());
        }
        Object obj = jp.proceed(new Object[]{postId});
        return obj;
    }
}
