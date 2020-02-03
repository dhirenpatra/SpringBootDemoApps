package org.dhiren.spring;

import org.dhiren.spring.service.bo.BusinessService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"aop-config.xml"});
        BusinessService service = (BusinessService) context.getBean("businessService");
        System.out.println(service.result(2,3));
    }
}
