/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.runner;

import com.dhiren.springboot.mongodb.constants.FlightType;
import com.dhiren.springboot.mongodb.entity.*;
import com.dhiren.springboot.mongodb.repository.FlightRepository;
import com.dhiren.springboot.mongodb.repository.FlightRepositoryV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Order(3)
public class MongoRepositoryRunner implements CommandLineRunner {

    private FlightRepository repository;
    private FlightRepositoryV1 repositoryV1;

    @Autowired
    public MongoRepositoryRunner(FlightRepository repository, FlightRepositoryV1 repositoryV1) {
        this.repository = repository;
        this.repositoryV1 = repositoryV1;
    }

    @Override
    public void run(String... args) throws Exception {
        this.repository.saveAll(getFlightLists());
        this.repositoryV1.saveAll(getFlightsLists());
        System.err.println("Application Started... And MongoRepositoryRunner executed..");
    }

    private List<FlightInformation> getFlightLists() {

        List<FlightInformation> flightsList = new ArrayList<>();

        flightsList.add(new FlightInformation("Ahmedabad", "Pune",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Indigo", 250)));
        flightsList.add(new FlightInformation("Ahmedabad", "Chennai",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Indigo", 250)));
        flightsList.add(new FlightInformation("Pune", "Ahmedabad",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Indigo", 250)));
        flightsList.add(new FlightInformation("Chennai", "Ahmedabad",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Indigo", 250)));
        flightsList.add(new FlightInformation("Ahmedabad", "Pune",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Air India", 350)));
        flightsList.add(new FlightInformation("Ahmedabad", "Chennai",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Air India", 350)));
        flightsList.add(new FlightInformation("Pune", "Ahmedabad",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Air India", 350)));
        flightsList.add(new FlightInformation("Chennai", "Ahmedabad",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Air India", 350)));

        flightsList.add(new FlightInformation("Ahmedabad", "Pune",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Vitara Air", 280)));
        flightsList.add(new FlightInformation("Ahmedabad", "Chennai",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Vitara Air", 280)));
        flightsList.add(new FlightInformation("Pune", "Ahmedabad",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Vitara Air", 280)));
        flightsList.add(new FlightInformation("Chennai", "Ahmedabad",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Vitara Air", 280)));
        flightsList.add(new FlightInformation("Ahmedabad", "Pune",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Air Asia", 300)));
        flightsList.add(new FlightInformation("Ahmedabad", "Chennai",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Air Asia", 300)));
        flightsList.add(new FlightInformation("Pune", "Ahmedabad",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Air Asia", 300)));
        flightsList.add(new FlightInformation("Chennai", "Ahmedabad",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Air Asia", 300)));

        flightsList.add(new FlightInformation("Ahmedabad", "New York",
                FlightType.INTERNATIONAL, false, 420, LocalDate.now(), new Aircraft("American Carrier", 550)));
        flightsList.add(new FlightInformation("Ahmedabad", "London",
                FlightType.INTERNATIONAL, true, 480, LocalDate.now(), new Aircraft("American Carrier", 550)));
        flightsList.add(new FlightInformation("London", "Ahmedabad",
                FlightType.INTERNATIONAL, true, 340, LocalDate.now(), new Aircraft("London Times", 500)));
        flightsList.add(new FlightInformation("New York", "Ahmedabad",
                FlightType.INTERNATIONAL, false, 350, LocalDate.now(), new Aircraft("London Times", 500)));
        flightsList.add(new FlightInformation("California", "Ahmedabad",
                FlightType.INTERNATIONAL, true, 650, LocalDate.now(), new Aircraft("Ahmedabad Air", 450)));
        flightsList.add(new FlightInformation("Ahmedabad", "California",
                FlightType.INTERNATIONAL, false, 660, LocalDate.now(), new Aircraft("Ahmedabad Air", 450)));

        flightsList.add(new FlightInformation("Jaipur", "Nagpur",
                FlightType.DOMESTIC, false, 100, LocalDate.now(), new Aircraft("Jaipur Air", 150)));
        flightsList.add(new FlightInformation("Nagpur", "Jaipur",
                FlightType.DOMESTIC, false, 100, LocalDate.now(), new Aircraft("Jaipur Air", 150)));
        flightsList.add(new FlightInformation("Jaipur", "Nagpur",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Nagpur Air", 250)));
        flightsList.add(new FlightInformation("Nagpur", "Jaipur",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Nagpur Air", 250)));

        return Collections.unmodifiableList(flightsList);
    }

    private List<FlightInformationV1> getFlightsLists() {

        List<FlightInformationV1> flightsList = new ArrayList<>();

        flightsList.add(new FlightInformationV1("Ahmedabad", "Pune",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new AircraftV1("Indigo", 250)));
        flightsList.add(new FlightInformationV1("Ahmedabad", "Chennai",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new AircraftV1("Indigo", 250)));
        flightsList.add(new FlightInformationV1("Pune", "Ahmedabad",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new AircraftV1("Indigo", 250)));
        flightsList.add(new FlightInformationV1("Chennai", "Ahmedabad",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new AircraftV1("Indigo", 250)));
        flightsList.add(new FlightInformationV1("Ahmedabad", "Pune",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new AircraftV1("Air India", 350)));
        flightsList.add(new FlightInformationV1("Ahmedabad", "Chennai",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new AircraftV1("Air India", 350)));
        flightsList.add(new FlightInformationV1("Pune", "Ahmedabad",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new AircraftV1("Air India", 350)));
        flightsList.add(new FlightInformationV1("Chennai", "Ahmedabad",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new AircraftV1("Air India", 350)));

        flightsList.add(new FlightInformationV1("Ahmedabad", "Pune",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new AircraftV1("Vitara Air", 280)));
        flightsList.add(new FlightInformationV1("Ahmedabad", "Chennai",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new AircraftV1("Vitara Air", 280)));
        flightsList.add(new FlightInformationV1("Pune", "Ahmedabad",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new AircraftV1("Vitara Air", 280)));
        flightsList.add(new FlightInformationV1("Chennai", "Ahmedabad",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new AircraftV1("Vitara Air", 280)));
        flightsList.add(new FlightInformationV1("Ahmedabad", "Pune",
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new AircraftV1("Air Asia", 300)));
        flightsList.add(new FlightInformationV1("Ahmedabad", "Chennai",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new AircraftV1("Air Asia", 300)));
        flightsList.add(new FlightInformationV1("Pune", "Ahmedabad",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new AircraftV1("Air Asia", 300)));
        flightsList.add(new FlightInformationV1("Chennai", "Ahmedabad",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new AircraftV1("Air Asia", 300)));

        flightsList.add(new FlightInformationV1("Ahmedabad", "New York",
                FlightType.INTERNATIONAL, false, 420, LocalDate.now(), new AircraftV1("American Carrier", 550)));
        flightsList.add(new FlightInformationV1("Ahmedabad", "London",
                FlightType.INTERNATIONAL, true, 480, LocalDate.now(), new AircraftV1("American Carrier", 550)));
        flightsList.add(new FlightInformationV1("London", "Ahmedabad",
                FlightType.INTERNATIONAL, true, 340, LocalDate.now(), new AircraftV1("London Times", 500)));
        flightsList.add(new FlightInformationV1("New York", "Ahmedabad",
                FlightType.INTERNATIONAL, false, 350, LocalDate.now(), new AircraftV1("London Times", 500)));
        flightsList.add(new FlightInformationV1("California", "Ahmedabad",
                FlightType.INTERNATIONAL, true, 650, LocalDate.now(), new AircraftV1("Ahmedabad Air", 450)));
        flightsList.add(new FlightInformationV1("Ahmedabad", "California",
                FlightType.INTERNATIONAL, false, 660, LocalDate.now(), new AircraftV1("Ahmedabad Air", 450)));

        flightsList.add(new FlightInformationV1("Jaipur", "Nagpur",
                FlightType.DOMESTIC, false, 100, LocalDate.now(), new AircraftV1("Jaipur Air", 150)));
        flightsList.add(new FlightInformationV1("Nagpur", "Jaipur",
                FlightType.DOMESTIC, false, 100, LocalDate.now(), new AircraftV1("Jaipur Air", 150)));
        flightsList.add(new FlightInformationV1("Jaipur", "Nagpur",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new AircraftV1("Nagpur Air", 250)));
        flightsList.add(new FlightInformationV1("Nagpur", "Jaipur",
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new AircraftV1("Nagpur Air", 250)));

        return Collections.unmodifiableList(flightsList);
    }
}