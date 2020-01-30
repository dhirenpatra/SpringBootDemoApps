package org.dhiren.springcore.lifecycle.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Patient implements InitializingBean, DisposableBean {
    private int id;

    public int getId() {
        return id;
    }

    @Required
    public void setId(int id) {
        System.out.println("Inside Setter");
        this.id = id;
    }

    public void hi() {
        System.err.println("****************");
        System.err.println("****************");
        System.out.println("Hello Everyone");
    }

    public void bye() {
        System.err.println("****************");
        System.err.println("****************");
        System.out.println("Good Bye");
    }

    @PostConstruct
    public void hiFromPostConstruct() {
        System.err.println("****************");
        System.err.println("****************");
        System.out.println("Hello Everyone from post construct");
    }

    @PreDestroy
    public void byeFromPreDestroy() {
        System.err.println("****************");
        System.err.println("****************");
        System.out.println("Good Bye from pre destroy");
    }

    @Override
    public void destroy() throws Exception {
        System.err.println("****************");
        System.err.println("****************");
        System.out.println("Good Bye from destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("****************");
        System.err.println("****************");
        System.out.println("Hello Everyone from afterPropertiesSet()");
    }
}
