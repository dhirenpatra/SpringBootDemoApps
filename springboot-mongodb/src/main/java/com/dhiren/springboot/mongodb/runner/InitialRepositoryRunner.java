/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.runner;

import com.dhiren.springboot.mongodb.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class InitialRepositoryRunner implements CommandLineRunner {

    private AirportRepository repository;

    @Autowired
    public InitialRepositoryRunner(AirportRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.repository.deleteAll();
        System.err.println("Application Started... And InitialRepositoryRunner executed..");
    }

}