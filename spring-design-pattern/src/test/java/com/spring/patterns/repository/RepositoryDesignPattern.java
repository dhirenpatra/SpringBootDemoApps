/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.spring.patterns.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryDesignPattern {

    @Autowired
    private PresidentRepository repository;

    @Test
    public void contextLoads() {
        System.out.println(repository.findByEmail("George.Washington@wh.gov"));
    }

}
