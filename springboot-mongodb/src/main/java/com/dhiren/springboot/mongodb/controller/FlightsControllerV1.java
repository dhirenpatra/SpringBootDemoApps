/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.controller;

import com.dhiren.springboot.mongodb.constants.FlightType;
import com.dhiren.springboot.mongodb.entity.FlightInformation;
import com.dhiren.springboot.mongodb.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class FlightsControllerV1 {

    private FlightRepository airportRepository;

    @Autowired
    public FlightsControllerV1(FlightRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @GetMapping("/all/{sortOrder}")
    public List<FlightInformation> getAllFlights(@RequestParam String field, @RequestParam int pageNo,
                                                 @RequestParam int pageSize, @PathVariable String sortOrder) {
        Sort.Direction sortingOrder  = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        return airportRepository.findAll(PageRequest.of(pageNo,pageSize,sortingOrder,field)).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightInformation> getFlight(@PathVariable String id) {
        final Optional<FlightInformation> flightById = airportRepository.findById(id);

        return ! flightById.isPresent() ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(flightById.get());
    }

    @GetMapping("/type/{flightType}")
    public long getFlightTypeCount(@PathVariable String flightType) {

        FlightType type = flightType.equalsIgnoreCase("international") ? FlightType.INTERNATIONAL
                : FlightType.DOMESTIC;

        return airportRepository.findByFlightTypeEquals(type).size();
    }

    @GetMapping("/departure")
    public List<FlightInformation> getAllFlightsByDepartureCity(@RequestParam String city) {
       return airportRepository.findByDepartureCity(city);
    }

    @GetMapping("/duration")
    public List<FlightInformation> getAllFlightsWithinDurationOf(@RequestParam int min, @RequestParam int max) {
        return airportRepository.findByDurationMinBetweenOrderByDurationMinAsc(min, max);
    }

    @GetMapping("/flights/delayed")
    public List<FlightInformation> getAllFlightsDelayedFromDepartureCity(@RequestParam String city) {
        return airportRepository.findByDepartureCityAndIsDelayedTrue(city);
    }

    @GetMapping("/flights/timely")
    public List<FlightInformation> getAllFlightsOnTimeFromACity(@RequestParam String city) {
        return airportRepository.findByDepartureCityOrDestinationCityAndIsDelayedFalse(city,city)
                .stream().filter(flightInformation -> flightInformation.isDelayed() == false)
                .collect(Collectors.toList());
    }

    @GetMapping("/flights")
    public List<FlightInformation> getAllFlightsOfModel(@RequestParam String model) {
        return airportRepository.findFlightsByModel(model);
    }

    @PutMapping("/flights")
    public List<FlightInformation> updateAllFlightsStatus(@RequestParam String destination,
                                                          @RequestParam boolean status) {
        return airportRepository.updateStatusOfFlightsOf(destination, status);
    }

}
