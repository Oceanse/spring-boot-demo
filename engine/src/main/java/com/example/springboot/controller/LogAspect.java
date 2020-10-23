package com.example.springboot.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;


@Aspect
@Service
public class LogAspect {
    private static final Logger LOGGER = LogManager.getLogger(BasicAnnotationController.class);
    private static final SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    @Pointcut("execution(* com.example.springboot.aop.AOPCotroller.*(..))")
    public void printLog(){ }//签名，可以理解成这个切入点的一个名称


    @Before("printLog()") //等价于：@Before("execution(* com.example.springboot.aop.AOPCotroller.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("------------------aopTest() 方法执行前-------------------");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = null;
        if (requestAttributes != null) {
            request = requestAttributes.getRequest();
        }
        if (request != null) {
            LOGGER.debug("Request ur is: " + request.getRequestURL().toString());
        }
        LOGGER.debug("Target method of the request is: " + joinPoint.getSignature());
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            LOGGER.debug("The parameter of the target method is: " + Arrays.toString(args));
        }
    }


    @AfterReturning(returning = "result", pointcut = "printLog()")
    public void after(Object result){
        System.out.println("------------------aopTest() 方法执行后-------------------");
        long endTime = System.currentTimeMillis();
        LOGGER.debug("Execution successfuly at " + dateformat.format(endTime));
        LOGGER.debug("Return value is: " + result.toString());
    }



}
