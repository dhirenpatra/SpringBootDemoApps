/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.runner;

import com.dhiren.springboot.mongodb.constants.FlightType;
import com.dhiren.springboot.mongodb.entity.Aircraft;
import com.dhiren.springboot.mongodb.entity.Airport;
import com.dhiren.springboot.mongodb.entity.FlightDetails;
import com.dhiren.springboot.mongodb.repository.AirportRepository;
import com.dhiren.springboot.mongodb.repository.FlightDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Order(4)
public class MongoRepositoryWithDBRefRunner implements CommandLineRunner {

    private static Map<String, Airport> airportMap = new HashMap<>();
    
    private AirportRepository airportRepository;
    private FlightDetailsRepository flightRepository;

    @Autowired
    public MongoRepositoryWithDBRefRunner(AirportRepository airportRepository, FlightDetailsRepository flightRepository) {
        this.airportRepository = airportRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    public void run(String... args) {
        System.err.println("Application Started... And MongoRepositoryWithDBRefRunner started..");
        this.flightRepository.saveAll(getFlightLists(instantiateAndInsertAirports()));
        System.err.println("Flight Details Being Saved");
        System.err.println("MongoRepositoryWithDBRefRunner executed..");
    }
    
    private Map<String,Airport> instantiateAndInsertAirports() {

        List<Airport> airports = new ArrayList<>();
        System.err.println("Airport Details Being Created");

        airports.add(new Airport("AIA", "Ahmedabad", 50000));
        airports.add(new Airport("PIA","Pune",60000));
        airports.add(new Airport("CIA","Chennai",70000));
        airports.add(new Airport("LIA","London",80000));
        airports.add(new Airport("NYIA","New York",100000));
        airports.add(new Airport("CAIA", "California",90000));
        airports.add(new Airport("JIA","Jaipur",45000));
        airports.add(new Airport("NIA", "Nagpur",40000));

        airportRepository.insert(airports);
        System.err.println("Airport Details Being Saved");

        return airports.stream().collect(Collectors.toUnmodifiableMap(Airport::getCity, Function.identity()));
    }

    private List<FlightDetails> getFlightLists(Map<String,Airport> airportMap) {
        System.err.println("Flight Details Being Created");
        List<FlightDetails> flightsList = new ArrayList<>();

        flightsList.add(new FlightDetails(airportMap.get("Ahmedabad"),  airportMap.get("Pune"),
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Indigo", 250)));
        flightsList.add(new FlightDetails(airportMap.get("Ahmedabad"),  airportMap.get("Chennai"),
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Indigo", 250)));
        flightsList.add(new FlightDetails( airportMap.get("Pune"), airportMap.get("Ahmedabad"),
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Indigo", 250)));
        flightsList.add(new FlightDetails( airportMap.get("Chennai"), airportMap.get("Ahmedabad"),
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Indigo", 250)));
        flightsList.add(new FlightDetails(airportMap.get("Ahmedabad"),  airportMap.get("Pune"),
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Air India", 350)));
        flightsList.add(new FlightDetails(airportMap.get("Ahmedabad"),  airportMap.get("Chennai"),
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Air India", 350)));
        flightsList.add(new FlightDetails( airportMap.get("Pune"), airportMap.get("Ahmedabad"),
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Air India", 350)));
        flightsList.add(new FlightDetails( airportMap.get("Chennai"), airportMap.get("Ahmedabad"),
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Air India", 350)));

        flightsList.add(new FlightDetails(airportMap.get("Ahmedabad"),  airportMap.get("Pune"),
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Vitara Air", 280)));
        flightsList.add(new FlightDetails(airportMap.get("Ahmedabad"),  airportMap.get("Chennai"),
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Vitara Air", 280)));
        flightsList.add(new FlightDetails( airportMap.get("Pune"), airportMap.get("Ahmedabad"),
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Vitara Air", 280)));
        flightsList.add(new FlightDetails( airportMap.get("Chennai"), airportMap.get("Ahmedabad"),
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Vitara Air", 280)));
        flightsList.add(new FlightDetails(airportMap.get("Ahmedabad"),  airportMap.get("Pune"),
                FlightType.DOMESTIC, false, 120, LocalDate.now(), new Aircraft("Air Asia", 300)));
        flightsList.add(new FlightDetails(airportMap.get("Ahmedabad"),  airportMap.get("Chennai"),
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Air Asia", 300)));
        flightsList.add(new FlightDetails( airportMap.get("Pune"), airportMap.get("Ahmedabad"),
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Air Asia", 300)));
        flightsList.add(new FlightDetails( airportMap.get("Chennai"), airportMap.get("Ahmedabad"),
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Air Asia", 300)));

        flightsList.add(new FlightDetails(airportMap.get("Ahmedabad"),  airportMap.get("New York"),
                FlightType.INTERNATIONAL, false, 420, LocalDate.now(), new Aircraft("American Carrier", 550)));
        flightsList.add(new FlightDetails(airportMap.get("Ahmedabad"),  airportMap.get("London"),
                FlightType.INTERNATIONAL, true, 480, LocalDate.now(), new Aircraft("American Carrier", 550)));
        flightsList.add(new FlightDetails( airportMap.get("London"), airportMap.get("Ahmedabad"),
                FlightType.INTERNATIONAL, true, 340, LocalDate.now(), new Aircraft("London Times", 500)));
        flightsList.add(new FlightDetails( airportMap.get("New York"), airportMap.get("Ahmedabad"),
                FlightType.INTERNATIONAL, false, 350, LocalDate.now(), new Aircraft("London Times", 500)));
        flightsList.add(new FlightDetails(airportMap.get("California"), airportMap.get("Ahmedabad"),
                FlightType.INTERNATIONAL, true, 650, LocalDate.now(), new Aircraft("Ahmedabad Air", 450)));
        flightsList.add(new FlightDetails(airportMap.get("Ahmedabad"),  airportMap.get("California"),
                FlightType.INTERNATIONAL, false, 660, LocalDate.now(), new Aircraft("Ahmedabad Air", 450)));

        flightsList.add(new FlightDetails( airportMap.get("Jaipur"),  airportMap.get("Nagpur"),
                FlightType.DOMESTIC, false, 100, LocalDate.now(), new Aircraft("Jaipur Air", 150)));
        flightsList.add(new FlightDetails( airportMap.get("Nagpur"),  airportMap.get("Jaipur"),
                FlightType.DOMESTIC, false, 100, LocalDate.now(), new Aircraft("Jaipur Air", 150)));
        flightsList.add(new FlightDetails( airportMap.get("Jaipur"),  airportMap.get("Nagpur"),
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Nagpur Air", 250)));
        flightsList.add(new FlightDetails( airportMap.get("Nagpur"),  airportMap.get("Jaipur"),
                FlightType.DOMESTIC, true, 120, LocalDate.now(), new Aircraft("Nagpur Air", 250)));

        return Collections.unmodifiableList(flightsList);
    }
}