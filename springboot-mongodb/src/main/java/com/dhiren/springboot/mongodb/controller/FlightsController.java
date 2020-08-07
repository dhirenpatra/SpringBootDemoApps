/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.controller;

import com.dhiren.springboot.mongodb.constants.FlightType;
import com.dhiren.springboot.mongodb.entity.FlightInformation;
import com.dhiren.springboot.mongodb.query.FlightInformationQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightsController {

    private FlightInformationQueries flightInformations;

    @Autowired
    public FlightsController(FlightInformationQueries flightInformationQueries) {
        this.flightInformations = flightInformationQueries;
    }

    @GetMapping("/all/{sortOrder}")
    public List<FlightInformation> getAllFlights(@RequestParam String field, @RequestParam int pageNo,
                                                 @RequestParam int pageSize, @PathVariable String sortOrder) {
        Sort.Direction sortingOrder  = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        return flightInformations.getAllFlightsSortedByDistance(field,pageNo,pageSize, sortingOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightInformation> getFlight(@PathVariable String id) {
        final FlightInformation flightById = flightInformations.getFlightById(id);

        return flightById == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(flightById);
    }

    @GetMapping("/type/{flightType}")
    public long getFlightTypeCount(@PathVariable String flightType) {

        FlightType type = flightType.equalsIgnoreCase("international") ? FlightType.INTERNATIONAL
                : FlightType.DOMESTIC;

        return flightInformations.getFlightCategoryCount(type);
    }

    @GetMapping("/departure")
    public List<FlightInformation> getAllFlightsByDepartureCity(@RequestParam String city) {
       return flightInformations.findByDepartureCity(city);
    }

    @GetMapping("/duration")
    public List<FlightInformation> getAllFlightsWithinDurationOf(@RequestParam int min, @RequestParam int max) {
        return flightInformations.findByDurationBetween(min, max);
    }

    @GetMapping("/flights/delayed")
    public List<FlightInformation> getAllFlightsDelayedFromDepartureCity(@RequestParam String city) {
        return flightInformations.findFlightsDelayedAtACity(city);
    }

    @GetMapping("/flights/timely")
    public List<FlightInformation> getAllFlightsOnTimeFromACity(@RequestParam String city) {
        return flightInformations.findFlightsOnTimeAndRelatedToCity(city);
    }

    @GetMapping("/flights")
    public List<FlightInformation> getAllFlightsOfModel(@RequestParam String model) {
        return flightInformations.findFlightsByModel(model);
    }

    @PutMapping("/flights")
    public List<FlightInformation> updateAllFlightsStatus(@RequestParam String destination,
                                                          @RequestParam boolean status) {
        return flightInformations.updateStatusOfFlightsTo(destination, status);
    }

}
