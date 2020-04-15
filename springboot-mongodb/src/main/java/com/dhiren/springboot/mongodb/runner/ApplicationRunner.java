package com.dhiren.springboot.mongodb.runner;

import com.dhiren.springboot.mongodb.entity.FlightInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

//@Component
public class ApplicationRunner implements CommandLineRunner {

    private MongoTemplate mongoTemplate;

    @Autowired
    public ApplicationRunner(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
        this.mongoTemplate.indexOps(FlightInformation.class);
    }

    @Override
    public void run(String... args) throws Exception {
        getFlightInfo().forEach(this.mongoTemplate::save);
        System.err.println("Application Started... And ApplicationRunner executed..");
    }

    public List<FlightInformation> getFlightInfo() {
        return Collections.emptyList();
    }
}