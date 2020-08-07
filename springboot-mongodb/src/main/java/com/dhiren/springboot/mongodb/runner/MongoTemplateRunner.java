/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.runner;

import com.dhiren.springboot.mongodb.constants.FlightType;
import com.dhiren.springboot.mongodb.entity.Aircraft;
import com.dhiren.springboot.mongodb.entity.FlightInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Order(2)
public class MongoTemplateRunner implements CommandLineRunner {

    private MongoTemplate mongoTemplate;

    @Autowired
    public MongoTemplateRunner(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        this.mongoTemplate.insertAll(getFlightsList());
        System.err.println("Application Started... And MongoTemplateRunner executed..");
    }

    private List<FlightInformation> getFlightsList() {
        List<FlightInformation> flightsList = new ArrayList<>();

        flightsList.add(new FlightInformation("Bangalore", "Bhubaneswar",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Indigo", 250)));
        flightsList.add(new FlightInformation("Bangalore", "Kolkata",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Indigo", 250)));
        flightsList.add(new FlightInformation("Bhubaneswar", "Bangalore",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Indigo", 250)));
        flightsList.add(new FlightInformation("Kolkata", "Bangalore",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Indigo", 250)));
        flightsList.add(new FlightInformation("Bangalore", "Bhubaneswar",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Air India", 350)));
        flightsList.add(new FlightInformation("Bangalore", "Kolkata",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Air India", 350)));
        flightsList.add(new FlightInformation("Bhubaneswar", "Bangalore",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Air India", 350)));
        flightsList.add(new FlightInformation("Kolkata", "Bangalore",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Air India", 350)));

        flightsList.add(new FlightInformation("Bangalore", "Bhubaneswar",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Vitara Air", 280)));
        flightsList.add(new FlightInformation("Bangalore", "Kolkata",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Vitara Air", 280)));
        flightsList.add(new FlightInformation("Bhubaneswar", "Bangalore",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Vitara Air", 280)));
        flightsList.add(new FlightInformation("Kolkata", "Bangalore",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Vitara Air", 280)));
        flightsList.add(new FlightInformation("Bangalore", "Bhubaneswar",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Air Asia", 300)));
        flightsList.add(new FlightInformation("Bangalore", "Kolkata",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Air Asia", 300)));
        flightsList.add(new FlightInformation("Bhubaneswar", "Bangalore",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Air Asia", 300)));
        flightsList.add(new FlightInformation("Kolkata", "Bangalore",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Air Asia", 300)));

        flightsList.add(new FlightInformation("Bangalore", "New York",
                FlightType.INTERNATIONAL, false, 420, LocalDate.now(), new Aircraft("American Carrier", 550)));
        flightsList.add(new FlightInformation("Bangalore", "London",
                FlightType.INTERNATIONAL, true, 480, LocalDate.now(), new Aircraft("American Carrier", 550)));
        flightsList.add(new FlightInformation("London", "Bangalore",
                FlightType.INTERNATIONAL, true, 340, LocalDate.now(), new Aircraft("London Times", 500)));
        flightsList.add(new FlightInformation("New York", "Bangalore",
                FlightType.INTERNATIONAL, false, 350, LocalDate.now(), new Aircraft("London Times", 500)));
        flightsList.add(new FlightInformation("California", "Bangalore",
                FlightType.INTERNATIONAL, true, 650, LocalDate.now(), new Aircraft("Bangalore Air", 450)));
        flightsList.add(new FlightInformation("Bangalore", "California",
                FlightType.INTERNATIONAL, false, 660, LocalDate.now(), new Aircraft("Bangalore Air", 450)));

        flightsList.add(new FlightInformation("Mumbai", "Delhi",
                FlightType.DOMESTIC, false, 100, LocalDate.now(), new Aircraft("Mumbai Air", 150)));
        flightsList.add(new FlightInformation("Delhi", "Mumbai",
                FlightType.DOMESTIC, false, 100, LocalDate.now(), new Aircraft("Mumbai Air", 150)));
        flightsList.add(new FlightInformation("Mumbai", "Delhi",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Delhi Air", 250)));
        flightsList.add(new FlightInformation("Delhi", "Mumbai",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Delhi Air", 250)));

        return flightsList;

    }
}