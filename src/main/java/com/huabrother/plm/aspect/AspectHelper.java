package com.huabrother.plm.aspect;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * chenwenhua
 * 2018\8\23 0023
 * 10:40
 */
@Component
@Aspect
public class AspectHelper {

    private final static  Logger log = LoggerFactory.getLogger(AspectHelper.class);

    @Pointcut("execution(public * com.huabrother.plm.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        log.info("url={}",request.getRequestURI());
        //method
        log.info("method={}",request.getMethod());
        //ip
        log.info("ip={}",request.getRemoteAddr()+":"+request.getRemotePort());
        //类方法
        log.info("class_name={}",joinPoint.getSignature().getDeclaringTypeName()+"---"+joinPoint.getSignature().getName());
        //参数
        log.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        log.info("after");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        log.info("return={}",object.toString());
    }

}
