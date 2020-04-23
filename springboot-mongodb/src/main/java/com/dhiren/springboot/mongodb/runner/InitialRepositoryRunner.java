/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.runner;

import com.dhiren.springboot.mongodb.repository.AirportRepository;
import com.dhiren.springboot.mongodb.repository.FlightRepository;
import com.dhiren.springboot.mongodb.repository.FlightDetailsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class InitialRepositoryRunner implements CommandLineRunner {

    private FlightRepository flightRepository;
    private AirportRepository airportRepository;
    private FlightDetailsRepository flightDetailsRepository;

    public InitialRepositoryRunner(FlightRepository flightRepository, AirportRepository airportRepository,
                                   FlightDetailsRepository flightDetailsRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
        this.flightDetailsRepository = flightDetailsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.flightRepository.deleteAll();
        this.airportRepository.deleteAll();
        this.flightDetailsRepository.deleteAll();
        System.err.println("Application Started... And InitialRepositoryRunner executed..");
    }

}