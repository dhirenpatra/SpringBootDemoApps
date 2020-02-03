package org.dhiren.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LoginAspect {

    @Before("execution(* org.dhiren.spring.service.bo.BusinessService.result(..))")
    public void loginBefore(JoinPoint joinPoint) {
        System.err.println("Before BusinessService Service");
    }

    @After("execution(public int org.dhiren.spring.service.bo.BusinessService.result(..))")
    public void loginAfter(JoinPoint joinPoint) {
        System.err.println("After BusinessService Service");
    }

    @Before("execution(* org.dhiren.spring.service.ProductServiceImpl.multiply(..))")
    public void loginBeforeProductService(JoinPoint joinPoint) {
        System.err.println("Before ProductService Service");
    }

    @After("execution(public int org.dhiren.spring.service.ProductServiceImpl.multiply(..))")
    public void loginAfterProductService(JoinPoint joinPoint) {
        System.err.println("After ProductService Service");
    }
}
